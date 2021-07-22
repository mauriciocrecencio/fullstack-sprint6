package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PaymentStatistics extends HashMap<PaymentStatus, Long> {

    private BigDecimal maximumAmountOfConfirmedPayment;

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return this;
    }

    public void addPaymentForStatus(PaymentStatus status) {
        Long quantity = this.get(status);
        if (quantity == null) {
            quantity = 1L;
        } else {
            quantity++;
        }
        this.put(status, quantity);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean replace(PaymentStatus key, Long oldValue, Long newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends PaymentStatus, ? extends Long> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long merge(PaymentStatus key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        throw new UnsupportedOperationException();
    }

}
