package ca.ulaval.glo4002.theproject.presentation.rest;

import ca.ulaval.glo4002.theproject.presentation.rest.dto.VendorConfirmation;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/marchand/{marchand_id}/confirmations")
@Produces(MediaType.APPLICATION_JSON)
public class VendorResource {

    private TransactionService transactionService;

    public VendorResource() {
        transactionService = ServiceLocator.getInstance().obtain(TransactionService.class);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response confirmTransactions(@PathParam("marchand_id") String vendorId, VendorConfirmation dto) {
        transactionService.confirmTransactions(vendorId, dto);
        return Response.ok().build();
    }
}
