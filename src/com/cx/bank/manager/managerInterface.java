package com.cx.bank.manager;

import com.cx.bank.model.MoneyBean;

public interface managerInterface {
    boolean deposit(MoneyBean account, double money);
    boolean wirhDrawals(MoneyBean account,double money);
    void inquiry(MoneyBean account);
    void exitSystem();
}
