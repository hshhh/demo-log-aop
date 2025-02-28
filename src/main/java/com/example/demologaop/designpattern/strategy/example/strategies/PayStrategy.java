package com.example.demologaop.designpattern.strategy.example.strategies;

public interface PayStrategy {

    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
