package ca.ulaval.glo4002.theproject.domain.account;

import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;

public class AccountFactory {

    public Account createAccount(AccountCreditLimit limit, CreditCard creditCard) {
        return new Account(limit, creditCard);
    }
}
