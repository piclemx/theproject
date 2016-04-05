package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("generic")
public class GenericCreditCard extends CreditCard {

    public GenericCreditCard() {
        super();
    }

    public GenericCreditCard(CreditCardNumber cardNumber, CreditCardExpirationDate expirationDate) {
        super(cardNumber, expirationDate);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
