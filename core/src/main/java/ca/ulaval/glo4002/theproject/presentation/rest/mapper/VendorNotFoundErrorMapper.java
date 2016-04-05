package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorNotFoundException;
import ca.ulaval.glo4002.theproject.presentation.rest.RestError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class VendorNotFoundErrorMapper implements ExceptionMapper<VendorNotFoundException> {
    @Override
    public Response toResponse(VendorNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(new RestError(exception.getCode(), exception.getMessage())).build();
    }
}
