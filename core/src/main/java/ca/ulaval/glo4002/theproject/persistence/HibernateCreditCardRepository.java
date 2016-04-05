package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;

import javax.persistence.EntityManager;

public class HibernateCreditCardRepository implements CreditCardRepository {

    private EntityManagerProvider entityManagerProvider;

    public HibernateCreditCardRepository() {
        entityManagerProvider = new EntityManagerProvider();
    }

    @Override
    public CreditCard findByCardNumber(CreditCardNumber cardNumber) throws CreditCardNotFoundException {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        CreditCard creditCard = entityManager.find(CreditCard.class, cardNumber);

        if (creditCard == null) {
            throw new CreditCardNotFoundException();
        }

        return creditCard;
    }

    @Override
    public void persist(CreditCard creditCard) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(creditCard);
        entityManager.getTransaction().commit();
    }
}
