package ca.ulaval.glo4002.theproject;

import ca.ulaval.glo4002.theproject.domain.account.Account;
import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.GenericCreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.VisaCreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.RequestRepository;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestTerminal;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionFactory;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionRequest;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Étantdonné;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response.Status;
import java.time.YearMonth;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TransactionRequestContext {

    private final String JSON_JUDGMENT = "jugement";
    private final String JSON_REFERENCE_NUMBER = "txNumeroReference";

    private final String JSON_ERROR_CODE = "codeErreur";

    private final int INVALID_CREDIT_CARD_ERROR_CODE = 1;
    private final int INVALID_AMOUNT_ERROR_CODE = 2;

    private final String A_CARD_NUMBER = "5562028007350036";
    private final String A_NEW_CARD_NUMBER = "88888888888888888";
    private final String A_VISA_CARD_NUMBER = "4539536574851";
    private final String AN_INVALID_CHECKSUM_VISA_CARD_NUMBER = "4540555555555555";
    private final String AN_INVALID_CARD_NUMBER = "";
    private final String A_CARD_NUMBER_WITH_NO_ACCOUNT = "9999999999999999";
    private final String A_MISSING_CARD_NUMBER = null;
    private final String AN_EXPIRATION_DATE = "02/16";
    private final Float AN_AMOUNT = 23.33f;
    private final Float A_MISSING_AMOUNT = null;
    private final String A_TERMINAL = "T1234";
    private final String A_NONEXISTANT_TERMINAL = "T0000";
    private final String A_VENDOR = "M1234";
    private final int A_CREDIT_LIMIT = 1200;
    private final Float A_TOO_BIG_AMOUNT = A_CREDIT_LIMIT + 50f;

    private TransactionRequest transactionRequest;
    private Response response;
    private AccountRepository accountRepository;
    private VendorRepository vendorRepository;
    private TerminalRepository terminalRepository;
    private CreditCardRepository creditCardRepository;
    private TransactionRepository transactionRepository;

    public TransactionRequestContext() {
        accountRepository = ServiceLocator.getInstance().obtain(AccountRepository.class);
        creditCardRepository = ServiceLocator.getInstance().obtain(CreditCardRepository.class);
        vendorRepository = ServiceLocator.getInstance().obtain(VendorRepository.class);
        terminalRepository = ServiceLocator.getInstance().obtain(TerminalRepository.class);
        transactionRepository = ServiceLocator.getInstance().obtain(TransactionRepository.class);
        setupVendorAndItsTerminal(A_VENDOR, A_TERMINAL);
    }

    @Étantdonné("^une demande valide$")
    public void une_demande_valide() {
        transactionRequest = new TransactionRequest(A_CARD_NUMBER, AN_EXPIRATION_DATE, AN_AMOUNT, A_TERMINAL);
    }

    @Étantdonné("^une demande invalide$")
    public void une_demande_invalide() {
        transactionRequest = new TransactionRequest(AN_INVALID_CARD_NUMBER, AN_EXPIRATION_DATE, AN_AMOUNT, A_TERMINAL);
    }

    @Étantdonné("^une demande traitée$")
    public void une_demande_traitee() {
        une_demande_valide();
        la_demande_est_traitee();
    }

    @Étantdonné("^un numéro de carte débutant par un '(\\d+)'$")
    public void un_numéro_de_carte_débutant_par_un_(int firstCharacter) {
        transactionRequest = new TransactionRequest(A_VISA_CARD_NUMBER, AN_EXPIRATION_DATE, AN_AMOUNT, A_TERMINAL);
        assertTrue(A_VISA_CARD_NUMBER.startsWith(String.valueOf(firstCharacter)));
    }

    @Quand("^un relevé est produit suite à la demande$")
    public void un_releve_est_produit_suite_a_la_demande() {
        assertNotNull(response.asString());
    }

    @Quand("^la demande est traitée$")
    public void la_demande_est_traitee() {
        response = makeRequestToApi();
    }

    @Alors("^la demande est autorisée$")
    public void la_demande_est_autorisee() {
        response.then().body(JSON_JUDGMENT, equalTo(true));
    }

    @Alors("^la demande est refusée$")
    public void la_demande_est_refusee() {
        response.then().body(JSON_JUDGMENT, equalTo(false));
    }

    @Alors("^le relevé indique l'autorisation$")
    public void le_releve_indique_l_autorisation() {
        JsonObject responseJson = new JsonParser().parse(response.asString()).getAsJsonObject();
        boolean jugement = responseJson.get(JSON_JUDGMENT).getAsBoolean();

        assertTrue(jugement);
    }

    @Alors("^la demande est archivée$")
    public void la_demande_est_archivee() {
        RequestRepository requestRepository = ServiceLocator.getInstance().obtain(RequestRepository.class);

        List<Request> requests = requestRepository.findByCardNumber(
                new RequestCardNumber(transactionRequest.getCardNumber())
        );

        Request requestFromJson = new Request(
                new RequestCardNumber(transactionRequest.getCardNumber()),
                new RequestExpirationDate(transactionRequest.getExpirationDate()),
                new RequestAmount(transactionRequest.getAmount()),
                new RequestTerminal(transactionRequest.getTerminal())
        );

        boolean isSameRequest = false;
        for (Request request : requests) {
            if (request.equals(requestFromJson)) {
                isSameRequest = true;
            }
        }

        assertTrue(isSameRequest);
    }

    @Alors("^un relevé est produit$")
    public void un_releve_est_produit() {
        response.then().body(JSON_JUDGMENT, notNullValue());
    }

    @Alors("^la transaction est conservée au compte$")
    public void la_transaction_est_conservee_au_compte() {
        JsonObject responseJson = getResponseJson(response);
        TransactionReferenceNumber referenceNumber = new TransactionReferenceNumber(responseJson.get(JSON_REFERENCE_NUMBER).getAsString());

        CreditCardNumber creditCardNumber = new CreditCardNumber(transactionRequest.getCardNumber());
        Account account = accountRepository.findByCreditCardNumber(creditCardNumber);

        boolean isTransactionInAccount = account.haveTransaction(referenceNumber);

        assertTrue(isTransactionInAccount);
    }

    @Alors("^le statut de la transaction est (.+)$")
    public void le_statut_de_transaction_est(String status) {
        JsonObject responseJson = getResponseJson(response);
        TransactionReferenceNumber referenceNumber = new TransactionReferenceNumber(responseJson.get(JSON_REFERENCE_NUMBER).getAsString());
        Transaction transaction = transactionRepository.findByReferenceNumber(referenceNumber);
        assertEquals(status, transaction.getStatus().getValue().toString());
    }

    @Alors("^le marchand est conservé dans la transaction$")
    public void le_marchand_conserve_transaction() {
        JsonObject responseJson = getResponseJson(response);
        TransactionReferenceNumber referenceNumber = new TransactionReferenceNumber(responseJson.get(JSON_REFERENCE_NUMBER).getAsString());
        Transaction transaction = transactionRepository.findByReferenceNumber(referenceNumber);
        Terminal terminal = terminalRepository.findByIdentifier(A_TERMINAL);
        Vendor vendor = vendorRepository.findByTerminal(terminal);
        assertEquals(transaction.getVendor(), vendor);
    }

    @Étantdonné("^la demande a été autorisée$")
    public void la_demande_a_ete_autorisee() {
        la_demande_est_autorisee();
    }

    @Alors("^le numéro de la transaction$")
    public void le_numero_de_la_transaction() {
        JsonObject responseJson = new JsonParser().parse(response.asString()).getAsJsonObject();
        String referenceNumber = responseJson.get(JSON_REFERENCE_NUMBER).getAsString();

        assertNotNull(referenceNumber);
    }

    @Étantdonné("^un numéro de carte associé à aucun compte$")
    public void un_numero_de_carte_associe_a_aucun_compte() {
        transactionRequest.setCardNumber(A_CARD_NUMBER_WITH_NO_ACCOUNT);
    }

    @Étantdonné("^que la date d'aujourd'hui est le (\\d+)/(\\d+)$")
    public void que_la_date_d_aujourd_hui_est_le_(int month, int year) {
        TransactionFactory transactionFactory = ServiceLocator.getInstance().obtain(TransactionFactory.class);
        transactionFactory.setToday(YearMonth.of(2000 + year, month));
    }

    @Étantdonné("^une demande avec la date d'expiration (.+)$")
    public void une_demande_avec_la_date_d_expiration(String expirationDate) {
        transactionRequest = new TransactionRequest(A_CARD_NUMBER, expirationDate, AN_AMOUNT, A_TERMINAL);
    }

    @Étantdonné("^une demande avec une date d'expiration (\\d+/\\d+) pour la carte$")
    public void une_demande_avec_la_date_d_expiration_pour_la_carte(String expirationDate) {
        une_demande_avec_la_date_d_expiration(expirationDate);

        CreditCardNumber creditCardNumber = new CreditCardNumber(transactionRequest.getCardNumber());
        CreditCardExpirationDate creditCardExpirationDate = new CreditCardExpirationDate(expirationDate);

        try {
            CreditCard creditCard = creditCardRepository.findByCardNumber(creditCardNumber);
            creditCard.setExpirationDate(creditCardExpirationDate);
            creditCardRepository.persist(creditCard);
        } catch (CreditCardNotFoundException e) {
            CreditCard creditCard = new GenericCreditCard(creditCardNumber, creditCardExpirationDate);
            creditCardRepository.persist(creditCard);
        }
    }

    @Alors("^la demande est ok$")
    public void la_demande_est_ok() {
        response.then().body(JSON_JUDGMENT, equalTo(true));
    }

    @Alors("^la demande est refusé$")
    public void la_demande_est_refuse() {
        response.then().body(JSON_JUDGMENT, equalTo(false));
    }

    @Quand("^une demande d'achat est refusée$")
    public void une_demande_d_achat_est_refusee() {
        une_demande_valide();
        un_numero_de_carte_associe_a_aucun_compte();
        la_demande_est_traitee();
    }

    @Alors("^aucune transaction n'est générée$")
    public void aucune_transaction_n_est_générée() {
        response.then().body(JSON_REFERENCE_NUMBER, nullValue());
    }

    @Alors("^aucune raison n'est donnée$")
    public void aucune_raison_n_est_donnée() {
        response.then().body(JSON_JUDGMENT, equalTo(false));
        response.then().body(JSON_REFERENCE_NUMBER, nullValue());
    }

    @Alors("^aucun relevé n'est produit$")
    public void aucun_releve_est_produit() {
        response.then().body(JSON_JUDGMENT, nullValue());
    }

    @Alors("^le marchand est notifié de l'erreur$")
    public void le_marchand_est_notifie_de_l_erreur() {
        response.then().statusCode(Status.BAD_REQUEST.getStatusCode());
    }

    @Alors("^la demande est erronée par la carte de crédit$")
    public void la_demande_est_erronee_par_la_carte_de_crédit() {
        response.then().body(JSON_ERROR_CODE, equalTo(INVALID_CREDIT_CARD_ERROR_CODE));
    }

    @Alors("^la demande est erronée par le montant$")
    public void la_demande_est_erronee_par_le_montant() {
        response.then().body(JSON_ERROR_CODE, equalTo(INVALID_AMOUNT_ERROR_CODE));
    }

    @Alors("^la demande est valide$")
    public void la_demande_est_valide() {
        response.then().body(JSON_ERROR_CODE, nullValue());
    }

    @Alors("^c'est une carte VISA$")
    public void c_est_une_carte_VISA() {
        CreditCardRepository creditCardRepository = ServiceLocator.getInstance().obtain(CreditCardRepository.class);
        CreditCard creditCard = creditCardRepository.findByCardNumber(new CreditCardNumber(transactionRequest.getCardNumber()));

        assertThat(creditCard, instanceOf(VisaCreditCard.class));
    }

    @Étantdonné("^une demande d'achat sans montant$")
    public void une_demande_d_achat_sans_montant() {
        une_demande_valide();

        transactionRequest.setAmount(A_MISSING_AMOUNT);
    }

    @Étantdonné("^une demande d'achat avec un montant de (.+)$")
    public void une_demande_d_achat_avec_un_montant_de_(float amount) {
        une_demande_valide();

        transactionRequest.setAmount(amount);
    }

    @Étantdonné("^une demande d'achat sans numéro de carte de crédit$")
    public void une_demande_d_achat_sans_numero_de_carte_de_credit() {
        une_demande_valide();

        transactionRequest.setCardNumber(A_MISSING_CARD_NUMBER);
    }

    @Étantdonné("^une demande d'achat avec le numéro de carte de crédit (.*)$")
    public void une_demande_d_achat_avec_le_numero_de_carte_de_credit_(String cardNumber) {
        une_demande_valide();

        transactionRequest.setCardNumber(cardNumber);
    }

    @Étantdonné("^une carte de crédit VISA avec (\\d+) chiffres$")
    public void une_carte_de_crédit_VISA_avec_digits_chiffres(int nbNumber) {
        String cardNumber;

        if (nbNumber == 13) {
            cardNumber = "4301010101010";
        } else if (nbNumber == 16) {
            cardNumber = "4716319978592070";
        } else {
            cardNumber = StringUtils.repeat('4', nbNumber);
        }

        transactionRequest.setCardNumber(cardNumber);
    }

    @Alors("^la demande est considérée erronée$")
    public void la_demande_est_considérée_erronée() {
        response.then().body(JSON_ERROR_CODE, equalTo(1));
    }

    @Alors("^la demande est considérée valide$")
    public void la_demande_est_considérée_valide() {
        response.then().body(JSON_ERROR_CODE, nullValue());
    }

    @Et("^une carte de crédit VISA avec un checksum invalide$")
    public void une_carte_de_crédit_VISA_avec_un_checksum_invalide() {
        transactionRequest.setCardNumber(AN_INVALID_CHECKSUM_VISA_CARD_NUMBER);
    }

    @Étantdonné("^une carte de crédit associée à un compte avec une limite de crédit de (\\d+)$")
    public void une_carte_de_crédit_associee_a_un_compte_avec_une_limite_de_credit_de_(int creditLimit) {
        transactionRequest.setCardNumber(A_NEW_CARD_NUMBER);

        CreditCardNumber cardNumber = new CreditCardNumber(A_NEW_CARD_NUMBER);

        if (accountRepository.accountExists(cardNumber)) {
            clearEntityManager();

            Account account = accountRepository.findByCreditCardNumber(cardNumber);
            account.clearTransactions();
            account.setCreditLimit(new AccountCreditLimit(creditLimit));
            accountRepository.persist(account);
        } else {
            CreditCard creditCard = new GenericCreditCard(
                    cardNumber,
                    new CreditCardExpirationDate(transactionRequest.getExpirationDate())
            );

            Account account = new Account(
                    new AccountCreditLimit(creditLimit),
                    creditCard
            );

            accountRepository.persist(account);
        }
    }

    @Étantdonné("^un montant demandé de (\\d+)$")
    public void un_montant_demande_de_(float amount) {
        transactionRequest.setAmount(amount);
    }

    @Étantdonné("^le montant est accepté$")
    public void le_montant_est_accepte() {
        transactionRequest.setAmount(AN_AMOUNT);

        une_carte_de_crédit_associee_a_un_compte_avec_une_limite_de_credit_de_(A_CREDIT_LIMIT);
    }

    @Étantdonné("^le montant n'est pas accepté$")
    public void le_montant_n_est_pas_accepte() {
        transactionRequest.setAmount(A_TOO_BIG_AMOUNT);

        une_carte_de_crédit_associee_a_un_compte_avec_une_limite_de_credit_de_(A_CREDIT_LIMIT);
    }

    @Alors("^le solde du compte est modifié$")
    public void le_solde_du_compte_est_modifie() {
        clearEntityManager();
        Account account = accountRepository.findByCreditCardNumber(new CreditCardNumber(transactionRequest.getCardNumber()));
        float balance = account.getBalance();

        assertEquals(AN_AMOUNT, balance, 0);
    }

    @Alors("^le solde du compte n'est pas modifié$")
    public void le_solde_du_compte_n_est_pas_modifie() {
        clearEntityManager();
        Account account = accountRepository.findByCreditCardNumber(new CreditCardNumber(transactionRequest.getCardNumber()));
        float balance = account.getBalance();

        assertEquals(0, balance, 0);
    }

    @Étantdonné("^une demande valide et un terminal inexistant$")
    public void une_demande_valide_terminal_inexistant() {
        transactionRequest = new TransactionRequest(A_VISA_CARD_NUMBER, AN_EXPIRATION_DATE, AN_AMOUNT, A_NONEXISTANT_TERMINAL);
    }

    private Response makeRequestToApi() {
        RequestSpecification requestSpecification = given().contentType("application/json").body(transactionRequest);
        return requestSpecification.when().post("/demandes");
    }

    private JsonObject getResponseJson(Response request) {
        return new JsonParser().parse(request.asString()).getAsJsonObject();
    }

    private void setupVendorAndItsTerminal(String vendorIdentifier, String terminalIdentifier) {
        Vendor vendor = new Vendor(new VendorIdentifier(vendorIdentifier));
        vendorRepository.persist(vendor);
        Terminal terminal = new Terminal(terminalIdentifier);
        terminal.setVendor(vendor);
        terminalRepository.persist(terminal);
    }

    private void clearEntityManager() {
        EntityManagerProvider entityManagerProvider;
        entityManagerProvider = new EntityManagerProvider();
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.clear();
    }
}
