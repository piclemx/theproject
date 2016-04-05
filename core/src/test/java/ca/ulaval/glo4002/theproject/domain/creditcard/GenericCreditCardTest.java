package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidCreditCardException;
import org.junit.Before;
import org.junit.Test;

import java.time.YearMonth;

import static org.junit.Assert.*;

public class GenericCreditCardTest {

    private final CreditCardNumber A_CARD_NUMBER = new CreditCardNumber("1234 5678 9012 3456");
    private final CreditCardNumber AN_INVALID_CARD = new CreditCardNumber("123");
    private final CreditCardExpirationDate AN_EXPIRATION_DATE = new CreditCardExpirationDate("02/10");
    private final YearMonth A_MONTH = YearMonth.of(2015, 8);
    private final CreditCardExpirationDate A_SAME_MONTH = new CreditCardExpirationDate("08/15");
    private final CreditCardExpirationDate A_PAST_MONTH = new CreditCardExpirationDate("07/15");
    private final CreditCardExpirationDate A_FUTURE_MONTH = new CreditCardExpirationDate("09/15");

    private CreditCard creditCard;

    @Before
    public void init() {
        creditCard = new GenericCreditCard(A_CARD_NUMBER, AN_EXPIRATION_DATE);
    }

    @Test
    public void aCreditCard_GetCardNumber_ReturnsCardNumber() {
        CreditCardNumber cardNumber = creditCard.getCardNumber();

        assertEquals(A_CARD_NUMBER, cardNumber);
    }

    @Test
    public void aCreditCard_GetExpirationDate_ReturnsExpirationDate() {
        CreditCardExpirationDate expirationDate = creditCard.getExpirationDate();

        assertEquals(AN_EXPIRATION_DATE, expirationDate);
    }

    @Test
    public void aPastMonthCreditCard_IsExpired_ReturnsTrue() {
        creditCard = new GenericCreditCard(A_CARD_NUMBER, A_PAST_MONTH);

        boolean expired = creditCard.isExpired(A_MONTH);

        assertTrue(expired);
    }

    @Test
    public void aSameMonthCreditCard_IsExpired_ReturnsFalse() {
        creditCard = new GenericCreditCard(A_CARD_NUMBER, A_SAME_MONTH);

        boolean expired = creditCard.isExpired(A_MONTH);

        assertFalse(expired);
    }

    @Test
    public void aFutureMonthCreditCard_IsExpired_ReturnsFalse() {
        creditCard = new GenericCreditCard(A_CARD_NUMBER, A_FUTURE_MONTH);

        boolean expired = creditCard.isExpired(A_MONTH);

        assertFalse(expired);
    }

    @Test(expected = InvalidCreditCardException.class)
    public void aVisaCreditCardNotValid_Validate_ShouldThrowInvalidCreditCardException() {
        creditCard = new VisaCreditCard(AN_INVALID_CARD, A_SAME_MONTH);

        creditCard.validate();
    }

    @Test
    public void aCreditCard_SetExpirationDate_ReturnsExpirationDate() {
        creditCard.setExpirationDate(AN_EXPIRATION_DATE);

        CreditCardExpirationDate theExpirationDate = creditCard.getExpirationDate();

        assertEquals(AN_EXPIRATION_DATE, theExpirationDate);
    }
}
