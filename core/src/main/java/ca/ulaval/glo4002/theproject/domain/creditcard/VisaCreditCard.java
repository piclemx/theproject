package ca.ulaval.glo4002.theproject.domain.creditcard;

import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("visa")
public class VisaCreditCard extends CreditCard {

    public VisaCreditCard() {
        super();
    }

    public VisaCreditCard(CreditCardNumber cardNumber, CreditCardExpirationDate expirationDate) {
        super(cardNumber, expirationDate);
    }

    @Override
    public boolean isValid() {
        return correctNumberOfDigits() && validChecksum();
    }

    private boolean correctNumberOfDigits() {
        int numDigits = this.countDigits();
        return numDigits == 13 || numDigits == 16;
    }

    private int countDigits() {
        return this.cardNumber.getLength();
    }

    private boolean validChecksum() {
        int cardNumberNumDigits = this.cardNumber.getLength() - 1;
        boolean isAnEvenIndex = true;
        int summedDigits = 0;

        for (int i = cardNumberNumDigits; i >= 0; i--) {
            int checkedDigit;
            int digit = Character.getNumericValue(this.cardNumber.getCharAt(i));
            if (isAnEvenIndex) {
                checkedDigit = digit;
                isAnEvenIndex = false;
            } else {
                int doubled = digit * 2;
                if (doubled >= 10) {
                    checkedDigit = this.sumDigitsOfInteger(doubled);
                } else {
                    checkedDigit = doubled;
                }
                isAnEvenIndex = true;
            }
            summedDigits += checkedDigit;
        }

        return summedDigits % 10 == 0;
    }

    private int sumDigitsOfInteger(int digits) {
        int sum = 0;
        while (digits > 0) {
            sum += digits % 10;
            digits /= 10;
        }
        return sum;
    }
}
