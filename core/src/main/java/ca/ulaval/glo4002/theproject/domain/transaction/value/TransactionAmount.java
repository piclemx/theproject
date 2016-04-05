package ca.ulaval.glo4002.theproject.domain.transaction.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Immutable
public final class TransactionAmount {

    @Column(name = "amount")
    private final float value;

    public TransactionAmount() {
        value = 0;
    }

    public TransactionAmount(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public boolean equals(TransactionAmount amount) {
        return value == amount.getValue();
    }
}
