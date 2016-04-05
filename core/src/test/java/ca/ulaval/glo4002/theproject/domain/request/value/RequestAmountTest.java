package ca.ulaval.glo4002.theproject.domain.request.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestAmountTest {

    private final Float AN_AMOUNT = 5f;
    private final Float AN_EQUAL_AMOUNT = 5f;
    private final Float A_DIFFERENT_AMOUNT = 6f;
    private final Float AN_INVALID_AMOUNT = 0.009f;
    private final Float A_MISSING_AMOUNT = null;
    private final float AN_EMPTY_AMOUNT = 0f;
    private final float THE_LOWER_LIMIT_AMOUNT = 0.01f;

    private RequestAmount amount;

    @Test
    public void aRequestAmount_CreatedWithoutValues_ShouldCreateAnAmountWithValueOfZero() {
        amount = new RequestAmount();

        assertEquals(AN_EMPTY_AMOUNT, amount.getValue(), 0);
    }

    @Test
    public void aRequestAmount_CreatedWithNullAmount_ShouldCreateAnAmountWith0() {
        amount = new RequestAmount(A_MISSING_AMOUNT);

        assertEquals(AN_EMPTY_AMOUNT, amount.getValue(), 0);
    }

    @Test
    public void aCreationWithAmount_GetValue_ReturnsValue() {
        amount = new RequestAmount(AN_AMOUNT);

        assertEquals(AN_AMOUNT, amount.getValue(), 0);
    }

    @Test
    public void twoEqualAmounts_Equals_ReturnsTrue() {
        amount = new RequestAmount(AN_AMOUNT);
        RequestAmount another_Request_amount = new RequestAmount(AN_EQUAL_AMOUNT);

        boolean equals = amount.equals(another_Request_amount);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentAmounts_Equals_ReturnsFalse() {
        amount = new RequestAmount(AN_AMOUNT);
        RequestAmount another_Request_amount = new RequestAmount(A_DIFFERENT_AMOUNT);

        boolean equals = amount.equals(another_Request_amount);

        assertFalse(equals);
    }

    @Test
    public void aValidAmount_Validating_ShouldPass() {
        amount = new RequestAmount(AN_AMOUNT);

        boolean valid = amount.isValid();

        assertTrue(valid);
    }

    @Test
    public void anInvalidAmount_Validating_ShouldFail() {
        amount = new RequestAmount(AN_INVALID_AMOUNT);

        boolean valid = amount.isValid();

        assertFalse(valid);
    }

    @Test
    public void aMissingCardNumber_Validating_ShouldFail() {
        amount = new RequestAmount(A_MISSING_AMOUNT);

        boolean valid = amount.isValid();

        assertFalse(valid);
    }

    @Test
    public void aLowerLimitAmount_Validating_ShouldPass() {
        amount = new RequestAmount(THE_LOWER_LIMIT_AMOUNT);

        boolean valid = amount.isValid();

        assertTrue(valid);
    }
}