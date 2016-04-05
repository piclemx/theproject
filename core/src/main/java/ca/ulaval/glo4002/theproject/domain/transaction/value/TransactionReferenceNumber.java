package ca.ulaval.glo4002.theproject.domain.transaction.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
@Immutable
public final class TransactionReferenceNumber {
    private static final String PREFIX = "VIZ";

    @Column(name = "reference_number")
    private final String value;

    public TransactionReferenceNumber() {
        value = createValue();
    }

    public TransactionReferenceNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(TransactionReferenceNumber referenceNumber) {
        return value.equals(referenceNumber.getValue());
    }

    private String createValue() {
        UUID id = UUID.randomUUID();
        return PREFIX + id.hashCode();
    }
}
