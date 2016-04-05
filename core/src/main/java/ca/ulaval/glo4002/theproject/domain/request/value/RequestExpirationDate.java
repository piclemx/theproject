package ca.ulaval.glo4002.theproject.domain.request.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Embeddable
@Immutable
public final class RequestExpirationDate {

    @Column(name = "expiration_date")
    private final String value;

    public RequestExpirationDate() {
        value = "";
    }

    public RequestExpirationDate(String value) {
        if (value == null) {
            this.value = "";
        } else {
            this.value = format(value);
        }
    }

    public String getValue() {
        return value;
    }

    public boolean equals(RequestExpirationDate expirationDate) {
        return value.equals(expirationDate.getValue());
    }

    public boolean isValid() {
        try {
            YearMonth.parse(value, DateTimeFormatter.ofPattern("MM/yy"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String format(String value) {
        return value.replaceAll("^\\d(?=/)|(?<=/)\\d$", "0$0");
    }
}