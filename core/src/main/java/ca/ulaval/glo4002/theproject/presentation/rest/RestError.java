package ca.ulaval.glo4002.theproject.presentation.rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class RestError {

    @XmlElement(name = "codeErreur")
    private int code;

    @XmlElement(name = "descriptionErreur")
    private String message;

    @XmlElement(name = "transactionsInadmissibles")
    private List<String> elements;

    public RestError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestError(int code, String message, List<String> elements) {
        this.code = code;
        this.message = message;
        this.elements = elements;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
