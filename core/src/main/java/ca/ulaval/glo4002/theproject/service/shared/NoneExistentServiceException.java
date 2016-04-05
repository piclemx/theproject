package ca.ulaval.glo4002.theproject.service.shared;

public class NoneExistentServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoneExistentServiceException(Class<?> service) {
        super("Cannot findById service name '" + service.getCanonicalName() + "'. Did you add it?");
    }
}
