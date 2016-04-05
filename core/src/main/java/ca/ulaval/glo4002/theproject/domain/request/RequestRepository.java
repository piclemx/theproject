package ca.ulaval.glo4002.theproject.domain.request;

import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;

import java.util.List;

public interface RequestRepository {

    List<Request> findByCardNumber(RequestCardNumber cardNumber);

    void persist(Request request);
}
