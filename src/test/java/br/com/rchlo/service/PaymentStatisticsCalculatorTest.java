package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import br.com.rchlo.util.GeneratePaymentsForTests;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class PaymentStatisticsCalculatorTest {

    private PaymentStatisticsCalculator paymentStatisticsCalculator;

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Payment> generate = GeneratePaymentsForTests.generate();
        paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
    }

    @Test
    void shouldCalculateMaximumAmountOfConfirmedPayment() {
        Mockito.when(paymentRepository.all()).thenReturn(GeneratePaymentsForTests.generate());
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();
        BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics.getMaximumAmountOfConfirmedPayment();
        Assertions.assertThat(maximumAmountOfConfirmedPayment).isEqualTo(new BigDecimal("200.00"));
    }

    @Test
    void deveConsiderarQuantidadeDePagamentoPorStatus() {
        Mockito.when(paymentRepository.all()).thenReturn(GeneratePaymentsForTests.generate());

        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();

        Map<PaymentStatus, Long> quantityOfPaymentsByStatus = paymentStatistics.getQuantityOfPaymentsByStatus();
        Assertions.assertThat(quantityOfPaymentsByStatus)
                .containsEntry(PaymentStatus.CREATED, 2L)
                .containsEntry(PaymentStatus.CONFIRMED, 1L)
                .containsEntry(PaymentStatus.CANCELED, 1L);
    }

}