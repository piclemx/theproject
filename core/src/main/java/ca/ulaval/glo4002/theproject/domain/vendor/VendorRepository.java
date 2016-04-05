package ca.ulaval.glo4002.theproject.domain.vendor;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;

public interface VendorRepository {

    Vendor findByIdentifier(VendorIdentifier vendorId);

    Vendor findByTerminal(Terminal terminal);

    boolean exists(VendorIdentifier vendorIdentifier);

    void persist(Vendor vendor);
}
