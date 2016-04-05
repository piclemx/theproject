package ca.ulaval.glo4002.theproject.persistence;

import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.GenericCreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.VisaCreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HibernateCreditCardRepositoryITest {

    private final CreditCardNumber A_CARD_NUMBER_NOT_IN_DATABASE = new CreditCardNumber("");

    private final CreditCardNumber A_GENERIC_CARD_NUMBER = new CreditCardNumber("987654321");
    private final CreditCardNumber A_VISA_CARD_NUMBER = new CreditCardNumber("4716 3199 7859 2070");
    private final CreditCardExpirationDate AN_EXPIRATION_DATE = new CreditCardExpirationDate("01/01");
    private final CreditCardExpirationDate ANOTHER_EXPIRATION_DATE = new CreditCardExpirationDate("02/02");

    private HibernateCreditCardRepository repository;

    @Before
    public void createEntityManager() {
        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        repository = new HibernateCreditCardRepository();
    }

    @After
    public void clearEntityManager() {
        EntityManagerProvider.clearEntityManager();
    }

    @Test
    public void persistsTheCreditCard_FindByNumber_ShouldHaveACreditCard() {
        CreditCard creditCard = createGenericCreditCard();

        assertTrue(creditCard.getCardNumber().equals(A_GENERIC_CARD_NUMBER));
    }

    @Test(expected = CreditCardNotFoundException.class)
    public void noCreditCard_FindByNumber_ShouldThrowException() {
        repository.findByCardNumber(A_CARD_NUMBER_NOT_IN_DATABASE);
    }

    @Test
    public void aCreditCard_ChangeExpirationDate_ShouldHaveChangeTheExpirationDate() {
        CreditCard creditCard = createGenericCreditCard();

        creditCard.setExpirationDate(ANOTHER_EXPIRATION_DATE);
        repository.persist(creditCard);

        CreditCard hibernateCreditCard = repository.findByCardNumber(A_GENERIC_CARD_NUMBER);
        assertTrue(hibernateCreditCard.getExpirationDate().equals(ANOTHER_EXPIRATION_DATE));
    }

    @Test
    public void aVisaCreditCard_FindByNumber_ShouldReturnVisaCreditCard() {
        CreditCard creditCard = createVisaCreditCard();

        assertThat(creditCard, instanceOf(VisaCreditCard.class));
    }

    @Test
    public void aCreditCard_FindByNumber_ShouldReturnGenericCreditCard() {
        CreditCard creditCard = createGenericCreditCard();

        assertThat(creditCard, instanceOf(GenericCreditCard.class));
    }

    private CreditCard createGenericCreditCard() {
        try {
            return repository.findByCardNumber(A_GENERIC_CARD_NUMBER);
        } catch (CreditCardNotFoundException e) {
            CreditCard creditCard = new GenericCreditCard(A_GENERIC_CARD_NUMBER, AN_EXPIRATION_DATE);
            repository.persist(creditCard);
            return creditCard;
        }
    }

    private CreditCard createVisaCreditCard() {
        try {
            return repository.findByCardNumber(A_VISA_CARD_NUMBER);
        } catch (CreditCardNotFoundException e) {
            CreditCard creditCard = new VisaCreditCard(A_VISA_CARD_NUMBER, AN_EXPIRATION_DATE);
            repository.persist(creditCard);
            return creditCard;
        }
    }
}
