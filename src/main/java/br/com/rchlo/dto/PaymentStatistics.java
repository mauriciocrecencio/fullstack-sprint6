package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PaymentStatistics  {

    private BigDecimal maximumAmountOfConfirmedPayment;
    HashMap<PaymentStatus, Long> mapPaymentStatistics = new HashMap<>();

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return mapPaymentStatistics;
    }

    public void addPaymentForStatus(PaymentStatus status) {
        Long quantity = mapPaymentStatistics.get(status);
        if (quantity == null) {
            quantity = 1L;
        } else {
            quantity++;
        }
        mapPaymentStatistics.put(status, quantity);
    }



}
