package br.com.rchlo.util;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GeneratePaymentsForTests {

    public static List<Payment> generate() {
        Card card = new Card("Holder Name Test", "123123", YearMonth.now(), "456");

//        Por que não funciona com Array List
        return List.of(
            new Payment(new BigDecimal("190.00"), card, PaymentStatus.CREATED),
            new Payment(new BigDecimal("200.00"), card, PaymentStatus.CREATED),
            new Payment(new BigDecimal("200.00"), card, PaymentStatus.CONFIRMED),
            new Payment(new BigDecimal("180.00"), card, PaymentStatus.CANCELED)
        );
    }

}
