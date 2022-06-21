package com.cx.bank.model;

public class MoneyBean {
    private double balance;
    private static MoneyBean instance;
    private MoneyBean(){}
    private MoneyBean(double balance) {
        this.balance = balance;
    }

    public static MoneyBean getInstance(){
        if(instance == null){
            instance = new MoneyBean();
        }
        return instance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
