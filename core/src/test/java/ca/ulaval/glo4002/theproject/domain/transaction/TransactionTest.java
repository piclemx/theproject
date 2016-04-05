package ca.ulaval.glo4002.theproject.domain.transaction;

import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class TransactionTest {

    private final TransactionReferenceNumber A_REFERENCE_NUMBER = new TransactionReferenceNumber();
    private final TransactionReferenceNumber ANOTHER_REFERENCE_NUMBER = new TransactionReferenceNumber();
    private final TransactionAmount AN_AMOUNT = new TransactionAmount(600);

    private Transaction transaction;
    private CreditCard aCreditCard;
    private Vendor aVendor;

    @Before
    public void init() {
        aCreditCard = mock(CreditCard.class);
        aVendor = mock(Vendor.class);

        transaction = new Transaction(A_REFERENCE_NUMBER, AN_AMOUNT, aCreditCard, aVendor);
    }

    @Test
    public void aTransaction_GetCreditCard_ReturnsCreditCard() {
        CreditCard creditCard = transaction.getCreditCard();

        assertEquals(aCreditCard, creditCard);
    }

    @Test
    public void aTransaction_GetReferenceNumber_ReturnsReferenceNumber() {
        TransactionReferenceNumber referenceNumber = transaction.getReferenceNumber();

        assertEquals(A_REFERENCE_NUMBER, referenceNumber);
    }

    @Test
    public void aTransaction_GetAmount_ReturnsAmount() {
        TransactionAmount amount = transaction.getAmount();

        assertEquals(AN_AMOUNT, amount);
    }

    @Test
    public void aTransactionWithItself_isEqual_shouldBeEqual() {
        assertTrue(transaction.equals(transaction.getReferenceNumber()));
    }

    @Test
    public void aTransactionWithAnother_isEqual_shouldNotBeEqual() {
        Transaction anotherTransaction = new Transaction(ANOTHER_REFERENCE_NUMBER, AN_AMOUNT, aCreditCard, aVendor);

        assertFalse(transaction.equals(anotherTransaction.getReferenceNumber()));
    }

    @Test
    public void aTransactionWithVendor_hasVendor_shouldBeTrue() {
        given(aVendor.equals(aVendor)).willReturn(true);

        transaction.hasVendor(aVendor);

        verify(aVendor).equals(aVendor);
    }
}
