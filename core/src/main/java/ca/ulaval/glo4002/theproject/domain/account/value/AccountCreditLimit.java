package ca.ulaval.glo4002.theproject.domain.account.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Immutable
public final class AccountCreditLimit {

    @Column(name = "credit_limit")
    private final int value;

    public AccountCreditLimit() {
        this.value = 0;
    }

    public AccountCreditLimit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(AccountCreditLimit creditLimit) {
        return value == creditLimit.getValue();
    }
}
