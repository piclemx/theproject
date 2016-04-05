package ca.ulaval.glo4002.theproject.domain.request.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Immutable
public final class RequestTerminal {

    @Column(name = "terminal")
    private final String value;

    public RequestTerminal() {
        value = "";
    }

    public RequestTerminal(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(RequestTerminal terminal) {
        return value.equals(terminal.getValue());
    }

}
