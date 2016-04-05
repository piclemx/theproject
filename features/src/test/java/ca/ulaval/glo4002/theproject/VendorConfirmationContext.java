package ca.ulaval.glo4002.theproject;

import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardFactory;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalFactory;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionFactory;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionStatus;
import ca.ulaval.glo4002.theproject.domain.vendor.*;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Étantdonné;

import static com.jayway.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status;
import static org.junit.Assert.assertEquals;

public class VendorConfirmationContext {

    private final String A_VENDOR_ID = "M12345";
    private final String AN_INEXISTING_VENDOR_ID = "M000000";
    private final String A_TERMINAL_ID = "T12345";
    private final String A_REQUEST_CARD_NUMBER = "4916432296478696";
    private final String A_REQUEST_EXPIRATION_DATE = "02/17";
    private final String ANOTHER_VENDOR = "M00000";
    private final RequestAmount AN_AMOUNT = new RequestAmount(23.33f);
    private final RequestCardNumber A_CARD_NUMBER = new RequestCardNumber("4916432296478696");
    private final RequestExpirationDate AN_EXPIRATION_DATE = new RequestExpirationDate("02/16");

    private final String JSON_VENDOR_ID = "idMarchand";
    private final String JSON_TRANSACTIONS = "transactions";

    private Vendor vendor;
    private VendorIdentifier vendorIdentifier;
    private VendorIdentifier inexistingVendor;
    private VendorRepository vendorRepository;
    private VendorFactory vendorFactory;

    private Terminal terminal;
    private TerminalFactory terminalFactory;
    private TerminalRepository terminalRepository;

    private TransactionRepository transactionRepository;
    private Transaction transactionAdmissible1;
    private Transaction transactionAdmissible2;
    private Transaction transactionInadmissible;
    private Transaction inexistantTransation;

    private Response response;

    public VendorConfirmationContext() {
        vendorRepository = ServiceLocator.getInstance().obtain(VendorRepository.class);
        transactionRepository = ServiceLocator.getInstance().obtain(TransactionRepository.class);
        vendorFactory = ServiceLocator.getInstance().obtain(VendorFactory.class);
        terminalFactory = ServiceLocator.getInstance().obtain(TerminalFactory.class);
        terminalRepository = ServiceLocator.getInstance().obtain(TerminalRepository.class);
    }

    @Étantdonné("^un marchand avec des transactions admissibles en attente$")
    public void un_marchand_avec_des_transactions_admissibles_en_attente() {
        setupVendorAndItsTerminal(A_VENDOR_ID, A_TERMINAL_ID);
        transactionAdmissible1 = this.generateTransaction();
        transactionAdmissible2 = this.generateTransaction();
        vendor.addTransaction(transactionAdmissible1);
        vendor.addTransaction(transactionAdmissible2);
    }

    @Quand("^il soumet les transactions$")
    public void il_soumet_des_transactions() {
        JsonArray transactionsJson = new JsonArray();
        transactionsJson.add(new JsonPrimitive(transactionAdmissible1.getReferenceNumber().getValue()));
        transactionsJson.add(new JsonPrimitive(transactionAdmissible2.getReferenceNumber().getValue()));

        JsonObject aValidRequestJson = new JsonObject();
        aValidRequestJson.addProperty(JSON_VENDOR_ID, vendorIdentifier.getValue());
        aValidRequestJson.add(JSON_TRANSACTIONS, transactionsJson);

        response = makeRequestToApi(aValidRequestJson, vendorIdentifier.getValue());
    }

    @Alors("^les transactions sont confirmées$")
    public void les_transactions_sont_confirmees() {
        response.then().assertThat().statusCode(Status.OK.getStatusCode());
    }

    @Étantdonné("^un marchand sans transaction$")
    public void un_marchand_sans_transaction() {
        setupVendorAndItsTerminal(A_VENDOR_ID, A_TERMINAL_ID);
    }

    @Quand("^il soumet aucune transaction$")
    public void il_soumet_aucune_transaction() {
        JsonArray transactionsJson = new JsonArray();
        JsonObject aValidRequestJson = new JsonObject();
        aValidRequestJson.addProperty(JSON_VENDOR_ID, vendorIdentifier.getValue());
        aValidRequestJson.add(JSON_TRANSACTIONS, transactionsJson);

        response = makeRequestToApi(aValidRequestJson, vendorIdentifier.getValue());
    }

    @Alors("^rien n'est effectué$")
    public void rien_est_effectue() {
    }

    @Alors("^aucune erreur n’est reportée$")
    public void aucune_erreur_reportee() {
        response.then().assertThat().statusCode(Status.OK.getStatusCode());
    }

    @Étantdonné("^une transaction déjà confirmée$")
    public void une_transaction_deja_confirmee() {
        setupVendorAndItsTerminal(A_VENDOR_ID, A_TERMINAL_ID);
        transactionAdmissible1 = this.generateTransaction();
        transactionAdmissible1.setStatus(new TransactionStatus(TransactionStatus.Status.CONFIRMEE));
        vendor.addTransaction(transactionAdmissible1);
    }

    @Quand("^le marchand soumet cette transaction$")
    public void le_marchand_soumet_cette_transaction() {
        JsonArray transactionsJson = new JsonArray();
        transactionsJson.add(new JsonPrimitive(transactionAdmissible1.getReferenceNumber().getValue()));

        JsonObject aValidRequestJson = new JsonObject();
        aValidRequestJson.addProperty(JSON_VENDOR_ID, vendorIdentifier.getValue());
        aValidRequestJson.add(JSON_TRANSACTIONS, transactionsJson);

        response = makeRequestToApi(aValidRequestJson, vendorIdentifier.getValue());
    }

    @Alors("^la transaction reste dans son statut actuel$")
    public void la_transaction_reste_dans_son_statut_actuel() {
        assertEquals(transactionAdmissible1.getStatus().getValue(), TransactionStatus.Status.CONFIRMEE);
    }

    @Étantdonné("^un marchand avec des transactions admissibles$")
    public void un_marchand_avec_des_transactions_admissibles() {
        setupVendorAndItsTerminal(A_VENDOR_ID, A_TERMINAL_ID);
        transactionAdmissible1 = this.generateTransaction();
        vendor.addTransaction(transactionAdmissible1);
    }

    @Étantdonné("^ayant des transactions inadmissible$")
    public void ayant_des_transactions_inadmissibles() {
        transactionInadmissible = this.generateInadmissibleTransaction();
    }

    @Quand("^il soumet les transactions inadmissibles$")
    public void il_soumet_les_transactions_inadmissibles() {
        JsonArray transactionsJson = new JsonArray();
        transactionsJson.add(new JsonPrimitive(transactionAdmissible1.getReferenceNumber().getValue()));
        transactionsJson.add(new JsonPrimitive(transactionInadmissible.getReferenceNumber().getValue()));

        JsonObject aValidRequestJson = new JsonObject();
        aValidRequestJson.addProperty(JSON_VENDOR_ID, vendorIdentifier.getValue());
        aValidRequestJson.add(JSON_TRANSACTIONS, transactionsJson);

        response = makeRequestToApi(aValidRequestJson, vendorIdentifier.getValue());
    }

    @Alors("^aucune transaction n’est confirmée$")
    public void auncune_transaction_est_confirmee() {
        assertEquals(transactionAdmissible1.getStatus().getValue(), TransactionStatus.Status.ATTENTE);
        assertEquals(transactionInadmissible.getStatus().getValue(), TransactionStatus.Status.ATTENTE);
    }

    @Alors("^la requête est rejetée$")
    public void la_requete_est_rejetee() {
        response.then().assertThat().statusCode(Status.BAD_REQUEST.getStatusCode());
    }

    @Étantdonné("^un numéro de marchand inexistant$")
    public void un_numero_marchand_inexistant() {
        inexistingVendor = new VendorIdentifier(AN_INEXISTING_VENDOR_ID);
    }

    @Quand("^le marchand inexistant soumet une liste de transaction$")
    public void le_marchand_inexistant_soumet_une_liste_de_transaction() {
        transactionAdmissible1 = this.generateTransaction();
        transactionAdmissible2 = this.generateTransaction();
        JsonArray transactionsJson = new JsonArray();
        transactionsJson.add(new JsonPrimitive(transactionAdmissible1.getReferenceNumber().getValue()));
        transactionsJson.add(new JsonPrimitive(transactionAdmissible2.getReferenceNumber().getValue()));

        JsonObject aValidRequestJson = new JsonObject();
        aValidRequestJson.addProperty(JSON_VENDOR_ID, inexistingVendor.getValue());
        aValidRequestJson.add(JSON_TRANSACTIONS, transactionsJson);

        response = makeRequestToApi(aValidRequestJson, inexistingVendor.getValue());
    }

    @Alors("^une erreur se produit$")
    public void une_erreur_se_produit() {
        response.then().assertThat().statusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Alors("^la resource est donc introuvable$")
    public void resource_introuvable() {
        response.then().assertThat().statusCode(Status.NOT_FOUND.getStatusCode());
    }

    @Étantdonné("^des transactions inexistante$")
    public void des_transactions_inexistantes() {
        CreditCardFactory creditCardFactory = ServiceLocator.getInstance().obtain(CreditCardFactory.class);
        TransactionFactory transactionFactory = ServiceLocator.getInstance().obtain(TransactionFactory.class);
        CreditCard creditCard = creditCardFactory.createCreditCard(A_CARD_NUMBER, AN_EXPIRATION_DATE);
        inexistantTransation = transactionFactory.createTransaction(AN_AMOUNT, creditCard, vendor);
    }

    @Quand("^le marchand soumet ces transactions inexistantes$")
    public void marchand_soumet_transactions_inexistantes() {
        setupVendorAndItsTerminal(A_VENDOR_ID, A_TERMINAL_ID);
        JsonArray transactionsJson = new JsonArray();
        transactionsJson.add(new JsonPrimitive(inexistantTransation.getReferenceNumber().getValue()));

        JsonObject aValidRequestJson = new JsonObject();
        aValidRequestJson.addProperty(JSON_VENDOR_ID, vendorIdentifier.getValue());
        aValidRequestJson.add(JSON_TRANSACTIONS, transactionsJson);

        response = makeRequestToApi(aValidRequestJson, vendorIdentifier.getValue());
    }


    private Transaction generateTransaction() {
        RequestCardNumber aCardNumber = new RequestCardNumber(A_REQUEST_CARD_NUMBER);
        RequestExpirationDate anExpirationDate = new RequestExpirationDate(A_REQUEST_EXPIRATION_DATE);

        CreditCardFactory creditCardFactory = ServiceLocator.getInstance().obtain(CreditCardFactory.class);
        TransactionFactory transactionFactory = ServiceLocator.getInstance().obtain(TransactionFactory.class);

        CreditCard creditCard = creditCardFactory.createCreditCard(aCardNumber, anExpirationDate);
        Transaction transaction = transactionFactory.createTransaction(AN_AMOUNT, creditCard, vendor);

        transactionRepository.persist(transaction);
        return transaction;

    }

    private Transaction generateInadmissibleTransaction() {
        RequestCardNumber aCardNumber = new RequestCardNumber(A_REQUEST_CARD_NUMBER);
        RequestExpirationDate anExpirationDate = new RequestExpirationDate(A_REQUEST_EXPIRATION_DATE);

        CreditCardFactory creditCardFactory = ServiceLocator.getInstance().obtain(CreditCardFactory.class);
        TransactionFactory transactionFactory = ServiceLocator.getInstance().obtain(TransactionFactory.class);

        CreditCard creditCard = creditCardFactory.createCreditCard(aCardNumber, anExpirationDate);

        Vendor otherVendor = vendorFactory.createVendor(new VendorIdentifier(ANOTHER_VENDOR));
        vendorRepository.persist(otherVendor);

        Transaction transaction = transactionFactory.createTransaction(AN_AMOUNT, creditCard, otherVendor);

        transactionRepository.persist(transaction);
        return transaction;
    }

    private void setupVendorAndItsTerminal(String vendorId, String terminalIdentifier) {
        vendorIdentifier = new VendorIdentifier(vendorId);
        vendor = vendorFactory.createVendor(vendorIdentifier);
        vendorRepository.persist(vendor);
        terminal = terminalFactory.createTerminal(terminalIdentifier);
        terminal.setVendor(vendor);
        terminalRepository.persist(terminal);
    }

    private Response makeRequestToApi(JsonObject requestJson, String vendorId) {
        RequestSpecification requestSpecification = given().contentType("application/json").body(requestJson.toString());
        return requestSpecification.when().post("/marchand/" + vendorId + "/confirmations");
    }
}
