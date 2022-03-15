package com.carolina.payment;

import java.util.Date;


public class Payment {
    private Long paymentId;
    private PaymentMethod paymentMethod;
    private Date paymentDay;

    public Payment(Long paymentId, PaymentMethod paymentMethod, Date paymentDay) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymentDay = paymentDay;
    }

    public Payment(PaymentMethod paymentMethod, Date paymentDay) {
        this.paymentMethod = paymentMethod;
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


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
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
