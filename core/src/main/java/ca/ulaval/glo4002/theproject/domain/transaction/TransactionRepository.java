package ca.ulaval.glo4002.theproject.domain.transaction;

import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionStatus;

public interface TransactionRepository {

    Transaction findByReferenceNumber(TransactionReferenceNumber referenceNumber);

    void changeStatus(Transaction transaction, TransactionStatus status);

    boolean exists(TransactionReferenceNumber referenceNumber);

    void persist(Transaction transaction);
}
