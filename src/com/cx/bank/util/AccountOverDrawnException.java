package com.cx.bank.util;

public class AccountOverDrawnException extends Exception{
    public AccountOverDrawnException(String msg){
        super(msg);
    }

    public AccountOverDrawnException(){}

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
