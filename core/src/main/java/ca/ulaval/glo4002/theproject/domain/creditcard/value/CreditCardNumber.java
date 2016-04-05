package ca.ulaval.glo4002.theproject.domain.creditcard.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;

@Embeddable
@Immutable
public final class CreditCardNumber implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Transient
    private final String FIRST_NUMBER_OF_VISA_CREDIT_CARD = "4";
	
    @Column(name = "card_number")
    private final String value;

    public CreditCardNumber() {
        value = "";
    }

    public CreditCardNumber(String value) {
        if (value == null) {
            this.value = "";
        } else {
            this.value = format(value);
        }
    }

    public String getValue() {
        return value;
    }

    public boolean equals(CreditCardNumber cardNumber) {
        return value.equals(cardNumber.getValue());
    }

    public int getLength() {
        return this.value.length();
    }

    public char getCharAt(int index) {
        return this.value.charAt(index);
    }

    public boolean isOfTypeVisa() {
        return this.value.startsWith(FIRST_NUMBER_OF_VISA_CREDIT_CARD);
    }

    private String format(String value) {
        return value.replaceAll("\\s+", "");
    }
}
