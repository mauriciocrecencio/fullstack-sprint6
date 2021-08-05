package mother;

import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;

import java.math.BigDecimal;
import java.time.Month;
import java.time.YearMonth;

import static br.com.rchlo.domain.PaymentStatus.*;

public class PaymentMother {

  public static Payment aCreatedPayment() {
    return new Payment(1L, new BigDecimal("200.00"), aCard(), CREATED);
  }

  public static Payment anAnotherCreatedPayment() {
    return new Payment(1L, new BigDecimal("140.00"), aCard(), CREATED);
  }

  public static Payment aCanceledPayment() {
    return new Payment(1L, new BigDecimal("100.00"), aCard(), CANCELED);
  }

  public static Payment aConfirmedPayment() {
    return new Payment(1L, new BigDecimal("200.00"), aCard(), CONFIRMED);
  }




  private static Card aCard() {
    return new Card("MAURICIO CRECENCIO", "1234 1234 1234 1234", YearMonth.of(2022, Month.APRIL), "123");
  }
}
