package ca.ulaval.glo4002.theproject.domain.account.exception;

public class AccountNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
        super("Account not found.");
    }
}
