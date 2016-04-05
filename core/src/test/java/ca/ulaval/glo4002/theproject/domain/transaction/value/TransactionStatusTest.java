package ca.ulaval.glo4002.theproject.domain.transaction.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionStatusTest {

    private final TransactionStatus.Status A_STATUS = TransactionStatus.Status.ACCEPTEE;
    private final TransactionStatus.Status ANOTHER_STATUS = TransactionStatus.Status.ATTENTE;

    private TransactionStatus status;

    @Test
    public void aCreationWithStatus_GetValue_ReturnsValue() {
        status = new TransactionStatus(A_STATUS);
        assertEquals(A_STATUS, status.getValue());
    }

    @Test
    public void twoEqualStatus_Equals_ReturnsTrue() {
        status = new TransactionStatus(A_STATUS);
        TransactionStatus another_status = new TransactionStatus(A_STATUS);

        boolean equals = status.equals(another_status);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentStatuses_Equals_ReturnsFalse() {
        status = new TransactionStatus(A_STATUS);
        TransactionStatus another_status = new TransactionStatus(ANOTHER_STATUS);

        boolean equals = status.equals(another_status);

        assertFalse(equals);
    }
}
