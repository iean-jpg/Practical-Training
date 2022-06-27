package com.cx.bank.test;

import com.cx.bank.manager.ManagerImpl;
import com.cx.bank.manager.managerInterface;
import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;
import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import java.io.IOException;
import java.util.Scanner;

public class TestBank {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        UserBean userBean = new UserBean();
        managerInterface managerInterface = ManagerImpl.getInstance();
        String username;
        String password;
        boolean flag;
        while (true){
            System.out.println("**************************");
            System.out.println("\t银行管理系统");
            System.out.println("\t********");
            System.out.println("    1.登录\t2.注册");
            System.out.println("    3.退出\t");
            System.out.print("请输入选项：");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    System.out.println("请输入用户名：");
                    username = scanner.next();
                    System.out.println("请输入密码：");
                    password = scanner.next();
                    flag = managerInterface.login(username,password);
                    if (flag==true){
                        userBean.setUsername(username);
                        userBean.setPassword(password);
                        menu(userBean);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("请输入用户名：");
                        username = scanner.next();
                        System.out.println("请输入密码：");
                        password = scanner.next();
                        flag = managerInterface.register(username,password);
                        if(flag==true){
                            userBean.setUsername(username);
                            userBean.setPassword(password);
                        }
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 3:
                    System.exit(0);
            }
        }
    }

    public static void menu(UserBean userBean){
        MoneyBean account = new MoneyBean();
        Scanner input = new Scanner(System.in);
        managerInterface manager = ManagerImpl.getInstance();
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
                try {
                    manager.deposit(account,money);
                } catch (InvalidDepositException e) {
                    System.out.println(e.getMessage());
                }
            }else if(flag==2){
                System.out.println("请输入要取的金额：");
                money = input.nextDouble();
                try {
                    manager.wirhDrawals(account,money);
                } catch (AccountOverDrawnException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidDepositException e) {
                    System.out.println(e.getMessage());
                }
            }else if(flag==3){
                manager.inquiry(account);
            }else {
                manager.exitSystem(account,userBean);
            }
        }
    }
}
