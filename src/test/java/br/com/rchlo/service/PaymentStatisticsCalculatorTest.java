package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;

import java.util.List;

import mother.PaymentMother;
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

  private final List<Payment> paymentsList = List
      .of(PaymentMother.aCanceledPayment(), PaymentMother.aConfirmedPayment(),
          PaymentMother.anAnotherCreatedPayment(), PaymentMother.aCreatedPayment());


  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
  }

  @Test
  void shouldCalculateMaximumAmountOfConfirmedPayment() {
    Mockito.when(paymentRepository.listConfirmedPayments())
           .thenReturn(paymentsList);
    PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();
    BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics
        .getMaximumAmountOfConfirmedPayment();
    Assertions.assertThat(maximumAmountOfConfirmedPayment)
              .isEqualTo(new BigDecimal("200.00"));
  }

  @Test
  void deveConsiderarQuantidadeDePagamentoPorStatus() {
    Mockito.when(paymentRepository.listConfirmedPayments())
           .thenReturn(paymentsList);

    PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();

    Map<PaymentStatus, Long> quantityOfPaymentsByStatus =
        paymentStatistics.getQuantityOfPaymentsByStatus();
    Assertions.assertThat(quantityOfPaymentsByStatus)
              .containsEntry(PaymentStatus.CREATED, 2L)
              .containsEntry(PaymentStatus.CONFIRMED, 1L)
              .containsEntry(PaymentStatus.CANCELED, 1L);
  }
}
