package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorImproperTransactionException;
import ca.ulaval.glo4002.theproject.presentation.rest.RestError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class VendorImproperTransactionErrorMapper implements ExceptionMapper<VendorImproperTransactionException> {
    @Override
    public Response toResponse(VendorImproperTransactionException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(
                new RestError(e.getCode(), e.getMessage(), e.getTransactions())).build();
    }
}
