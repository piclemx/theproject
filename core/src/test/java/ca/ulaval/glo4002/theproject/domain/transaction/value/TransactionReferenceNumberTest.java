package ca.ulaval.glo4002.theproject.domain.transaction.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionReferenceNumberTest {

    private final String PREFIX = "VIZ";

    private final String A_REFERENCE_NUMBER = "1245";
    private final String AN_EQUAL_REFERENCE_NUMBER = "1245";
    private final String A_DIFFERENT_REFERENCE_NUMBER = "5421";

    private TransactionReferenceNumber referenceNumber;

    @Test
    public void referenceNumber_AtCreation__ShouldNotBeNullValue() {
        referenceNumber = new TransactionReferenceNumber();

        assertNotNull(referenceNumber.getValue());
    }

    @Test
    public void aCreationWithCardNumber_GetValue_ReturnsValue() {
        referenceNumber = new TransactionReferenceNumber(A_REFERENCE_NUMBER);

        assertEquals(A_REFERENCE_NUMBER, referenceNumber.getValue());
    }

    @Test
    public void twoEqualCardNumbers_Equals_ReturnsTrue() {
        referenceNumber = new TransactionReferenceNumber(A_REFERENCE_NUMBER);
        TransactionReferenceNumber another_reference_number = new TransactionReferenceNumber(AN_EQUAL_REFERENCE_NUMBER);

        boolean equals = referenceNumber.equals(another_reference_number);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentCardNumbers_Equals_ReturnsFalse() {
        referenceNumber = new TransactionReferenceNumber(A_REFERENCE_NUMBER);
        TransactionReferenceNumber another_reference_number = new TransactionReferenceNumber(A_DIFFERENT_REFERENCE_NUMBER);

        boolean equals = referenceNumber.equals(another_reference_number);

        assertFalse(equals);
    }

    @Test
    public void creatingReferenceNumber_ReferenceNumberBeginsWithPrefix() {
        referenceNumber = new TransactionReferenceNumber();

        assertTrue(referenceNumber.getValue().startsWith(PREFIX));
    }
}