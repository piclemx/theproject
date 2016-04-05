package ca.ulaval.glo4002.theproject.domain.request;


import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestTerminal;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionRequest;

public class RequestFactory {

    public Request createRequest(TransactionRequest transactionRequest) {
        RequestCardNumber cardNumber = new RequestCardNumber(transactionRequest.getCardNumber());
        RequestExpirationDate expirationDate = new RequestExpirationDate(transactionRequest.getExpirationDate());
        RequestAmount amount = new RequestAmount(transactionRequest.getAmount());
        RequestTerminal terminal = new RequestTerminal(transactionRequest.getTerminal());

        return new Request(cardNumber, expirationDate, amount, terminal);
    }
}
