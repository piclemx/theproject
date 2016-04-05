package ca.ulaval.glo4002.theproject.domain.account;

import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.mock;

public class AccountTest {

    private final AccountCreditLimit A_CREDIT_LIMIT = new AccountCreditLimit(1200);
    private final AccountCreditLimit A_NEW_CREDIT_LIMIT = new AccountCreditLimit(2000);
    private final TransactionReferenceNumber A_REFERENCE_NUMBER = new TransactionReferenceNumber("1245");
    private final TransactionReferenceNumber ANOTHER_REFERENCE_NUMBER = new TransactionReferenceNumber("12451245");
    private final TransactionAmount AN_AMOUNT_UNDER_THE_LIMIT = new TransactionAmount(400);
    private final TransactionAmount AN_AMOUNT_TO_THE_LIMIT = new TransactionAmount(1200);
    private final TransactionAmount AN_AMOUNT_ABOVE_THE_LIMIT = new TransactionAmount(2000);

    private Account account;
    private CreditCard aCreditCard;
    private Transaction aTransaction;

    @Before
    public void init() {
        aCreditCard = mock(CreditCard.class);
        aTransaction = mock(Transaction.class);

        account = new Account(A_CREDIT_LIMIT, aCreditCard);
    }

    @Test
    public void anAccount_GetLimit_ReturnsTheLimit() {
        AccountCreditLimit limit = account.getCreditLimit();

        assertEquals(A_CREDIT_LIMIT, limit);
    }

    @Test
    public void anAccount_GetBalance_ReturnsAZeroBalance() {
        float balance = account.getBalance();

        assertEquals(0, balance, 0);
    }

    @Test
    public void anAccountWithTransactions_GetBalance_ReturnsTheSumOfEveryTransactions() {
        willReturn(AN_AMOUNT_UNDER_THE_LIMIT).given(aTransaction).getAmount();
        account.addTransaction(aTransaction);

        float balance = account.getBalance();

        assertEquals(AN_AMOUNT_UNDER_THE_LIMIT.getValue(), balance, 0);
    }

    @Test
    public void anAccount_GetCreditCard_ReturnsTheCreditCard() {
        CreditCard creditCard = account.getCreditCard();

        assertEquals(aCreditCard, creditCard);
    }

    @Test
    public void noTransactionAdded_HaveTransaction_ReturnsFalse() {
        boolean haveTransaction = account.haveTransaction(A_REFERENCE_NUMBER);

        assertFalse(haveTransaction);
    }

    @Test
    public void aTransactionAddedWithAmountUnderTheLimit_HaveTransaction_ReturnsTrue() {
        willReturn(AN_AMOUNT_UNDER_THE_LIMIT).given(aTransaction).getAmount();
        willReturn(A_REFERENCE_NUMBER).given(aTransaction).getReferenceNumber();
        account.addTransaction(aTransaction);

        boolean haveTransaction = account.haveTransaction(A_REFERENCE_NUMBER);

        assertTrue(haveTransaction);
    }

    @Test
    public void aTransactionAddedWithAmountUnderTheLimit_HaveTransaction_ReturnsFalse() {
        willReturn(AN_AMOUNT_UNDER_THE_LIMIT).given(aTransaction).getAmount();
        willReturn(A_REFERENCE_NUMBER).given(aTransaction).getReferenceNumber();
        account.addTransaction(aTransaction);

        boolean haveTransaction = account.haveTransaction(ANOTHER_REFERENCE_NUMBER);

        assertFalse(haveTransaction);
    }

    @Test
    public void aTransactionAddedWithAmountToTheLimit_HaveTransaction_ReturnsTrue() {
        willReturn(AN_AMOUNT_TO_THE_LIMIT).given(aTransaction).getAmount();
        willReturn(A_REFERENCE_NUMBER).given(aTransaction).getReferenceNumber();
        account.addTransaction(aTransaction);

        boolean haveTransaction = account.haveTransaction(A_REFERENCE_NUMBER);

        assertTrue(haveTransaction);
    }

    @Test
    public void aTransactionAddedWithAmountToTheLimit_HaveTransaction_ReturnsFalse() {
        willReturn(AN_AMOUNT_TO_THE_LIMIT).given(aTransaction).getAmount();
        willReturn(A_REFERENCE_NUMBER).given(aTransaction).getReferenceNumber();
        account.addTransaction(aTransaction);

        boolean haveTransaction = account.haveTransaction(ANOTHER_REFERENCE_NUMBER);

        assertFalse(haveTransaction);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aTransactionWithTooHighAmount_AddTransaction_ThrowsException() {
        willReturn(AN_AMOUNT_ABOVE_THE_LIMIT).given(aTransaction).getAmount();

        account.addTransaction(aTransaction);
    }

    @Test
    public void aSetCreditLimit_GetCreditLimit_ReturnsTheCreditLimit() {
        account.setCreditLimit(A_NEW_CREDIT_LIMIT);
        AccountCreditLimit creditLimit = account.getCreditLimit();

        assertEquals(A_NEW_CREDIT_LIMIT, creditLimit);
    }

    @Test
    public void anAccountWithTransactions_ClearTransactions_AccountHasABalanceOfZero() {
        willReturn(AN_AMOUNT_UNDER_THE_LIMIT).given(aTransaction).getAmount();
        account.addTransaction(aTransaction);

        account.clearTransactions();

        assertEquals(0, account.getBalance(), 0);
    }

    @Test
    public void anAccountWithTransactions_ClearTransactions_AccountDoNotHaveTransactions() {
        willReturn(AN_AMOUNT_UNDER_THE_LIMIT).given(aTransaction).getAmount();
        willReturn(A_REFERENCE_NUMBER).given(aTransaction).getReferenceNumber();
        account.addTransaction(aTransaction);

        account.clearTransactions();

        assertFalse(account.haveTransaction(A_REFERENCE_NUMBER));
    }
}
