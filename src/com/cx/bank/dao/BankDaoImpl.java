package com.cx.bank.dao;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;

import java.io.*;
import java.util.Properties;

/*
作者：李越@Eszeed
类名：BankDaoInterface
功能说明：
存储方法实现—saveMoney()
添加用户方法实现—insertUser()
更新方法说明实现—updateMoney()
按名字查找用户实现—findByName ()
按用户名和密码查找用户实现—findUser()

*/
public class BankDaoImpl implements BankDaoInterface{
    private static BankDaoImpl instance = null;
    private BankDaoImpl(){}

    public static BankDaoImpl getInstance(){
        if(instance == null){
            instance = new BankDaoImpl();
        }
        return instance;
    }
    @Override
    public void saveMoney(double money,String fileName) {
        String filePath = "D:\\Code\\Java_Code\\practicalTraining\\File\\"+fileName+".properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
            OutputStream fos = new FileOutputStream(filePath);
            properties.setProperty("money",String.valueOf(money));
            properties.store(fos,"存钱");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertUser(UserBean user,String fileName) {
        String filePath = "D:\\Code\\Java_Code\\practicalTraining\\File\\"+fileName+".properties";
        Properties properties = new Properties();
        try {
            OutputStream fos = new FileOutputStream(filePath);
            properties.setProperty("username",user.getUsername());
            properties.setProperty("password",user.getPassword());
            properties.store(fos,"插入用户");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateMoney(double money,String fileName) {
        String filePath = "D:\\Code\\Java_Code\\practicalTraining\\File\\"+fileName+".properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
            OutputStream fos = new FileOutputStream(filePath);
            properties.setProperty("money",String.valueOf(money));
            properties.store(fos,"更新余额");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserBean findUserByName(String username) {
        String filePath = "D:\\Code\\Java_Code\\practicalTraining\\File\\"+username+".properties";
        Properties properties = new Properties();
        UserBean userBean = new UserBean();
        try {
            properties.load(new FileReader(filePath));
            String name = properties.getProperty("username");
            String password = properties.getProperty("password");
            userBean.setUsername(name);
            userBean.setPassword(password);
            return userBean;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserBean findUser(String username, String password, String filename) {
        String filePath = "D:\\Code\\Java_Code\\practicalTraining\\File\\"+username+".properties";
        Properties properties = new Properties();
        UserBean userBean = new UserBean();
        try {
            properties.load(new FileReader(filePath));
            String name = properties.getProperty("username");
            String password1 = properties.getProperty("password");
            if (name.equals(username)||password1.equals(password)){
                userBean.setPassword(password);
                userBean.setUsername(username);
            }
            return userBean;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
