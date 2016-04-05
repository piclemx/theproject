package ca.ulaval.glo4002.theproject.domain.account.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountCreditLimitTest {

    private final int A_LIMIT = 1200;
    private final int AN_EQUAL_LIMIT = 1200;
    private final int A_DIFFERENT_LIMIT = 1500;

    @Test
    public void anAccountCreditLimit_Created_ShouldBeAtValueZero() {
        AccountCreditLimit limit = new AccountCreditLimit();

        int value = limit.getValue();

        assertEquals(0, value, 0);
    }

    @Test
    public void aCreationWithLimit_GetValue_ReturnsValue() {
        AccountCreditLimit limit = new AccountCreditLimit(A_LIMIT);

        int value = limit.getValue();

        assertEquals(A_LIMIT, value);
    }

    @Test
    public void twoEqualLimits_Equals_ReturnsTrue() {
        AccountCreditLimit limit1 = new AccountCreditLimit(A_LIMIT);
        AccountCreditLimit limit2 = new AccountCreditLimit(AN_EQUAL_LIMIT);

        boolean equals = limit1.equals(limit2);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentLimits_Equals_ReturnsFalse() {
        AccountCreditLimit limit1 = new AccountCreditLimit(A_LIMIT);
        AccountCreditLimit limit2 = new AccountCreditLimit(A_DIFFERENT_LIMIT);

        boolean equals = limit1.equals(limit2);

        assertFalse(equals);
    }
}