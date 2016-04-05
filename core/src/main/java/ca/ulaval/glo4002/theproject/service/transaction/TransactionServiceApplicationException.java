package ca.ulaval.glo4002.theproject.service.transaction;

import ca.ulaval.glo4002.theproject.service.ApplicationException;

public class TransactionServiceApplicationException extends ApplicationException {
	
	private static final long serialVersionUID = 1L;
	
    public TransactionServiceApplicationException(int code, String message) {
        super(code, message);
    }
}
