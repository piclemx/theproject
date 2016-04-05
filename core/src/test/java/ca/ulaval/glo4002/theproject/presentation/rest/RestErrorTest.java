package ca.ulaval.glo4002.theproject.presentation.rest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestErrorTest {

    private final int A_CODE = 5;
    private final String A_MESSAGE = "A message";

    private RestError restError;

    @Before
    public void init() {
        restError = new RestError(A_CODE, A_MESSAGE);
    }

    @Test
    public void aCode_GetCode_ShouldReturnCode() {
        int code = restError.getCode();

        assertEquals(A_CODE, code);
    }

    @Test
    public void aMessage_GetMessage_ShouldReturnMessage() {
        String message = restError.getMessage();

        assertEquals(A_MESSAGE, message);
    }
}