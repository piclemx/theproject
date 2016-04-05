package ca.ulaval.glo4002.theproject.domain.request.value;

import org.junit.Test;

import static org.junit.Assert.*;

public class RequestExpirationDateTest {

    private final String AN_EXPIRATION_DATE = "01/02";
    private final String AN_EQUAL_EXPIRATION_DATE = "01/02";
    private final String A_DIFFERENT_EXPIRATION_DATE = "10/15";
    private final String AN_EXPIRATION_DATE_WITHOUT_ZEROS = "1/2";
    private final String AN_EXPIRATION_DATE_WITHOUT_SLASH = "0102";
    private final String AN_EXPIRATION_DATE_WITH_DASH = "01-02";
    private final String AN_EXPIRATION_DATE_WITH_YEAR = "2015/01/02";
    private final String AN_EXPIRATION_DATE_WITH_NUMBERS_TOO_HIGH = "32/15";
    private final String AN_EMPTY_EXPIRATION_DATE = "";
    private final String A_MISSING_EXPIRATION_DATE = null;

    private RequestExpirationDate expirationDate;

    @Test
    public void expirationDate_CreatedWithoutValues_ShouldCreateAnExpirationDateWithEmptyString() {
        expirationDate = new RequestExpirationDate();

        assertEquals(AN_EMPTY_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void expirationDate_CreatedWithNullExpirationDate_ShouldCreateAnExpirationDateWithEmptyString() {
        expirationDate = new RequestExpirationDate(A_MISSING_EXPIRATION_DATE);

        assertEquals(AN_EMPTY_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void aCreationWithExpirationDate_GetValue_ReturnsValue() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE);

        assertEquals(AN_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void aCreationWithExpirationDateWithoutZeros_GetValue_ReturnsValueWithZeros() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE_WITHOUT_ZEROS);

        assertEquals(AN_EXPIRATION_DATE, expirationDate.getValue());
    }

    @Test
    public void twoEqualExpirationDates_Equals_ReturnsTrue() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE);
        RequestExpirationDate another_expiration_date = new RequestExpirationDate(AN_EQUAL_EXPIRATION_DATE);

        boolean equals = expirationDate.equals(another_expiration_date);

        assertTrue(equals);
    }

    @Test
    public void twoDifferentExpirationDates_Equals_ReturnsFalse() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE);
        RequestExpirationDate another_expiration_date = new RequestExpirationDate(A_DIFFERENT_EXPIRATION_DATE);

        boolean equals = expirationDate.equals(another_expiration_date);

        assertFalse(equals);
    }

    @Test
    public void aValidExpirationDateWithoutZerosAndOthersValid_Validating_ShouldPass() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE_WITHOUT_ZEROS);

        boolean valid = expirationDate.isValid();

        assertTrue(valid);
    }

    @Test
    public void anInvalidExpirationDateWithoutSlashAndOthersValid_Validating_ShouldFail() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE_WITHOUT_SLASH);

        boolean valid = expirationDate.isValid();

        assertFalse(valid);
    }

    @Test
    public void anInvalidExpirationDateWithDashAndOthersValid_Validating_ShouldFail() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE_WITH_DASH);

        boolean valid = expirationDate.isValid();

        assertFalse(valid);
    }

    @Test
    public void anInvalidExpirationDateWithYearAndOthersValid_Validating_ShouldFail() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE_WITH_YEAR);

        boolean valid = expirationDate.isValid();

        assertFalse(valid);
    }

    @Test
    public void anInvalidExpirationDateWithNumbersTooHighAndOthersValid_Validating_ShouldFail() {
        expirationDate = new RequestExpirationDate(AN_EXPIRATION_DATE_WITH_NUMBERS_TOO_HIGH);

        boolean valid = expirationDate.isValid();

        assertFalse(valid);
    }

    @Test
    public void aMissingExpirationDate_Validating_ShouldFail() {
        expirationDate = new RequestExpirationDate(A_MISSING_EXPIRATION_DATE);

        boolean valid = expirationDate.isValid();

        assertFalse(valid);
    }
}