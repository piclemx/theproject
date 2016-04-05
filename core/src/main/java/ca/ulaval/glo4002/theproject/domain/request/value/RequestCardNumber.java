package ca.ulaval.glo4002.theproject.domain.request.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import java.io.Serializable;

@Embeddable
@Immutable
public final class RequestCardNumber implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;

    @Column(name = "card_number")
    private final String value;

    public RequestCardNumber() {
        value = "";
    }

    public RequestCardNumber(String value) {
        if (value == null) {
            this.value = "";
        } else {
            this.value = format(value);
        }
    }

    public String getValue() {
        return value;
    }

    public boolean equals(RequestCardNumber cardNumber) {
        return value.equals(cardNumber.getValue());
    }

    public boolean isValid() {
        return value.matches("^\\d{9,}$");
    }

    private String format(String value) {
        return value.replaceAll("\\s+", "");
    }
}
