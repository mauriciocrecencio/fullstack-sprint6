package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;

import java.math.BigDecimal;
import java.util.List;

public class PaymentStatisticsCalculator {

    private final PaymentRepository paymentRepository;

    public PaymentStatisticsCalculator(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentStatistics calculate() {
        List<Payment> allPayments = paymentRepository
            .listConfirmedPayments(); // será que essa é a melhor maneira de fazer isso?

        BigDecimal maximumConfirmedPayment = BigDecimal.ZERO;
        for (Payment payment : allPayments) {
            if (maximumConfirmedPayment.compareTo(payment.getAmount()) < 0) {
                maximumConfirmedPayment = payment.getAmount();
            }
        }

        PaymentStatistics paymentStatistics = new PaymentStatistics(maximumConfirmedPayment);
        for (Payment payment : allPayments) {
            PaymentStatus status = payment.getStatus();
            paymentStatistics.addPaymentForStatus(status);
        }

        return paymentStatistics;
    }
}
