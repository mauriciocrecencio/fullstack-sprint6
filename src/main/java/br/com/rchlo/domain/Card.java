package br.com.rchlo.domain;

import java.time.YearMonth;

public class Card {

    private String holderName;
    private String number;
    private YearMonth expiration;
    private String verificationCode;

    public Card(String holderName, String number, YearMonth expiration, String verificationCode) {
        this.holderName = holderName;
        this.number = number;
        this.expiration = expiration;
        this.verificationCode = verificationCode;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getNumber() {
        return number;
    }

    public YearMonth getExpiration() {
        return expiration;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
