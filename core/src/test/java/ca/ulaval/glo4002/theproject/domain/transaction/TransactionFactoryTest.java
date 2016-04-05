package ca.ulaval.glo4002.theproject.domain.transaction;

import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class TransactionFactoryTest {

    private final RequestAmount A_REQUEST_AMOUNT = new RequestAmount(600f);
    private final TransactionAmount A_SAME_TRANSACTION_AMOUNT = new TransactionAmount(A_REQUEST_AMOUNT.getValue());

    private TransactionFactory transactionFactory;
    private CreditCard aCreditCard;
    private AccountRepository anAccountRepository;
    private Vendor aVendor;

    @Before
    public void init() {
        aCreditCard = mock(CreditCard.class);
        anAccountRepository = mock(AccountRepository.class);
        aVendor = mock(Vendor.class);

        transactionFactory = new TransactionFactory(anAccountRepository);

        willReturn(false).given(aCreditCard).isExpired(any());
        willReturn(true).given(anAccountRepository).accountExists(any(CreditCardNumber.class));
    }

    @Test
    public void aValidRequest_Processed_ShouldTryToVerifyAccountExist() {
        transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        verify(anAccountRepository).accountExists(any(CreditCardNumber.class));
    }

    @Test
    public void aCreditCard_CreateTransaction_ReturnsATransactionNotNull() {
        Transaction transaction = transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        assertNotNull(transaction);
    }

    @Test
    public void aCreditCard_CreateTransaction_ReturnsATransactionThatHasCreditCardWithGoodCardNumber() {
        Transaction transaction = transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        CreditCard creditCard = transaction.getCreditCard();

        assertEquals(aCreditCard.getCardNumber(), creditCard.getCardNumber());
    }

    @Test
    public void aCreditCard_CreateTransaction_ReturnsATransactionThatHasCreditCardWithGoodExpirationDate() {
        Transaction transaction = transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        CreditCard creditCard = transaction.getCreditCard();

        assertEquals(aCreditCard.getExpirationDate(), creditCard.getExpirationDate());
    }

    @Test
    public void aCreditCard_CreateTransaction_ReturnsATransactionThatHasGoodReferenceNumber() {
        Transaction transaction = transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        TransactionReferenceNumber referenceNumber = transaction.getReferenceNumber();

        assertNotNull(referenceNumber.getValue());
    }

    @Test(expected = RefusedTransactionException.class)
    public void aCreditCardWithoutAnAccount_CreateTransaction_ThrowsException() {
        willReturn(false).given(anAccountRepository).accountExists(any(CreditCardNumber.class));

        transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aCreditCardExpired_CreateTransaction_ThrowsException() {
        willReturn(true).given(aCreditCard).isExpired(any());

        transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);
    }

    @Test
    public void aRequestAmount_CreateTransaction_TransactionIsCreatedWithSameTransactionAmount() {
        Transaction transaction = transactionFactory.createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        assertTrue(A_SAME_TRANSACTION_AMOUNT.equals(transaction.getAmount()));
    }
}
