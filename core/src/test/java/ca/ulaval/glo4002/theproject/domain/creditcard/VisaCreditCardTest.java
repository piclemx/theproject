package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VisaCreditCardTest {

    private final static CreditCardExpirationDate AN_EXPIRATION_DATE = new CreditCardExpirationDate("01/10");
    private final static CreditCardNumber AN_INVALID_12_DIGITS_NUMBER = new CreditCardNumber("454055555555");
    private final static CreditCardNumber AN_INVALID_16_DIGITS_NUMBER = new CreditCardNumber("4540555555555557");
    private final static CreditCardNumber AN_INVALID_17_DIGITS_NUMBER = new CreditCardNumber("45405555555555555");
    private final static CreditCardNumber A_VALID_13_CHECKSUM_NUMBER = new CreditCardNumber("4301010101010");
    private final static CreditCardNumber A_VALID_16_CHECKSUM_NUMBER = new CreditCardNumber("4716319978592070");
    private final static CreditCardNumber A_VALID_16_DIGITS_NUMBER_BUT_INVALID_CHECKSUM = new CreditCardNumber("4540555555555555");

    @Test
    public void aVisaCardWith13Digits_validating_isValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(A_VALID_13_CHECKSUM_NUMBER, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertTrue(isValid);
    }

    @Test
    public void AVisaCardWithLessThan13Digits_validating_isNotValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(AN_INVALID_12_DIGITS_NUMBER, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertFalse(isValid);
    }

    @Test
    public void aVisaCardWith16Digits_validating_isValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(A_VALID_16_CHECKSUM_NUMBER, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertTrue(isValid);
    }

    @Test
    public void aVisaCardWith16DigitsOrChars_validating_isNotValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(AN_INVALID_16_DIGITS_NUMBER, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertFalse(isValid);
    }

    @Test
    public void aVisaCardWithMoreThan16Digits_validating_isNotValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(AN_INVALID_17_DIGITS_NUMBER, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertFalse(isValid);
    }

    @Test
    public void aVisaCardWithAValidChecksum_validating_isValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(A_VALID_16_CHECKSUM_NUMBER, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertTrue(isValid);
    }

    @Test
    public void aVisaCardWithAnInvalidChecksum_validating_isNotValid() {
        VisaCreditCard visaCreditCard = new VisaCreditCard(A_VALID_16_DIGITS_NUMBER_BUT_INVALID_CHECKSUM, AN_EXPIRATION_DATE);

        boolean isValid = visaCreditCard.isValid();

        assertFalse(isValid);
    }

}