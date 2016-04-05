package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorImproperTransactionException;
import ca.ulaval.glo4002.theproject.presentation.rest.RestError;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.willReturn;

public class VendorImproperTransactionErrorMapperTest {
    private final int BAD_CODE = 501;
    private VendorImproperTransactionErrorMapper mapper;
    private VendorImproperTransactionException exception = mock(VendorImproperTransactionException.class);

    @Before
    public void createMapper() {
        mapper = new VendorImproperTransactionErrorMapper();

    }

    @Test
    public void createsRestErrorWithTheExceptionsCode() {
        willReturn(BAD_CODE).given(exception).getCode();
        Response response = mapper.toResponse(exception);

        assertEquals(exception.getCode(), ((RestError) response.getEntity()).getCode());
    }

    @Test
    public void createsABadRequest() {
        Response response = mapper.toResponse(exception);

        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}
