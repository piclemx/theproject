package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;

public interface CreditCardRepository {

    void persist(CreditCard creditCard);

    CreditCard findByCardNumber(CreditCardNumber cardNumber) throws CreditCardNotFoundException;
}
