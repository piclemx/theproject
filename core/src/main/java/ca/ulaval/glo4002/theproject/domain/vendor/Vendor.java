package ca.ulaval.glo4002.theproject.domain.vendor;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionStatus;
import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorImproperTransactionException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @Column(name = "vendor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(targetEntity = Terminal.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Terminal> terminals;

    @OneToMany(targetEntity = Transaction.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @Embedded
    private VendorIdentifier identifier;

    public Vendor() {
    }

    public Vendor(VendorIdentifier identifier) {
        this.identifier = identifier;
        this.terminals = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public Vendor(List<Terminal> terminals, List<Transaction> transactions, VendorIdentifier identifier) {
        this.terminals = terminals;
        this.transactions = transactions;
        this.identifier = identifier;
    }

    public int getId() {
        return this.id;
    }

    public VendorIdentifier getIdentifier() {
        return this.identifier;
    }

    public List<Terminal> getTerminals() {
        return this.terminals;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public boolean equals(Vendor other) {
        return (other.getIdentifier().equals(this.getIdentifier()));
    }

    public boolean canConfirmTransactions(List<Transaction> transactions) {
        boolean canConfirmTransactions = true;
        for (Transaction transaction : transactions) {
            if (!transaction.hasVendor(this)) {
                canConfirmTransactions = false;
            }
        }
        return canConfirmTransactions;
    }

    public void confirmTransactions(TransactionRepository transactionRepository, List<Transaction> transactions) {
        if (canConfirmTransactions(transactions)) {
            for (Transaction transaction : transactions) {
                transactionRepository.changeStatus(transaction, new TransactionStatus(TransactionStatus.Status.CONFIRMEE));
            }
        } else {
            throw new VendorImproperTransactionException(getBadTransactions(transactions));
        }
    }

    public List<Transaction> getBadTransactions(List<Transaction> transactions) {
        List<Transaction> badTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (!transaction.hasVendor(this)) {
                badTransactions.add(transaction);
            }
        }
        return badTransactions;
    }

    public void addTerminal(Terminal terminal) {
        this.terminals.add(terminal);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
