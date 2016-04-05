package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionResponse;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class RefusedTransactionErrorMapperTest {
    private RefusedTransactionErrorMapper mapper;
    private RefusedTransactionException exception = mock(RefusedTransactionException.class);

    @Before
    public void createMapper() {
        mapper = new RefusedTransactionErrorMapper();

    }

    @Test
    public void createsRestErrorWithTheExceptionsCode() {
        Response response = mapper.toResponse(exception);

        assertFalse(((TransactionResponse) response.getEntity()).getJudgment());
    }

    @Test
    public void createsABadRequest() {
        Response response = mapper.toResponse(exception);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
