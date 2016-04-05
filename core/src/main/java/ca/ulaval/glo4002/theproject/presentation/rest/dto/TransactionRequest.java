package ca.ulaval.glo4002.theproject.presentation.rest.dto;

import javax.xml.bind.annotation.XmlElement;

public class TransactionRequest {

    @XmlElement(name = "numeroCarte")
    private String cardNumber;

    @XmlElement(name = "dateExpiration")
    private String expirationDate;

    @XmlElement(name = "montant")
    private Float amount;

    @XmlElement(name = "terminal")
    private String terminal;

    public TransactionRequest() {
    }

    public TransactionRequest(String cardNumber, String expirationDate, Float amount, String terminal) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.amount = amount;
        this.terminal = terminal;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
