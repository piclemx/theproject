package ca.ulaval.glo4002.theproject.service.shared;

public class ExistentServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public ExistentServiceException(Class<?> service) {
        super("Implementation for the service '" + service.getCanonicalName() + "' is already there.");
    }
}
