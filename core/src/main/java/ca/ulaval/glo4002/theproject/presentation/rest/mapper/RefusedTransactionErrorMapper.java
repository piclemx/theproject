package ca.ulaval.glo4002.theproject.presentation.rest.mapper;

import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RefusedTransactionErrorMapper implements ExceptionMapper<RefusedTransactionException> {
    @Override
    public Response toResponse(RefusedTransactionException e) {
        return Response.ok().entity(new TransactionResponse()).build();
    }
}
