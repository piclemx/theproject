package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestTerminal;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HibernateRequestRepositoryITest {

    private final String CARD_NUMBER_REQUEST = "123456789";
    private final RequestCardNumber cardNumber = new RequestCardNumber(CARD_NUMBER_REQUEST);

    private HibernateRequestRepository repository;

    @Before
    public void createEntityManager() {
        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        repository = new HibernateRequestRepository();
    }

    @After
    public void clearEntityManager() {
        EntityManagerProvider.clearEntityManager();
    }

    @Test
    public void aRequest_RequestIsPersisted_ShouldHaveARequest() {
        Request request = createRequest();
        repository.persist(request);

        List<Request> requestFound = repository.findByCardNumber(cardNumber);

        assertTrue(requestFound.get(0).getCardNumber().equals(cardNumber));
    }

    private Request createRequest() {
        RequestExpirationDate expirationDate = new RequestExpirationDate("01/01");
        RequestAmount amount = new RequestAmount(123f);
        RequestTerminal terminal = new RequestTerminal("T1234");
        return new Request(cardNumber, expirationDate, amount, terminal);
    }
}
