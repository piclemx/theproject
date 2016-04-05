package ca.ulaval.glo4002.theproject.domain.transaction.exception;

public class RefusedTransactionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public RefusedTransactionException() {
        super("The transaction is refused.");
    }
}
