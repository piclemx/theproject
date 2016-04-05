package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.service.transaction.InvalidCreditCardException;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.time.YearMonth;

@Entity
@Inheritance
@DiscriminatorColumn(name = "card_type")
@DiscriminatorOptions(force = true)
@Table(name = "credit_card")
public abstract class CreditCard {

    @EmbeddedId
    protected CreditCardNumber cardNumber;

    @Embedded
    protected CreditCardExpirationDate expirationDate;

    public CreditCard() {
    }

    public CreditCard(CreditCardNumber cardNumber, CreditCardExpirationDate expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public CreditCardNumber getCardNumber() {
        return cardNumber;
    }

    public CreditCardExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(CreditCardExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpired(YearMonth today) {
        return expirationDate.isBefore(today);
    }

    public abstract boolean isValid();

    public void validate() {
        if (!isValid()) {
            throw new InvalidCreditCardException();
        }
    }
}
