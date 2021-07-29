package br.com.rchlo.domain;

import java.math.BigDecimal;

public class Payment {

    private Long id;
    private BigDecimal amount;
    private Card card;
    private PaymentStatus status;

    public Payment(BigDecimal amount, Card card, PaymentStatus status) {
        this.amount = amount;
        this.card = card;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
            "id=" + id +
            ", amount=" + amount +
            ", card=" + card +
            ", status=" + status +
            '}';
    }

    public Payment(Long id, BigDecimal amount, Card card, PaymentStatus status) {
       this(amount, card, status);
       this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Card getCard() {
        return card;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
