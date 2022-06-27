package com.cx.bank.manager;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface managerInterface {
    boolean register(String username,String password) throws IOException;
    boolean login(String username,String password);
    boolean deposit(MoneyBean account, double money) throws InvalidDepositException;
    boolean wirhDrawals(MoneyBean account,double money) throws AccountOverDrawnException, InvalidDepositException;
    void inquiry(MoneyBean account);
    void exitSystem(MoneyBean moneyBean, UserBean userBean);
}
