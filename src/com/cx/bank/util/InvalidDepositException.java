package com.cx.bank.util;

public class InvalidDepositException extends Exception {
    public InvalidDepositException(){}
    public InvalidDepositException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
