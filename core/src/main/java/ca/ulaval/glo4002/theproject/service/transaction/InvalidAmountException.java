package ca.ulaval.glo4002.theproject.service.transaction;

public class InvalidAmountException extends TransactionServiceApplicationException {
	
	private static final long serialVersionUID = 1L;
	
    public InvalidAmountException() {
        super(2, "Le montant de la demande d'achat n'est pas valide");
    }

}
