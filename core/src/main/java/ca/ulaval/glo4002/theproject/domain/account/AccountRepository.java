package ca.ulaval.glo4002.theproject.domain.account;

import ca.ulaval.glo4002.theproject.domain.account.exception.AccountNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;

public interface AccountRepository {

    void persist(Account account);

    Account findByCreditCardNumber(CreditCardNumber cardNumber) throws AccountNotFoundException;

    boolean accountExists(CreditCardNumber requestCardNumber);
}
