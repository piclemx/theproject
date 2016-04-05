package ca.ulaval.glo4002.theproject.domain.vendor.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Immutable
public class VendorIdentifier {

    @Column(name = "identifier")
    private final String value;

    public VendorIdentifier() {
        value = "";
    }

    public VendorIdentifier(String identifier) {
        this.value = identifier;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(VendorIdentifier other) {
        return (other.getValue().equals(this.getValue()));
    }

}
