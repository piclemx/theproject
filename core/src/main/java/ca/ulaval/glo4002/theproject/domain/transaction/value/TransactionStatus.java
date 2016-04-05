package ca.ulaval.glo4002.theproject.domain.transaction.value;


import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Immutable
public final class TransactionStatus {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private final Status value;

    public TransactionStatus() {
        value = Status.ATTENTE;
    }

    public TransactionStatus(Status status) {
        value = status;
    }

    public Status getValue() {
        return value;
    }

    public boolean equals(TransactionStatus status) {
        return value == status.getValue();
    }

    public enum Status {
        ACCEPTEE, ATTENTE, REFUSEE, CONFIRMEE
    }
}
