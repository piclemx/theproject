package ca.ulaval.glo4002.theproject.domain.creditcard.value;

import org.junit.Test;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class CreditCardExpirationDateTest {

    private final String AN_EXPIRATION_DATE = "01/02";
    private final String A_DIFFERENT_EXPIRATION_DATE = "10/15";
    private final String AN_EXPIRATION_DATE_WITHOUT_ZEROS = "1/2";
    private final String A_PAST_EXPIRATION_DATE = "09/01";
    private final String A_NEXT_EXPIRATION_DATE = "01/03";
    private final String AN_EMPTY_EXPIRATION_DATE = "";
    private final String A_MISSING_EXPIRATION_DATE = null;
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/yy");
    private final YearMonth A_YEAR_MONTH = YearMonth.parse(AN_EXPIRATION_DATE, FORMATTER);
    private final YearMonth A_YEAR_MONTH_WITHOUT_ZERO = YearMonth.of(2002, 1);

    private CreditCardExpirationDate expirationDate;

    @Test
    public void anExpirationDate_CreatedWithoutValues_ShouldCreateAnExpirationDateWithEmptyString() {
        expirationDate = new CreditCardExpirationDate();

        assertEquals(AN_EMPTY_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void anExpirationDate_CreatedWithNullExpirationDate_ShouldCreateAnExpirationDateWithEmptyString() {
        expirationDate = new CreditCardExpirationDate(A_MISSING_EXPIRATION_DATE);

        assertEquals(AN_EMPTY_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void aCreationWithExpirationDate_GetValue_ReturnsValue() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);

        assertEquals(AN_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void aCreationWithExpirationDateWithoutZeros_GetValue_ReturnsValueWithZeros() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE_WITHOUT_ZEROS);

        assertEquals(AN_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void twoEqualExpirationDates_Equals_ReturnsTrue() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);
        CreditCardExpirationDate another_expiration_date = new CreditCardExpirationDate(AN_EXPIRATION_DATE);

        boolean equals = expirationDate.equals(another_expiration_date);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentExpirationDates_Equals_ReturnsFalse() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);
        CreditCardExpirationDate another_expiration_date = new CreditCardExpirationDate(A_DIFFERENT_EXPIRATION_DATE);

        boolean equals = expirationDate.equals(another_expiration_date);

        assertFalse(equals);
    }

    @Test
    public void anExpirationDate_GetYearMonthValue_ReturnsYearMonthValue() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);

        YearMonth yearMonth = expirationDate.getYearMonthValue();

        assertEquals(A_YEAR_MONTH, yearMonth);
    }

    @Test
    public void anExpirationDateWithoutZero_GetYearMonthValue_ReturnsGetYearMonthValue() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE_WITHOUT_ZEROS);

        YearMonth yearMonth = expirationDate.getYearMonthValue();

        assertEquals(A_YEAR_MONTH_WITHOUT_ZERO, yearMonth);
    }

    @Test
    public void anExpirationDateThatIsSameAsAnother_IsBefore_ReturnsFalse() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);

        boolean before = expirationDate.isBefore(YearMonth.parse(AN_EXPIRATION_DATE, FORMATTER));

        assertFalse(before);
    }

    @Test
    public void anExpirationDateThatIsBeforeAnother_IsBefore_ReturnsFalse() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);

        boolean before = expirationDate.isBefore(YearMonth.parse(A_PAST_EXPIRATION_DATE, FORMATTER));

        assertFalse(before);
    }

    @Test
    public void anExpirationDateThatIsAfterAnother_IsBefore_ReturnsTrue() {
        expirationDate = new CreditCardExpirationDate(AN_EXPIRATION_DATE);

        boolean before = expirationDate.isBefore(YearMonth.parse(A_NEXT_EXPIRATION_DATE, FORMATTER));

        assertTrue(before);
    }
}