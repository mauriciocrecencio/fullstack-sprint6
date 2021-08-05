package br.com.rchlo.util;

import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class GeneratePaymentsForTests {

    public static List<Payment> generate() {
        Card card = new Card("Holder Name Test", "123123", YearMonth.now(), "456");

        return List.of(
            new Payment(new BigDecimal("190.00"), card, PaymentStatus.CREATED),
            new Payment(new BigDecimal("200.00"), card, PaymentStatus.CREATED),
            new Payment(new BigDecimal("200.00"), card, PaymentStatus.CONFIRMED),
            new Payment(new BigDecimal("180.00"), card, PaymentStatus.CANCELED)
        );
    }

}
