package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.presentation.rest.RestError;
import ca.ulaval.glo4002.theproject.service.ApplicationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidTransactionServiceErrorMapper implements ExceptionMapper<ApplicationException> {
    @Override
    public Response toResponse(ApplicationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new RestError(exception.getCode(), exception.getMessage())).build();
    }
}
