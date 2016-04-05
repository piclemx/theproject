package ca.ulaval.glo4002.theproject.domain.request;

import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.willReturn;

public class RequestFactoryTest {

    private final String AN_EXPIRATION_DATE = "01/12";
    private final String A_CARD_NUMBER = "123456789";
    private final Float AN_AMOUNT = 5f;

    private RequestFactory requestFactory;
    private TransactionRequest aTransactionRequest;

    @Before
    public void init() {
        requestFactory = new RequestFactory();

        aTransactionRequest = mock(TransactionRequest.class);

        willReturn(A_CARD_NUMBER).given(aTransactionRequest).getCardNumber();
        willReturn(AN_EXPIRATION_DATE).given(aTransactionRequest).getExpirationDate();
        willReturn(AN_AMOUNT).given(aTransactionRequest).getAmount();
    }

    @Test
    public void aTransactionRequest_CreateRequest_ReturnsARequestNotNull() {
        Request request = requestFactory.createRequest(aTransactionRequest);

        assertNotNull(request);
    }

    @Test
    public void aTransactionRequest_CreateRequest_ReturnsARequestThatHasCardNumberWithGoodCardNumber() {
        RequestCardNumber cardNumber = new RequestCardNumber(A_CARD_NUMBER);

        Request request = requestFactory.createRequest(aTransactionRequest);

        assertTrue(cardNumber.equals(request.getCardNumber()));
    }

    @Test
    public void aTransactionRequest_CreateRequest_ReturnsARequestThatHasExpirationDateWithGoodExpirationDate() {
        RequestExpirationDate expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE);

        Request request = requestFactory.createRequest(aTransactionRequest);

        assertTrue(expirationDate.equals(request.getExpirationDate()));
    }

    @Test
    public void aTransactionRequest_CreateRequest_ReturnsARequestThatHasAmountWithGoodAmount() {
        RequestAmount amount = new RequestAmount(AN_AMOUNT);

        Request request = requestFactory.createRequest(aTransactionRequest);

        assertTrue(amount.equals(request.getAmount()));
    }
}
