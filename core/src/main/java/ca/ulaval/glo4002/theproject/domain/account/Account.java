package ca.ulaval.glo4002.theproject.domain.account;

import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Embedded
    private AccountCreditLimit creditLimit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_number")
    private CreditCard creditCard;

    @OneToMany(targetEntity = Transaction.class)
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(AccountCreditLimit creditLimit, CreditCard creditCard) {
        this.creditLimit = creditLimit;
        this.creditCard = creditCard;
        this.transactions = new ArrayList<>();
    }

    public AccountCreditLimit getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(AccountCreditLimit creditLimit) {
        this.creditLimit = creditLimit;
    }

    public float getBalance() {
        float balance = 0f;

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount().getValue();
        }

        return balance;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void addTransaction(Transaction transaction) {
        validate(transaction);
        transactions.add(transaction);
    }

    public boolean haveTransaction(TransactionReferenceNumber referenceNumber) {
        return transactions.stream().anyMatch(
                transaction -> referenceNumber.equals(transaction.getReferenceNumber())
        );
    }

    public void clearTransactions() {
        transactions.clear();
    }

    private void validate(Transaction transaction) {
        if (getBalance() + transaction.getAmount().getValue() > creditLimit.getValue()) {
            throw new RefusedTransactionException();
        }
    }
}
