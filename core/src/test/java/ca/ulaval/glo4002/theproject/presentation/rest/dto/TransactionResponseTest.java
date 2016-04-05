package ca.ulaval.glo4002.theproject.presentation.rest.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionResponseTest {

    private final String A_REFERENCE_NUMBER = "1245";

    private TransactionResponse response;

    @Before
    public void init() {
        response = new TransactionResponse(A_REFERENCE_NUMBER);
    }


    @Test
    public void anOKResponseWithAReferenceNumber_GetJudgment_ReturnsJudgmentTrue() {
        Boolean judgment = response.getJudgment();

        assertTrue(judgment);
    }

    @Test
    public void anOKResponseWithoutAReferenceNumber_GetJudgment_ReturnsJudgmentFalse() {
        response = new TransactionResponse();

        Boolean judgment = response.getJudgment();

        assertFalse(judgment);
    }

    @Test
    public void anOKResponseWithReferenceNumber_GetReferenceNumber_ReturnsReferenceNumber() {
        String referenceNumber = response.getReferenceNumber();

        assertEquals(A_REFERENCE_NUMBER, referenceNumber);

    }

    @Test
    public void anOKResponseWithoutReferenceNumber_GetReferenceNumber_ReturnsNull() {
        response = new TransactionResponse();

        String referenceNumber = response.getReferenceNumber();

        assertNull(referenceNumber);
    }
}