package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionStatus;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HibernateTransactionRepository implements TransactionRepository {

    private EntityManagerProvider entityManagerProvider;

    public HibernateTransactionRepository() {
        this.entityManagerProvider = new EntityManagerProvider();
    }

    @Override
    public void persist(Transaction transaction) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        entityManager.getTransaction().commit();
    }

    @Override
    public void changeStatus(Transaction transaction, TransactionStatus status) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        transaction.setStatus(status);
        entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Transaction findByReferenceNumber(TransactionReferenceNumber referenceNumber) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery(
                "FROM Transaction WHERE reference_number = :requestCardNumber"
        );
        query.setParameter("requestCardNumber", referenceNumber.getValue());
        List<Transaction> transactions = query.getResultList();
        if (transactions.isEmpty()) {
            throw new TransactionNotFoundException();
        }

        return transactions.get(0);
    }

    @Override
    public boolean exists(TransactionReferenceNumber referenceNumber) {
        try {
            findByReferenceNumber(referenceNumber);
            return true;
        } catch (TransactionNotFoundException e) {
            return false;
        }
    }
}
