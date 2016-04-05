package ca.ulaval.glo4002.theproject.domain.terminal.exception;

public class TerminalNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public TerminalNotFoundException() {
        super("Terminal not found.");
    }
}
