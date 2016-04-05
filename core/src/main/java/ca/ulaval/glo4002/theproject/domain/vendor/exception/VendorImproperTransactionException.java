package ca.ulaval.glo4002.theproject.domain.vendor.exception;

import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.service.ApplicationException;

import java.util.List;
import java.util.stream.Collectors;

public class VendorImproperTransactionException extends ApplicationException {
	
	private static final long serialVersionUID = 1L;

    private List<String> transactions;

    public VendorImproperTransactionException(List<Transaction> transactions) {
        super(501, "Certaines transactions ne sont pas adminssibles");
        this.transactions = transactions.stream().map(transaction ->
                String.valueOf(transaction.getReferenceNumber().getValue())).collect(Collectors.toList());
    }

    public List<String> getTransactions() {
        return transactions;
    }
}
