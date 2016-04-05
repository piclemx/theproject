package ca.ulaval.glo4002.theproject.domain.request;

import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestTerminal;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidAmountException;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidCreditCardException;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Embedded
    private RequestCardNumber cardNumber;

    @Embedded
    private RequestExpirationDate expirationDate;

    @Embedded
    private RequestAmount amount;

    @Embedded
    private RequestTerminal terminal;

    public Request() {
    }

    public Request(RequestCardNumber cardNumber, RequestExpirationDate expirationDate, RequestAmount amount, RequestTerminal terminal) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.amount = amount;
        this.terminal = terminal;
    }

    public RequestCardNumber getCardNumber() {
        return cardNumber;
    }

    public RequestExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public RequestAmount getAmount() {
        return amount;
    }

    public RequestTerminal getTerminal() {
        return terminal;
    }

    public void validate() {
        if (!cardNumber.isValid() || !expirationDate.isValid()) {
            throw new InvalidCreditCardException();
        }

        if (!amount.isValid()) {
            throw new InvalidAmountException();
        }
    }

    public boolean equals(Request request) {
        return amount.equals(request.getAmount()) &&
                expirationDate.equals(request.getExpirationDate()) &&
                cardNumber.equals(request.getCardNumber()) &&
                terminal.equals(request.getTerminal());
    }
}
