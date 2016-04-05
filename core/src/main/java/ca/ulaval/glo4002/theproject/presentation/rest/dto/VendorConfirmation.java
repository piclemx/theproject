package ca.ulaval.glo4002.theproject.presentation.rest.dto;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class VendorConfirmation {

    @XmlElement(name = "idMarchand")
    private String vendorId;

    @XmlElement(name = "transactions")
    private List<String> transactions;

    public VendorConfirmation() {
    }

    public VendorConfirmation(String vendorId, List<String> transactions) {
        this.vendorId = vendorId;
        this.transactions = transactions;
    }

    public List<String> getTransactions() {
        return transactions;
    }
}
