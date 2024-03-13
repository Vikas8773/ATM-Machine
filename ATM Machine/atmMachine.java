package ASSIGNMENT;
import java.sql.*;
import java.util.*;

public class atmMachine {
    public static void main(String[] args) {
        try {
            Connection con = conProvoder.getCon();

            String q = "insert into ATM(name,accno,Address,balance,atmpin) values(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your pin number:");
            int apin = sc.nextInt();String name=null;
            ResultSet rs = pstmt.executeQuery("select * from atm where atmpin=" + apin);
            System.out.println("ID\tName\taccno\tAddress\t\tBalance\t\tatmpin");
            int count = 0;
            int amount = 0;
            int take_amount=0;
            int balance = 0;
            while (rs.next()) {
                int id = rs.getInt(1);
                name = rs.getString(2);
                int ano = rs.getInt(3);
                String add = rs.getString(4);
                balance = rs.getInt(5);
                String ampin = rs.getString(6);

                System.out.println(id + "\t" + name + "\t" + ano + "\t" + add + "\t\t" + balance + "\t\t" + ampin);
                count++;
            }
            int check;
            if(count>0){
                do {
                    System.out.println("Welcome "+name);
                    System.out.println("Enter the operation you want to perform:\n1.withdraw money\n2.check account balance" +
                            "\n3.deposit money\n4.get receipt\n0.Exit ");
                    check = sc.nextInt();

                    switch (check) {
                        case 1:
                            System.out.println("Enter the amount you want to withdraw: ");
                            amount = sc.nextInt();
                            if (amount > 0 && balance >= amount) {
                                balance -= amount;
                                System.out.println("Amount withdraw successfully\n");
                                System.out.println("the amount you have withdrawed:" + amount);
                            } else {
                                System.out.println("Insufficient balance!\n");
                            }
                            pstmt.executeUpdate("update atm set balance=" + balance + " where atmpin=" + apin);
                            break;
                        case 2:
                            System.out.println("Your account balance is:" + balance+"\n");
                            break;
                        case 3:
                            System.out.println("Enter the amount you want to deposit:");
                            take_amount = sc.nextInt();
                            balance = balance + take_amount;
                            System.out.println("Rupees " + take_amount + " deposited successfully\n");
                            pstmt.executeUpdate("update atm set balance=" + balance + " where atmpin=" + apin);
                            break;
                        case 4:
                            System.out.println("Thanks for coming");
                            System.out.println("your account balance :"+balance);
                            System.out.println("The amount you have withdraw :"+amount);
                            System.out.println("The amount you have added :"+take_amount+"\n");
                    }

                } while (check != 0);
            }
            else{
                System.out.println("wrong pin");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




