package com.example.demologaop.designpattern.strategy.example.strategies;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy{
   private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));




    @Override
    public boolean pay(int paymentAmount) {
        return false;
    }

    @Override
    public void collectPaymentDetails() {

    }
}
