package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.presentation.rest.RestError;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidAmountException;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionServiceApplicationException;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class InvalidTransactionServiceErrorMapperTest {

    private InvalidTransactionServiceErrorMapper mapper;

    @Before
    public void createMapper() {
        mapper = new InvalidTransactionServiceErrorMapper();
    }

    @Test
    public void anInvalidAmountException_ResponseCreated_shouldCreateRestErrorWithTheExceptionsCode() {
        TransactionServiceApplicationException exception = new InvalidAmountException();
        Response response = mapper.toResponse(exception);

        assertEquals(exception.getCode(), ((RestError) response.getEntity()).getCode());
    }

    @Test
    public void anInvalidAmountException_ResponseCreated_ShouldBeABadRequest() {
        TransactionServiceApplicationException exception = new InvalidAmountException();
        Response response = mapper.toResponse(exception);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}
