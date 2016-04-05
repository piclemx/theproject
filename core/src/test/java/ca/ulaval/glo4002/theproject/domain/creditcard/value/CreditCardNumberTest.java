package ca.ulaval.glo4002.theproject.domain.creditcard.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardNumberTest {

    private final String A_CARD_NUMBER = "123456789";
    private final String A_VISA_CARD_NUMBER = "4123456789";
    private final String AN_EQUAL_CARD_NUMBER = "123456789";
    private final String A_DIFFERENT_CARD_NUMBER = "1234567890";
    private final String A_CARD_NUMBER_WITH_SPACES = "1 2 3 4 5 6 7 8 9";
    private final String A_CARD_NUMBER_WITH_SPACES_AND_EIGHT_NUMBERS = "1 2 3 4 5 6 7 8";
    private final String AN_EMPTY_CARD_NUMBER = "";
    private final String A_MISSING_CARD_NUMBER = null;

    private CreditCardNumber cardNumber;

    @Test
    public void aCardNumber_CreatedWithoutValues_ShouldCreateACardNumberWithEmptyString() {
        cardNumber = new CreditCardNumber();

        assertEquals(AN_EMPTY_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void aCardNumber_CreatedWithNullCardNumber_ShouldCreateACardNumberWithEmptyString() {
        cardNumber = new CreditCardNumber(A_MISSING_CARD_NUMBER);

        assertEquals(AN_EMPTY_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void aCreationWithCardNumber_GetValue_ReturnsValue() {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER);

        assertEquals(A_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void aCardNumberWithSpaces_GetValue_ReturnsValueWithoutSpaces() {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER_WITH_SPACES);

        assertEquals(A_CARD_NUMBER, cardNumber.getValue());
    }

    @Test
    public void twoEqualCardNumbers_Equals_ReturnsTrue() {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER);
        CreditCardNumber another_card_number = new CreditCardNumber(AN_EQUAL_CARD_NUMBER);

        boolean equals = cardNumber.equals(another_card_number);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentCardNumbers_Equals_ReturnsFalse() {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER);
        CreditCardNumber another_card_number = new CreditCardNumber(A_DIFFERENT_CARD_NUMBER);

        boolean equals = cardNumber.equals(another_card_number);

        assertFalse(equals);
    }

    @Test
    public void aCardNumberWithEightNumbers_Length_ShouldBeEight() {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER_WITH_SPACES_AND_EIGHT_NUMBERS);

        int numChars = cardNumber.getLength();

        assertEquals(8, numChars);
    }

    @Test
    public void anEmptyCreditCard_Length_ShouldBeZero() {
        cardNumber = new CreditCardNumber(AN_EMPTY_CARD_NUMBER);

        int numChars = cardNumber.getLength();

        assertEquals(0, numChars);
    }

    @Test
    public void aNullCreditCard_Length_ShouldBeZero() {
        cardNumber = new CreditCardNumber(A_MISSING_CARD_NUMBER);

        int numChars = cardNumber.getLength();

        assertEquals(0, numChars);
    }

    @Test
    public void aCardNumber_GetChar_ActAsJavaStringObject() {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER);

        char firstChar = cardNumber.getCharAt(0);

        assertEquals(A_CARD_NUMBER.charAt(0), firstChar);
    }

    @Test
    public void aVisaCardNumber_IsOfTypeVisa_ReturnTrue() throws Exception {
        cardNumber = new CreditCardNumber(A_VISA_CARD_NUMBER);

        boolean isOfTypeVisa = cardNumber.isOfTypeVisa();

        assertTrue(isOfTypeVisa);
    }

    @Test
    public void aCardNumber_IsOfTypeVisa_ReturnFalse() throws Exception {
        cardNumber = new CreditCardNumber(A_CARD_NUMBER);

        boolean isOfTypeVisa = cardNumber.isOfTypeVisa();

        assertFalse(isOfTypeVisa);
    }
}