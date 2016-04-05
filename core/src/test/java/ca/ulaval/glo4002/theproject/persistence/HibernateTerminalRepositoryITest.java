package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.terminal.exception.TerminalNotFoundException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HibernateTerminalRepositoryITest {

    private final String AN_IDENTIFIER = "T101293884109280";
    private HibernateTerminalRepository repository;
    private HibernateVendorRepository vendorRepository;
    private Terminal terminal;

    @Before
    public void createEntityManager() {
        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        vendorRepository = new HibernateVendorRepository();
        Vendor vendor = new Vendor(new VendorIdentifier("M1234"));
        vendorRepository.persist(vendor);

        repository = new HibernateTerminalRepository();
        terminal = new Terminal(AN_IDENTIFIER);
        terminal.setVendor(vendor);
    }

    @After
    public void clearEntityManager() {
        EntityManagerProvider.clearEntityManager();
    }

    @Test
    public void persistTheTerminal_shouldHaveATerminal() {
        repository.persist(terminal);

        Terminal terminalFromRepo = repository.findByIdentifier(AN_IDENTIFIER);

        assertEquals(terminalFromRepo.getIdentifier(), terminal.getIdentifier());
    }

    @Test(expected = TerminalNotFoundException.class)
    public void nonExistantTerminal_findByIdentifier_shouldThrowTerminalNotFoundException() {
        repository.findByIdentifier(AN_IDENTIFIER);
    }

}
