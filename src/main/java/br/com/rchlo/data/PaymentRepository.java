package br.com.rchlo.data;

import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    private List<Payment> getPayments(List<Payment> allPayments, String query) {
        ConnectionFactory.init();
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                BigDecimal amount = resultSet.getBigDecimal("amount");

                String cardHolderName = resultSet.getString("card_holder_name");
                String cardNumber = resultSet.getString("card_number");
                YearMonth cardExpiration = YearMonth.parse(resultSet.getString("card_expiration"));
                String cardVerificationCode = resultSet.getString("card_verification_code");

                var card = new Card(cardHolderName, cardNumber, cardExpiration,
                    cardVerificationCode);

                var status = PaymentStatus.valueOf(resultSet.getString("status"));

                var pagamento = new Payment(id, amount, card, status);

                allPayments.add(pagamento);

            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Error retrieving payments", ex);
        }

        return allPayments;
    }

    public List<Payment> listConfirmedPayments() {
        List<Payment> allPayments = new ArrayList<>();

        String query = "select * from payment where status = 'CONFIRMED';";
        return getPayments(allPayments, query);

    }

    public List<Payment> all() {

        List<Payment> allPayments = new ArrayList<>();

        String query =
            "select id, amount, card_holder_name, card_number, card_expiration, card_verification_code, status"
                +
                " from payment";

        return getPayments(allPayments, query);
    }
}
