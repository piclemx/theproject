package ca.ulaval.glo4002.theproject.service.transaction;

public class InvalidCreditCardException extends TransactionServiceApplicationException {
	
	private static final long serialVersionUID = 1L;
	
    public InvalidCreditCardException() {
        super(1, "Le format du numero de la carte de credit ou la date d'expiration n'est pas valide");
    }
}
