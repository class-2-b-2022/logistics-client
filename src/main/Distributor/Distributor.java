package main.Distributor;

import java.net.Socket;
import java.util.Scanner;

public class Distributor {
    public static void main(String[] args) {
        DistributorModel p1 = new DistributorModel();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your FirstName");
        p1.setFirst_name(myObj.nextLine());
        System.out.println("Enter your LastName");
        p1.setLast_name(myObj.nextLine());
        System.out.println("Enter your email");
        p1.setEmail(myObj.nextLine());
        System.out.println("Enter your telephone");
        p1.setTelephone(myObj.nextLine());
        System.out.println("Enter your business name");
        String business_name = myObj.nextLine();
        p1.setBusiness_name(myObj.nextLine());
        System.out.println("Enter business description");
        p1.setBusiness_description(myObj.nextLine());


    }
}
