package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

class PaymentStatisticsCalculatorTest {

    private PaymentRepository paymentRepository;
    private PaymentStatisticsCalculator paymentStatisticsCalculator;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
    }

    @Test
    void shouldCalculateMaximumAmountOfConfirmedPayment() {
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();

        BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics.getMaximumAmountOfConfirmedPayment();
        Assertions.assertThat(maximumAmountOfConfirmedPayment).isEqualTo(new BigDecimal("200.00"));
    }

    @Test
    void deveConsiderarQuantidadeDePagamentoPorStatus() {
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();

        Map<PaymentStatus, Long> quantityOfPaymentsByStatus = paymentStatistics.getQuantityOfPaymentsByStatus();
        Assertions.assertThat(quantityOfPaymentsByStatus)
                .containsEntry(PaymentStatus.CREATED, 2L)
                .containsEntry(PaymentStatus.CONFIRMED, 1L)
                .containsEntry(PaymentStatus.CANCELED, 1L);
    }

}