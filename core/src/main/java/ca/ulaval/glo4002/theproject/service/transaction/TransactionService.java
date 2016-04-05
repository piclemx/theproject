package ca.ulaval.glo4002.theproject.service.transaction;

import ca.ulaval.glo4002.theproject.domain.account.Account;
import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardFactory;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.RequestRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionFactory;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorRepository;
import ca.ulaval.glo4002.theproject.domain.terminal.exception.TerminalNotFoundException;
import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorNotFoundException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionResponse;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.VendorConfirmation;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private TransactionFactory transactionFactory;
    private TransactionRepository transactionRepository;
    private RequestRepository requestRepository;
    private CreditCardRepository creditCardRepository;
    private AccountRepository accountRepository;
    private VendorRepository vendorRepository;
    private TerminalRepository terminalRepository;
    private CreditCardFactory creditCardFactory;

    public TransactionService() {
        transactionFactory = ServiceLocator.getInstance().obtain(TransactionFactory.class);
        transactionRepository = ServiceLocator.getInstance().obtain(TransactionRepository.class);
        requestRepository = ServiceLocator.getInstance().obtain(RequestRepository.class);
        creditCardRepository = ServiceLocator.getInstance().obtain(CreditCardRepository.class);
        accountRepository = ServiceLocator.getInstance().obtain(AccountRepository.class);
        vendorRepository = ServiceLocator.getInstance().obtain(VendorRepository.class);
        terminalRepository = ServiceLocator.getInstance().obtain(TerminalRepository.class);
        creditCardFactory = ServiceLocator.getInstance().obtain(CreditCardFactory.class);
    }

    public TransactionService(TransactionFactory transactionFactory,
                              TransactionRepository transactionRepository,
                              RequestRepository requestRepository,
                              CreditCardRepository creditCardRepository,
                              AccountRepository accountRepository,
                              VendorRepository vendorRepository,
                              CreditCardFactory creditCardFactory,
                              TerminalRepository terminalRepository) {
        this.transactionFactory = transactionFactory;
        this.transactionRepository = transactionRepository;
        this.requestRepository = requestRepository;
        this.creditCardRepository = creditCardRepository;
        this.accountRepository = accountRepository;
        this.vendorRepository = vendorRepository;
        this.terminalRepository = terminalRepository;
        this.creditCardFactory = creditCardFactory;
    }

    public TransactionResponse processRequest(Request request) {
        requestRepository.persist(request);
        request.validate();
        return createTransactionResponse(request);
    }

    public void confirmTransactions(String vendorId, VendorConfirmation dto) {
        Vendor vendor = vendorRepository.findByIdentifier(new VendorIdentifier(vendorId));
        List<Transaction> transactions = getTransactionsByDTOString(dto.getTransactions());
        vendor.confirmTransactions(transactionRepository, transactions);
    }

    private TransactionResponse createTransactionResponse(Request request) {
        Transaction transaction = createTransaction(request);

        return new TransactionResponse(transaction.getReferenceNumber().getValue());
    }

    private Transaction createTransaction(Request request) {
        CreditCard creditCard = getCreditCard(request);
        Vendor vendor = getVendor(request);

        Transaction transaction = transactionFactory.createTransaction(request.getAmount(), creditCard, vendor);
        Account account = accountRepository.findByCreditCardNumber(creditCard.getCardNumber());

        account.addTransaction(transaction);

        transactionRepository.persist(transaction);
        accountRepository.persist(account);

        return transaction;
    }

    private CreditCard getCreditCard(Request request) {
        CreditCard creditCard = creditCardFactory.createCreditCard(request.getCardNumber(), request.getExpirationDate());

        try {
            return creditCardRepository.findByCardNumber(creditCard.getCardNumber());
        } catch (CreditCardNotFoundException e) {
            throw new RefusedTransactionException();
        }
    }

    private Vendor getVendor(Request request) {
        try {
            Terminal terminal = terminalRepository.findByIdentifier(request.getTerminal().getValue());

            return vendorRepository.findByTerminal(terminal);
        } catch (TerminalNotFoundException | VendorNotFoundException e) {
            throw new RefusedTransactionException();
        }
    }

    private List<Transaction> getTransactionsByDTOString(List<String> transactionsStrings) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for (String transactionId : transactionsStrings) {
            TransactionReferenceNumber referenceNumber = new TransactionReferenceNumber(transactionId);
            Transaction transaction = transactionRepository.findByReferenceNumber(referenceNumber);
            transactions.add(transaction);
        }
        return transactions;
    }
}
