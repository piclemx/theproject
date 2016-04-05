package ca.ulaval.glo4002.theproject.domain.creditcard.exception;

public class CreditCardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CreditCardNotFoundException() {
        super("Credit card not found");
    }
}
