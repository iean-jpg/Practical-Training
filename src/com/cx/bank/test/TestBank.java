package com.cx.bank.test;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.model.MoneyBean;

import java.util.Scanner;

public class TestBank {
    public static void main(String[] args){
        MoneyBean account = new MoneyBean();
        Scanner input = new Scanner(System.in);
        int flag;
        double money;
        while(true){
            System.out.println("**************************");
            System.out.println("\t银行管理系统");
            System.out.println("\t********");
            System.out.println("    1.存钱\t2.取钱");
            System.out.println("    3.查询\t4.退出");
            System.out.print("请输入选项：");
            flag=input.nextInt();
            if (flag==1){
                System.out.println("请输入要存的金额：");
                money = input.nextDouble();
                ManagerImpl.deposit(account,money);
            }else if(flag==2){
                System.out.println("请输入要取的金额：");
                money = input.nextDouble();
                ManagerImpl.wirhDrawals(account,money);
            }else if(flag==3){
                ManagerImpl.inquiry(account);
            }else {
                ManagerImpl.exitSystem();
            }

        }
    }
}
