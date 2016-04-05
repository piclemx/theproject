package ca.ulaval.glo4002.theproject.domain.request.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestCardNumberTest {

    private final String A_CARD_NUMBER = "123456789";
    private final String AN_EQUAL_CARD_NUMBER = "123456789";
    private final String A_DIFFERENT_CARD_NUMBER = "1234567890";
    private final String A_CARD_NUMBER_WITH_SPACES = "1 2 3 4 5 6 7 8 9";
    private final String A_CARD_NUMBER_WITH_SPACES_AND_EIGHT_NUMBERS = "1 2 3 4 5 6 7 8";
    private final String A_CARD_NUMBER_WITH_SPACES_AND_TEN_NUMBERS = "1 2 3 4 5 6 7 8 9 0";
    private final String A_CARD_NUMBER_WITH_NON_NUMERIC = "1x3456789";
    private final String A_CARD_NUMBER_LESS_THAN_NINE = "123412";
    private final String AN_EMPTY_CARD_NUMBER = "";
    private final String A_MISSING_CARD_NUMBER = null;

    private RequestCardNumber cardNumber;

    @Test
    public void aCardNumber_CreatedWithoutValues_ShouldCreateACardNumberWithEmptyString() {
        cardNumber = new RequestCardNumber();

        assertEquals(AN_EMPTY_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void aCardNumber_CreatedWithNullCardNumber_ShouldCreateACardNumberWithEmptyString() {
        cardNumber = new RequestCardNumber(A_MISSING_CARD_NUMBER);

        assertEquals(AN_EMPTY_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void aCreationWithCardNumber_GetValue_ReturnsValue() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER);

        assertEquals(A_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void aCardNumberWithSpaces_GetValue_ReturnsValueWithoutSpaces() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER_WITH_SPACES);

        assertEquals(A_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void twoEqualCardNumbers_Equals_ReturnsTrue() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER);
        RequestCardNumber another_card_number = new RequestCardNumber(AN_EQUAL_CARD_NUMBER);

        boolean equals = cardNumber.equals(another_card_number);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentCardNumbers_Equals_ReturnsFalse() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER);
        RequestCardNumber another_card_number = new RequestCardNumber(A_DIFFERENT_CARD_NUMBER);

        boolean equals = cardNumber.equals(another_card_number);

        assertFalse(equals);
    }

    @Test
    public void aValidCardNumber_Validating_ShouldPass() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER);

        boolean valid = cardNumber.isValid();

        assertTrue(valid);
    }

    @Test
    public void aCardNumberWithSpace_Validating_ShouldPass() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER_WITH_SPACES);

        boolean valid = cardNumber.isValid();

        assertTrue(valid);
    }

    @Test
    public void aCardNumberWithSpaceAndEightNumbers_Validating_ShouldFail() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER_WITH_SPACES_AND_EIGHT_NUMBERS);

        boolean valid = cardNumber.isValid();

        assertFalse(valid);
    }

    @Test
    public void aCardNumberWithSpaceAndEightNumbers_Validating_ShouldPass() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER_WITH_SPACES_AND_TEN_NUMBERS);

        boolean valid = cardNumber.isValid();

        assertTrue(valid);
    }

    @Test
    public void aCardNumberWithNonNumeric_Validating_ShouldFail() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER_WITH_NON_NUMERIC);

        boolean valid = cardNumber.isValid();

        assertFalse(valid);
    }

    @Test
    public void aCardNumberWithLessThanNine_Validating_ShouldFail() {
        cardNumber = new RequestCardNumber(A_CARD_NUMBER_LESS_THAN_NINE);

        boolean valid = cardNumber.isValid();

        assertFalse(valid);
    }

    @Test
    public void aMissingCardNumber_Validating_ShouldFail() {
        cardNumber = new RequestCardNumber(A_MISSING_CARD_NUMBER);

        boolean valid = cardNumber.isValid();

        assertFalse(valid);
    }
}