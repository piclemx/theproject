package ca.ulaval.glo4002.theproject.service.transaction;

public class TransactionNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public TransactionNotFoundException() {
        super("Transaction not found.");
    }
}
