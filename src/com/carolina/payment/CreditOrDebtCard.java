package com.carolina.payment;

public abstract class CreditOrDebtCard {
    private String cardNumber;

    public CreditOrDebtCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean isValid() {
        return false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
