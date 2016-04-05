package ca.ulaval.glo4002.theproject.domain.vendor.exception;

public class VendorNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    private int code;

    public VendorNotFoundException() {
        super("Le marchand est inexistant.");
        this.code = 1;
    }

    public int getCode() {
        return code;
    }
}
