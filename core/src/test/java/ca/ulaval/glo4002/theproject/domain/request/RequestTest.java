package ca.ulaval.glo4002.theproject.domain.request;

import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestTerminal;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidAmountException;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidCreditCardException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class RequestTest {

    private final RequestCardNumber A_VALID_CARD_NUMBER = new RequestCardNumber("123456789");
    private final RequestCardNumber ANOTHER_VALID_CARD_NUMBER = new RequestCardNumber("987654321");
    private final RequestExpirationDate A_VALID_EXPIRATION_DATE = new RequestExpirationDate("09/14");
    private final RequestAmount A_VALID_AMOUNT = new RequestAmount(5f);
    private final RequestCardNumber AN_INVALID_CARD_NUMBER = new RequestCardNumber("");
    private final RequestExpirationDate AN_INVALID_EXPIRATION_DATE = new RequestExpirationDate("");
    private final RequestAmount AN_INVALID_AMOUNT = new RequestAmount(0f);
    private final RequestTerminal A_VALID_TERMINAL = new RequestTerminal("T1234");

    private Request request;
    private Request anotherRequest;

    @Before
    public void init() {
        request = new Request(A_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void aRequest_GetCardNumber_ReturnsCardNumber() {
        RequestCardNumber cardNumber = request.getCardNumber();

        assertEquals(A_VALID_CARD_NUMBER, cardNumber);
    }

    @Test
    public void aRequest_GetExpirationDate_ReturnsExpirationDate() {
        RequestExpirationDate expirationDate = request.getExpirationDate();

        assertEquals(A_VALID_EXPIRATION_DATE, expirationDate);
    }

    @Test
    public void aRequest_GetAmount_ReturnsAmount() {
        RequestAmount amount = request.getAmount();

        assertEquals(A_VALID_AMOUNT, amount);
    }

    @Test
    public void aValidRequest_Validate_ShouldThrowInvalidAmountException() {
        request = new Request(A_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        request.validate();
    }

    @Test(expected = InvalidAmountException.class)
    public void anInvalidAmount_Validate_ShouldThrowInvalidAmountException() {
        request = new Request(A_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, AN_INVALID_AMOUNT, A_VALID_TERMINAL);

        request.validate();
    }

    @Test(expected = InvalidCreditCardException.class)
    public void anInvalidCardNumber_Validate_ShouldThrowInvalidCreditCardException() {
        request = new Request(AN_INVALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        request.validate();
    }

    @Test(expected = InvalidCreditCardException.class)
    public void anInvalidExpirationDate_Validate_ShouldThrowInvalidCreditCardException() {
        request = new Request(A_VALID_CARD_NUMBER, AN_INVALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        request.validate();
    }

    @Test(expected = InvalidCreditCardException.class)
    public void anInvalidCardNumberAndExpirationDate_Validate_ShouldThrowInvalidCreditCardException() {
        request = new Request(AN_INVALID_CARD_NUMBER, AN_INVALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        request.validate();
    }

    @Test
    public void twoSameRequest_Equals_ReturnTrue() throws Exception {
        request = new Request(A_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);
        anotherRequest = new Request(A_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        boolean isEquals = request.equals(anotherRequest);

        assertTrue(isEquals);
    }

    @Test
    public void twoDifferentRequest_Equals_ReturnTrue() throws Exception {
        request = new Request(A_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);
        anotherRequest = new Request(ANOTHER_VALID_CARD_NUMBER, A_VALID_EXPIRATION_DATE, A_VALID_AMOUNT, A_VALID_TERMINAL);

        boolean isEquals = request.equals(anotherRequest);

        assertFalse(isEquals);
    }
}
