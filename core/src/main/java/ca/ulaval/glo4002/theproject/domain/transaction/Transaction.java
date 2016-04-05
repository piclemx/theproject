package ca.ulaval.glo4002.theproject.domain.transaction;

import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionStatus;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Embedded
    private TransactionReferenceNumber referenceNumber;

    @Embedded
    private TransactionStatus status;

    @Embedded
    private TransactionAmount amount;

    @OneToOne
    @JoinColumn(name = "card_number")
    private CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public Transaction() {
    }

    public Transaction(TransactionReferenceNumber referenceNumber, TransactionAmount amount, CreditCard creditCard, Vendor vendor) {
        this.creditCard = creditCard;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.vendor = vendor;
        this.status = new TransactionStatus(TransactionStatus.Status.ATTENTE);
    }

    public TransactionReferenceNumber getReferenceNumber() {
        return referenceNumber;
    }

    public TransactionAmount getAmount() {
        return amount;
    }

    public boolean equals(TransactionReferenceNumber referenceNumber) {
        return this.referenceNumber.equals(referenceNumber);
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public boolean hasVendor(Vendor vendor) {
        return (this.vendor.equals(vendor));
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
