package com.zosh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


public class PaymentInformation {

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "card_namber")
    private String cardNamber;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "cvv")
    private String cvv;
}
