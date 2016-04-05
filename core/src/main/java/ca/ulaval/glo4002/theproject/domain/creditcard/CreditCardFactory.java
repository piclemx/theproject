package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;

public class CreditCardFactory {

    public CreditCard createCreditCard(RequestCardNumber requestCardNumber, RequestExpirationDate requestExpirationDate) {
        CreditCardNumber cardNumber = new CreditCardNumber(requestCardNumber.getValue());
        CreditCardExpirationDate expirationDate = new CreditCardExpirationDate(requestExpirationDate.getValue());

        return createCreditCard(cardNumber, expirationDate);
    }

    public CreditCard createCreditCard(CreditCardNumber creditCardNumber, CreditCardExpirationDate creditCardExpirationDate) {
        CreditCard creditCard;

        if (creditCardNumber.isOfTypeVisa()) {
            creditCard = new VisaCreditCard(creditCardNumber, creditCardExpirationDate);
        } else {
            creditCard = new GenericCreditCard(creditCardNumber, creditCardExpirationDate);
        }

        creditCard.validate();
        return creditCard;
    }
}
