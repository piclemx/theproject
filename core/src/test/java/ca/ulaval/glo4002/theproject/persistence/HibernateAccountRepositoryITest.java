package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.account.Account;
import ca.ulaval.glo4002.theproject.domain.account.AccountFactory;
import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardFactory;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateAccountRepositoryITest {

    private final AccountCreditLimit A_LIMIT = new AccountCreditLimit(1200);
    private final AccountCreditLimit ANOTHER_LIMIT = new AccountCreditLimit(2000);
    private final CreditCardNumber A_NUMBER = new CreditCardNumber("123456789");
    private final CreditCardExpirationDate AN_EXPIRATION_DATE = new CreditCardExpirationDate("01/01");

    private HibernateAccountRepository repository;
    private CreditCard aCreditCard;
    private Account anAccount;

    @Before
    public void createEntityManager() {
        CreditCardFactory creditCardFactory = new CreditCardFactory();
        AccountFactory accountFactory = new AccountFactory();

        aCreditCard = creditCardFactory.createCreditCard(A_NUMBER, AN_EXPIRATION_DATE);
        anAccount = accountFactory.createAccount(A_LIMIT, aCreditCard);

        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        repository = new HibernateAccountRepository();
    }

    @After
    public void clearEntityManager() {
        EntityManagerProvider.clearEntityManager();
    }

    @Test
    public void anAccount_AccountIsPersisted_ShouldHaveAnAccount() {
        persistCreditCard();
        repository.persist(anAccount);

        boolean creditCardFound = repository.accountExists(A_NUMBER);

        assertTrue(creditCardFound);
    }

    @Test
    public void aCreditCardNotRegistered_SearchingDataBase_NoAccountShouldBeFound() {
        boolean creditCardFound = repository.accountExists(A_NUMBER);

        assertFalse(creditCardFound);
    }

    @Test
    public void anAccountPersisted_ChangingAccount_AccountIsSaved() {
        Account account1 = repository.findByCreditCardNumber(aCreditCard.getCardNumber());

        account1.setCreditLimit(ANOTHER_LIMIT);
        repository.persist(account1);

        Account account2 = repository.findByCreditCardNumber(aCreditCard.getCardNumber());
        assertEquals(ANOTHER_LIMIT, account2.getCreditLimit());
    }

    private void persistCreditCard() {
        CreditCardRepository creditCardRepository = new HibernateCreditCardRepository();
        creditCardRepository.persist(aCreditCard);
    }
}
