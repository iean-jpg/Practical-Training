package com.cx.bank.model;

public class MoneyBean {
    private double balance;

    public MoneyBean(){}
    public MoneyBean(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
