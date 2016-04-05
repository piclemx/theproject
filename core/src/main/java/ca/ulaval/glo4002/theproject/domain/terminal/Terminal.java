package ca.ulaval.glo4002.theproject.domain.terminal;

import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;

import javax.persistence.*;

@Entity
@Table(name = "terminal")
public class Terminal {

    @Id
    @Column(name = "terminal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "identifier")
    private String identifier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public Terminal() {
    }

    public Terminal(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
