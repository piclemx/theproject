package ca.ulaval.glo4002.theproject.domain.account;

import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AccountFactoryTest {

    private final AccountCreditLimit A_LIMIT = new AccountCreditLimit(1200);

    private AccountFactory accountFactory;
    private CreditCard aCreditCard;

    @Before
    public void init() {
        accountFactory = new AccountFactory();

        aCreditCard = mock(CreditCard.class);
    }

    @Test
    public void aLimit_creating_shouldReturnAnAccountWithLimit() {
        Account account = accountFactory.createAccount(A_LIMIT, aCreditCard);

        AccountCreditLimit limit = account.getCreditLimit();

        assertEquals(A_LIMIT, limit);
    }

    @Test
    public void aCreditCard_creating_shouldReturnAnAccountWithCreditCard() {
        Account account = accountFactory.createAccount(A_LIMIT, aCreditCard);

        CreditCard creditCard = account.getCreditCard();

        assertEquals(aCreditCard, creditCard);
    }
}