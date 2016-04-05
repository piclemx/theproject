package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.GenericCreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionStatus;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorNotFoundException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateTransactionRepositoryITest {

    private final TransactionReferenceNumber A_REFERENCE_NUMBER = new TransactionReferenceNumber("123");
    private final TransactionReferenceNumber A_NEW_REFERENCE_NUMBER = new TransactionReferenceNumber("12356");
    private final TransactionAmount AN_AMOUNT = new TransactionAmount(600);
    private final CreditCardNumber A_CARD_NUMBER = new CreditCardNumber("123");
    private final CreditCardExpirationDate AN_EXPIRATION_DATE = new CreditCardExpirationDate("01/01");
    private final VendorIdentifier A_VENDOR_IDENTIFIER = new VendorIdentifier("M1234");

    private CreditCard creditCard;
    private Vendor vendor;
    private Transaction transaction;
    private HibernateTransactionRepository repository;

    @Before
    public void createEntityManager() {
        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        repository = new HibernateTransactionRepository();

        addCreditCard();
        addVendor();

        transaction = new Transaction(A_REFERENCE_NUMBER, AN_AMOUNT, creditCard, vendor);
    }

    @After
    public void clearEntityManager() {
        EntityManagerProvider.clearEntityManager();
    }

    @Test
    public void aTransaction_TransactionIsPersisted_ShouldHaveATransaction() {
        Transaction newTransaction = new Transaction(A_NEW_REFERENCE_NUMBER, AN_AMOUNT, creditCard, vendor);

        repository.persist(newTransaction);

        Transaction transactionFound = repository.findByReferenceNumber(A_NEW_REFERENCE_NUMBER);

        assertEquals(newTransaction, transactionFound);
        assertEquals(newTransaction.getCreditCard(), transactionFound.getCreditCard());
        assertEquals(newTransaction.getVendor(), transactionFound.getVendor());
    }

    @Test
    public void persistTransaction_shouldModifyTransaction() {
        repository.persist(transaction);
        repository.changeStatus(transaction, new TransactionStatus(TransactionStatus.Status.CONFIRMEE));

        Transaction transactionFound = repository.findByReferenceNumber(transaction.getReferenceNumber());

        assertEquals(transaction.getStatus().getValue(), transactionFound.getStatus().getValue());
    }

    @Test
    public void existingTransaction_exists_shouldBeTrue() {
        TransactionReferenceNumber refNum = new TransactionReferenceNumber();
        repository.persist(new Transaction(refNum, AN_AMOUNT, creditCard, vendor));

        boolean exists = repository.exists(refNum);

        assertTrue(exists);
    }

    @Test
    public void nonExistingTransaction_exists_shouldBeFalse() {
        boolean exists = repository.exists(new TransactionReferenceNumber(""));

        assertFalse(exists);
    }

    @Test
    public void anAccountPersisted_ChangingAccount_AccountIsSaved() {
        Transaction transaction1 = repository.findByReferenceNumber(A_REFERENCE_NUMBER);

        TransactionStatus status = new TransactionStatus(TransactionStatus.Status.CONFIRMEE);
        transaction1.setStatus(status);
        repository.persist(transaction1);

        Transaction transaction2 = repository.findByReferenceNumber(A_REFERENCE_NUMBER);
        assertTrue(status.equals(transaction2.getStatus()));
    }

    private void addCreditCard() {
        CreditCardRepository creditCardRepository = new HibernateCreditCardRepository();

        try {
            creditCard = creditCardRepository.findByCardNumber(A_CARD_NUMBER);
        } catch (CreditCardNotFoundException e) {
            creditCard = new GenericCreditCard(A_CARD_NUMBER, AN_EXPIRATION_DATE);
            creditCardRepository.persist(creditCard);
        }
    }

    private void addVendor() {
        VendorRepository vendorRepository = new HibernateVendorRepository();

        try {
            vendor = vendorRepository.findByIdentifier(A_VENDOR_IDENTIFIER);
        } catch (VendorNotFoundException e) {
            vendor = new Vendor(A_VENDOR_IDENTIFIER);
            vendorRepository.persist(vendor);
        }
    }
}
