package ca.ulaval.glo4002.theproject.presentation.rest.dto;

import javax.xml.bind.annotation.XmlElement;

public class TransactionResponse {
    @XmlElement(name = "jugement")
    private Boolean judgment;

    @XmlElement(name = "txNumeroReference")
    private String referenceNumber;

    public TransactionResponse() {
        this.judgment = false;
        this.referenceNumber = null;
    }

    public TransactionResponse(String referenceNumber) {
        this.judgment = true;
        this.referenceNumber = referenceNumber;
    }

    public Boolean getJudgment() {
        return judgment;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }
}
