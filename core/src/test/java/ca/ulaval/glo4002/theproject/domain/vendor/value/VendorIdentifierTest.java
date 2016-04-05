package ca.ulaval.glo4002.theproject.domain.vendor.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class VendorIdentifierTest {

    private final String A_VENDOR_ID = "M1234";
    private final String ANOTHER_VENDOR_ID = "M2345";

    private VendorIdentifier vendorIdentifier;
    private VendorIdentifier anotherVendorIdentifier;

    @Test
    public void anEmptyVendorIdentifier_getValue_returnsEmptyString() {
        vendorIdentifier = new VendorIdentifier();

        String value = vendorIdentifier.getValue();

        assertEquals("", value);
    }

    @Test
    public void aVendorIdWithItself_isEqual_shouldBeEqual() {
        vendorIdentifier = new VendorIdentifier(A_VENDOR_ID);
        assertTrue(vendorIdentifier.equals(vendorIdentifier));

    }

    @Test
    public void aVendorIdWithAnother_isEqual_shouldNotBeEqual() {
        vendorIdentifier = new VendorIdentifier(A_VENDOR_ID);
        anotherVendorIdentifier = new VendorIdentifier(ANOTHER_VENDOR_ID);
        assertFalse(vendorIdentifier.equals(anotherVendorIdentifier));

    }
}