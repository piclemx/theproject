package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class CreditCardFactoryTest {

    private final static RequestCardNumber A_NUMBER_BEGINNING_FOUR = new RequestCardNumber("4716 3199 7859 2070");
    private final static RequestCardNumber A_NUMBER_BEGINNING_ANY_BUT_FOUR = new RequestCardNumber("1540 5555 5555 5555");
    private final static RequestExpirationDate AN_EXPIRATION_DATE = new RequestExpirationDate("01/10");

    @Test
    public void aCreditCardRequestThatBeginsWithFour_creating_shouldBeOfTypeVisa() {
        CreditCardFactory creditCardFactory = new CreditCardFactory();

        CreditCard visaCreditCard = creditCardFactory.createCreditCard(A_NUMBER_BEGINNING_FOUR, AN_EXPIRATION_DATE);

        assertThat(visaCreditCard, instanceOf(VisaCreditCard.class));
    }

    @Test
    public void aCreditCardRequestThatBeginsWithAnythingButFour_creating_shouldBeOfTypeGeneric() {
        CreditCardFactory creditCardFactory = new CreditCardFactory();

        CreditCard genericCreditCard = creditCardFactory.createCreditCard(A_NUMBER_BEGINNING_ANY_BUT_FOUR, AN_EXPIRATION_DATE);

        assertThat(genericCreditCard, instanceOf(CreditCard.class));
    }

    @Test
    public void aCreditCardThatBeginsWithFour_creating_shouldBeOfTypeVisa() {
        CreditCardFactory creditCardFactory = new CreditCardFactory();

        CreditCard visaCreditCard = creditCardFactory.createCreditCard(
                new CreditCardNumber(A_NUMBER_BEGINNING_FOUR.getValue()),
                new CreditCardExpirationDate(AN_EXPIRATION_DATE.getValue())
        );

        assertThat(visaCreditCard, instanceOf(VisaCreditCard.class));
    }

    @Test
    public void aCreditCardThatBeginsWithAnythingButFour_creating_shouldBeOfTypeGeneric() {
        CreditCardFactory creditCardFactory = new CreditCardFactory();

        CreditCard genericCreditCard = creditCardFactory.createCreditCard(
                new CreditCardNumber(A_NUMBER_BEGINNING_ANY_BUT_FOUR.getValue()),
                new CreditCardExpirationDate(AN_EXPIRATION_DATE.getValue())
        );

        assertThat(genericCreditCard, instanceOf(CreditCard.class));
    }
}