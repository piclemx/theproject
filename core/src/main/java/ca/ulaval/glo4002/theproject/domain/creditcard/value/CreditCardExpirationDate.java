package ca.ulaval.glo4002.theproject.domain.creditcard.value;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Embeddable
@Immutable
public final class CreditCardExpirationDate {

    @Column(name = "expiration_date")
    private final String value;

    public CreditCardExpirationDate() {
        value = "";
    }

    public CreditCardExpirationDate(String value) {
        if (value == null) {
            this.value = "";
        } else {
            this.value = format(value);
        }
    }

    public String getValue() {
        return value;
    }

    public boolean equals(CreditCardExpirationDate expirationDate) {
        return value.equals(expirationDate.getValue());
    }

    public YearMonth getYearMonthValue() {
        String expirationDateYearMonthFormat = value.replaceAll("^\\d(?=/)|(?<=/)\\d$", "0$0");
        return YearMonth.parse(expirationDateYearMonthFormat, DateTimeFormatter.ofPattern("MM/yy"));
    }

    public boolean isBefore(YearMonth date) {
        return getYearMonthValue().isBefore(date);
    }

    private String format(String value) {
        return value.replaceAll("^\\d(?=/)|(?<=/)\\d$", "0$0");
    }
}