package com.carolina.payment;

import java.util.Date;


public class Payment {
    private Long paymentId;
    private Date paymentDay;

    public Payment(Long paymentId, Date paymentDay) {
        this.paymentId = paymentId;
        this.paymentDay = paymentDay;
    }


    public Date getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Date paymentDay) {
        this.paymentDay = paymentDay;
    }

    public Long getPaymentId() {
        return paymentId;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        return getPaymentId() != null ? getPaymentId().equals(payment.getPaymentId()) : payment.getPaymentId() == null;
    }

    @Override
    public int hashCode() {
        return getPaymentId() != null ? getPaymentId().hashCode() : 0;
    }
}
