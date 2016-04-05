package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorNotFoundException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HibernateVendorRepository implements VendorRepository {

    private EntityManagerProvider entityManagerProvider;

    public HibernateVendorRepository() {
        this.entityManagerProvider = new EntityManagerProvider();
    }

    public void persist(Vendor vendor) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vendor);
        entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Vendor findByIdentifier(VendorIdentifier vendorId) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery(
                "FROM Vendor WHERE identifier = :vendorId"
        );
        query.setParameter("vendorId", vendorId);
        List<Vendor> vendors = query.getResultList();
        if (vendors.isEmpty()) {
            throw new VendorNotFoundException();
        }

        return vendors.get(0);
    }

    @SuppressWarnings("unchecked")
	@Override
    public Vendor findByTerminal(Terminal terminal) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery(
                "FROM Vendor WHERE vendor_id = :vendorId"
        );
        query.setParameter("vendorId", terminal.getVendor().getId());
        List<Vendor> vendors = query.getResultList();
        if (vendors.isEmpty()) {
            throw new VendorNotFoundException();
        }

        return vendors.get(0);
    }

    @Override
    public boolean exists(VendorIdentifier vendorIdentifier) {
        try {
            findByIdentifier(vendorIdentifier);
            return true;
        } catch (VendorNotFoundException e) {
            return false;
        }
    }
}
