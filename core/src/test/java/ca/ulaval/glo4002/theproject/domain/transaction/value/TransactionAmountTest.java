package ca.ulaval.glo4002.theproject.domain.transaction.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionAmountTest {

    private final float AN_AMOUNT = 600;
    private final float AN_EQUAL_AMOUNT = 600;
    private final float A_DIFFERENT_AMOUNT = 800;

    private TransactionAmount amount;

    @Test
    public void amount_atCreation_ShouldBeZero() {
        amount = new TransactionAmount();

        assertEquals(0, amount.getValue(), 0);
    }

    @Test
    public void aCreationWithAmount_GetValue_ReturnsValue() {
        amount = new TransactionAmount(AN_AMOUNT);

        assertEquals(AN_AMOUNT, amount.getValue(), 0);
    }

    @Test
    public void twoEqualAmounts_Equals_ReturnsTrue() {
        amount = new TransactionAmount(AN_AMOUNT);
        TransactionAmount another_amount = new TransactionAmount(AN_EQUAL_AMOUNT);

        boolean equals = amount.equals(another_amount);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentAmounts_Equals_ReturnsFalse() {
        amount = new TransactionAmount(AN_AMOUNT);
        TransactionAmount another_amount = new TransactionAmount(A_DIFFERENT_AMOUNT);

        boolean equals = amount.equals(another_amount);

        assertFalse(equals);
    }
}