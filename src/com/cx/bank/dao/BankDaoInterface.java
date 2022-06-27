package com.cx.bank.dao;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;

/*
作者：李越@Eszeed
类名：BankDaoInterface
功能说明：
存储方法说明—saveMoney()：可用于退出系统功能
添加用户方法说明—insertUser()：可用于注册功能
更新方法说明—updateMoney()：可用于转账功能
按名字查找用户说明—findByName ()：可用于注册功能
按用户名和密码查找用户说明—findUser()：可用于登录功能
*/
public interface BankDaoInterface {
    void saveMoney(double money,String fileName);
    void insertUser(UserBean user,String filename);
    void updateMoney(double money,String filename);
    UserBean findUserByName(String username);
    UserBean findUser(String username,String password,String filename);
}
