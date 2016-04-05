package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.terminal.exception.TerminalNotFoundException;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HibernateTerminalRepository implements TerminalRepository {

    private EntityManagerProvider entityManagerProvider;

    public HibernateTerminalRepository() {
        this.entityManagerProvider = new EntityManagerProvider();
    }

    public void persist(Terminal terminal) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(terminal);
        entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Terminal findByIdentifier(String terminalId) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery(
                "FROM Terminal WHERE identifier = :terminalId"
        );
        query.setParameter("terminalId", terminalId);
        List<Terminal> terminals = query.getResultList();
        if (terminals.isEmpty()) {
            throw new TerminalNotFoundException();
        }

        return terminals.get(0);
    }

}
