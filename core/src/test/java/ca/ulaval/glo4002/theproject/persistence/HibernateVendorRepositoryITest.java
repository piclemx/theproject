package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorNotFoundException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateVendorRepositoryITest {

    private final String AN_IDENTIFIER = "M101293884109280";
    private final String A_TERMINAL_ID = "T1234567891029380";
    private final String AN_NONEXISTENT_TERMINAL_IDENTIFIER = "T1234567891029380";
    private final String AN_NONEXISTENT_VENDOR_IDENTIFIER = "T1234567891029380";
    private HibernateVendorRepository repository;
    private HibernateTerminalRepository terminalRepository;
    private Vendor vendor;
    private VendorIdentifier identifier;
    private Terminal terminal;

    @Before
    public void createEntityManager() {
        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());
        repository = new HibernateVendorRepository();
        terminalRepository = new HibernateTerminalRepository();
        identifier = new VendorIdentifier(AN_IDENTIFIER);
        vendor = new Vendor(identifier);
        repository.persist(vendor);
    }

    @After
    public void clearEntityManager() {
        EntityManagerProvider.clearEntityManager();
    }

    @Test
    public void persistTheVendor_ShouldHaveAVendor() {
        Vendor vendorFromRepo = repository.findByIdentifier(identifier);

        assertEquals(vendor.getIdentifier().getValue(), vendorFromRepo.getIdentifier().getValue());
    }

    @Test
    public void aVendorWithATerminal_FindByTerminal_ShouldReturnTheVendor() {
        terminal = new Terminal(A_TERMINAL_ID);
        terminal.setVendor(vendor);
        terminalRepository.persist(terminal);
        vendor.addTerminal(terminal);
        repository.persist(vendor);

        Vendor aVendor = repository.findByTerminal(terminal);

        assertEquals(aVendor.getIdentifier().getValue(), vendor.getIdentifier().getValue());
    }

    @Test
    public void existingVendor_Exists_ShouldBeTrue() {
        boolean exists = repository.exists(identifier);

        assertTrue(exists);
    }

    @Test
    public void nonExistingVendor_Exists_ShouldBeFalse() {
        boolean exists = repository.exists(new VendorIdentifier(AN_NONEXISTENT_VENDOR_IDENTIFIER));

        assertFalse(exists);
    }

    @Test(expected = VendorNotFoundException.class)
    public void notExistingVendor_FindByTerminal_ThrowsExceptions() {
        Terminal terminal = new Terminal(AN_NONEXISTENT_TERMINAL_IDENTIFIER);
        terminal.setVendor(new Vendor(new VendorIdentifier(AN_NONEXISTENT_VENDOR_IDENTIFIER)));
        repository.findByTerminal(terminal);
    }

    @Test(expected = VendorNotFoundException.class)
    public void notExistingVendor_FindById_ThrowsException() {
        repository.findByIdentifier(new VendorIdentifier(AN_NONEXISTENT_VENDOR_IDENTIFIER));
    }
}
