package ca.ulaval.glo4002.theproject.core;

import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.RequestFactory;
import ca.ulaval.glo4002.theproject.presentation.rest.RequestResource;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionRequest;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionResponse;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidAmountException;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionService;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionServiceApplicationException;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

public class RequestResourceTest {

    private final int OK_RESPONSE_STATUS_CODE = Response.Status.OK.getStatusCode();
    private final InvalidAmountException INVALID_AMOUNT_EXCEPTION = new InvalidAmountException();
    private RequestResource requestResource;

    private TransactionService aTransactionService;
    private RequestFactory aRequestFactory;

    private TransactionRequest aTransactionRequest;
    private TransactionResponse aTransactionResponse;
    private Request aRequest;

    @Before
    public void init() {
        aTransactionService = mock(TransactionService.class);
        aRequestFactory = mock(RequestFactory.class);

        aTransactionRequest = mock(TransactionRequest.class);
        aTransactionResponse = mock(TransactionResponse.class);
        aRequest = mock(Request.class);

        willReturn(aRequest).given(aRequestFactory).createRequest(aTransactionRequest);
        requestResource = new RequestResource(aRequestFactory, aTransactionService);
    }

    @Test
    public void aTransactionRequest_Received_RequestCreated() {
        requestResource.receiveRequest(aTransactionRequest);

        verify(aRequestFactory).createRequest(aTransactionRequest);
    }

    @Test
    public void aTransactionRequest_Received_RequestProcessed() {
        requestResource.receiveRequest(aTransactionRequest);

        verify(aTransactionService).processRequest(aRequest);
    }

    @Test(expected = TransactionServiceApplicationException.class)
    public void aTransactionRequestReceived_ProcessedAndGeneratedBadRequestResponse_ThrowTransactionServiceApplicationException() {
        willThrow(INVALID_AMOUNT_EXCEPTION).given(aTransactionService).processRequest(aRequest);

        requestResource.receiveRequest(aTransactionRequest);
    }

    @Test
    public void aTransactionRequestReceived_ProcessedAndGeneratedTransactionResponse_ReturnsResponseWithOKStatus() {
        willReturn(aTransactionResponse).given(aTransactionService).processRequest(aRequest);

        Response response = requestResource.receiveRequest(aTransactionRequest);

        assertEquals(OK_RESPONSE_STATUS_CODE, response.getStatus());
    }
}