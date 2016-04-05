package ca.ulaval.glo4002.theproject.domain.transaction;

import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionAmount;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;

import java.time.YearMonth;

public class TransactionFactory {

    private AccountRepository accountRepository;
    private YearMonth today;

    public TransactionFactory() {
        accountRepository = ServiceLocator.getInstance().obtain(AccountRepository.class);
        today = YearMonth.now();
    }

    public TransactionFactory(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        today = YearMonth.now();
    }

    public void setToday(YearMonth today) {
        this.today = today;
    }

    public Transaction createTransaction(RequestAmount requestAmount, CreditCard creditCard, Vendor vendor) {
        verify(creditCard);

        TransactionReferenceNumber referenceNumber = new TransactionReferenceNumber();
        TransactionAmount amount = new TransactionAmount(requestAmount.getValue());

        return new Transaction(referenceNumber, amount, creditCard, vendor);
    }

    private void verify(CreditCard creditCard) {
        if (!accountRepository.accountExists(creditCard.getCardNumber())) {
            throw new RefusedTransactionException();
        }

        if (creditCard.isExpired(today)) {
            throw new RefusedTransactionException();
        }
    }
}
