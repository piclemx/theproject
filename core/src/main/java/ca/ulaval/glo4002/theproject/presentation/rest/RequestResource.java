package ca.ulaval.glo4002.theproject.presentation.rest;

import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.RequestFactory;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionRequest;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionResponse;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/demandes")
public class RequestResource {

    private RequestFactory requestFactory;
    private TransactionService transactionService;

    public RequestResource() {
        requestFactory = ServiceLocator.getInstance().obtain(RequestFactory.class);
        transactionService = ServiceLocator.getInstance().obtain(TransactionService.class);
    }

    public RequestResource(RequestFactory requestFactory, TransactionService transactionService) {
        this.requestFactory = requestFactory;
        this.transactionService = transactionService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response receiveRequest(TransactionRequest transactionRequest) {
        Request request = requestFactory.createRequest(transactionRequest);
        TransactionResponse transactionResponse = transactionService.processRequest(request);
        return Response.ok().entity(transactionResponse).build();
    }
}
