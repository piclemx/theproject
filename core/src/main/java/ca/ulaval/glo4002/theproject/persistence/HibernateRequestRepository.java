package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.RequestRepository;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HibernateRequestRepository implements RequestRepository {

    private EntityManagerProvider entityManagerProvider;

    public HibernateRequestRepository() {
        entityManagerProvider = new EntityManagerProvider();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Request> findByCardNumber(RequestCardNumber cardNumber) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();

        Query query = entityManager.createQuery(
                "FROM Request WHERE card_number = :cardNumber"
        );
        query.setParameter("cardNumber", cardNumber.getValue());

        return (List<Request>) query.getResultList();
    }

    @Override
    public void persist(Request request) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(request);
        entityManager.getTransaction().commit();
    }
}
