package com.cx.bank.manager;

import com.cx.bank.dao.BankDaoImpl;
import com.cx.bank.dao.BankDaoInterface;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ManagerImpl implements managerInterface {
    private static ManagerImpl instance = null;
    private ManagerImpl(){}

    public static ManagerImpl getInstance(){
        if(instance == null){
            instance = new ManagerImpl();
        }
        return instance;
    }
    /*
     * 方法名：register
     * 完成功能：注册
     */
    @Override
    public boolean register(String username, String password){
        String filePath = "D:\\Code\\Java_Code\\practicalTraining\\File\\"+username+".properties";
        BankDaoInterface bankDaoInterface = BankDaoImpl.getInstance();
        File file = new File(filePath);
        if(file.exists()){
            System.out.println("用户已存在");
            return false;
        }
        UserBean userBean = new UserBean(username,password);
        bankDaoInterface.insertUser(userBean,username);
        return true;
    }
    /*
     * 方法名：login
     * 完成功能：登录
     */
    @Override
    public boolean login(String username, String password) {
        BankDaoInterface bankDaoInterface = BankDaoImpl.getInstance();
        UserBean userBean = new UserBean();
        userBean = bankDaoInterface.findUserByName(username);
        if(userBean!=null){
            System.out.println("登录成功");
            return true;
        }
        System.out.println("登录失败");
        return false;
    }

    /*
    * 方法名：deposit
    * 完成功能：存款功能
    */
    public boolean deposit(MoneyBean account, double money) throws InvalidDepositException {
        if(money<0){
            throw new InvalidDepositException("存款金额小于0");
        }
        account.setBalance(money);
        return true;
    }
    /*
     * 方法名：withdrawals
     * 完成功能：取款功能
     */
    public boolean wirhDrawals(MoneyBean account,double money) throws AccountOverDrawnException, InvalidDepositException {;
        if(money>account.getBalance()){
            double needs = money - account.getBalance();
            throw new AccountOverDrawnException("余额不足");
        } else if (money<0) {
            throw new InvalidDepositException("取款金额小于0");
        }
        double balance = account.getBalance();
        account.setBalance(balance-money);
        return true;
    }
    /*
     * 方法名：inquiry
     * 完成功能：查询余额
     */
    public void inquiry(MoneyBean account){
        System.out.println("您的余额为："+account.getBalance());
    }
    /*
     * 方法名：exitSystem
     * 完成功能：退出系统
     */
    public void exitSystem(MoneyBean moneyBean,UserBean userBean){
        BankDaoInterface bankDaoInterface = BankDaoImpl.getInstance();
        bankDaoInterface.saveMoney(moneyBean.getBalance(),userBean.getUsername());
        System.exit(0);
    }
}
