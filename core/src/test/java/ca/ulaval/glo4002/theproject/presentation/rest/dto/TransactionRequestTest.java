package ca.ulaval.glo4002.theproject.presentation.rest.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionRequestTest {

    private final String A_CARD_NUMBER = "123456789";
    private final String ANOTHER_CARD_NUMBER = "12345678912334";
    private final String AN_EXPIRATION_DATE = "12/18";
    private final String ANOTHER_EXPIRATION_DATE = "12/25";
    private final Float AN_AMOUNT = 5f;
    private final Float ANOTHER_AMOUNT = 45f;
    private final String A_TERMINAL = "T1234";
    private final String ANOTHER_TERMINAL = "V2435";

    private TransactionRequest request;

    @Before
    public void init() {
        request = new TransactionRequest(A_CARD_NUMBER, AN_EXPIRATION_DATE, AN_AMOUNT, A_TERMINAL);
    }

    @Test
    public void aCardNumber_GetCardNumber_ReturnsTheCardNumber() {
        String cardNumber = request.getCardNumber();

        assertEquals(A_CARD_NUMBER, cardNumber);
    }

    @Test
    public void anExpirationDate_GetExpirationDate_ReturnsTheExpirationDate() {
        String expirationDate = request.getExpirationDate();

        assertEquals(AN_EXPIRATION_DATE, expirationDate);
    }

    @Test
    public void anAmount_GetAmount_ReturnsTheAmount() {
        Float amount = request.getAmount();

        assertEquals(AN_AMOUNT, amount);
    }

    @Test
    public void aTerminal_GetTerminal_ReturnsTheTerminal() {
        String terminal = request.getTerminal();

        assertEquals(A_TERMINAL, terminal);
    }

    @Test
    public void setCardNumber_GetTheCardNumber() {
        request.setCardNumber(ANOTHER_CARD_NUMBER);

        assertEquals(ANOTHER_CARD_NUMBER, request.getCardNumber());
    }

    @Test
    public void setExpirationDate_GetTheExpirationDate() {
        request.setExpirationDate(ANOTHER_EXPIRATION_DATE);

        assertEquals(ANOTHER_EXPIRATION_DATE, request.getExpirationDate());
    }

    @Test
    public void setAmount_GetTheAmount() {
        request.setAmount(ANOTHER_AMOUNT);

        assertEquals(ANOTHER_AMOUNT, request.getAmount());
    }

    @Test
    public void setTerminal_GetTheTerminal() {
        request.setTerminal(ANOTHER_TERMINAL);

        assertEquals(ANOTHER_TERMINAL, request.getTerminal());
    }
}