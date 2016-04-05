package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorNotFoundException;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class VendorNotFoundErrorMapperTest {
    private VendorNotFoundErrorMapper mapper;

    @Before
    public void createMapper() {
        mapper = new VendorNotFoundErrorMapper();

    }

    @Test
    public void createsABadRequest() {
        VendorNotFoundException exception = new VendorNotFoundException();
        Response response = mapper.toResponse(exception);

        assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.getStatus());
    }
}
