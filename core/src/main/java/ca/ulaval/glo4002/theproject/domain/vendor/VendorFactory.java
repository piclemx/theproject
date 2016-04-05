package ca.ulaval.glo4002.theproject.domain.vendor;

import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;

public class VendorFactory {

    public Vendor createVendor(VendorIdentifier vendorIdentifier) {
        return new Vendor(vendorIdentifier);
    }
}
