package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.account.Account;
import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.account.exception.AccountNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HibernateAccountRepository implements AccountRepository {

    private EntityManagerProvider entityManagerProvider;

    public HibernateAccountRepository() {
        entityManagerProvider = new EntityManagerProvider();
    }

    @Override
    public void persist(Account account) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
    }

    @Override
    public Account findByCreditCardNumber(CreditCardNumber cardNumber) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();

        Query query = entityManager.createQuery(
                "FROM Account WHERE card_number = :cardNumber"
        );
        query.setParameter("cardNumber", cardNumber.getValue());

        List<?> accounts = query.getResultList();

        if (accounts.isEmpty()) {
            throw new AccountNotFoundException();
        }

        return (Account) accounts.get(0);
    }

    @Override
    public boolean accountExists(CreditCardNumber cardNumber) {
        try {
            findByCreditCardNumber(cardNumber);
            return true;
        } catch (AccountNotFoundException e) {
            return false;
        }
    }
}
