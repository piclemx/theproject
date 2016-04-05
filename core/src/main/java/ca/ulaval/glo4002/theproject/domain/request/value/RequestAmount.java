package ca.ulaval.glo4002.theproject.domain.request.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
@Immutable
public final class RequestAmount {

    @Transient
    private final float LOWER_LIMIT_AMOUNT = 0.01f;

    @Column(name = "amount")
    private final float value;

    public RequestAmount() {
        value = 0;
    }

    public RequestAmount(Float value) {
        if (value == null) {
            this.value = 0;
        } else {
            this.value = value;
        }
    }

    public float getValue() {
        return value;
    }

    public boolean equals(RequestAmount amount) {
        return value == amount.getValue();
    }

    public boolean isValid() {
        return Float.compare(value, LOWER_LIMIT_AMOUNT) >= 0;

    }
}
