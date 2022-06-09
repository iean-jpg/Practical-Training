package com.cx.bank.manager;

import com.cx.bank.model.MoneyBean;

public class ManagerImpl {
    /*
    * 方法名：deposit
    * 完成功能：存款功能
    */
    public static boolean deposit(MoneyBean account,double money){
        if(money<0){
            System.out.println("存款金额小于0");
            return false;
        }
        account.setBalance(money);
        return true;
    }
    /*
     * 方法名：withdrawals
     * 完成功能：取款功能
     */
    public static boolean wirhDrawals(MoneyBean account,double money){;
        if(money<0 || money>account.getBalance()){
            System.out.println("取款金额小于0或者大于余额");
            return false;
        }
        double balance = account.getBalance();
        account.setBalance(balance-money);
        return true;
    }
    /*
     * 方法名：inquiry
     * 完成功能：查询余额
     */
    public static void inquiry(MoneyBean account){
        System.out.println("您的余额为："+account.getBalance());
    }
    /*
     * 方法名：exitSystem
     * 完成功能：退出系统
     */
    public static void exitSystem(){
        System.exit(0);
    }
}
