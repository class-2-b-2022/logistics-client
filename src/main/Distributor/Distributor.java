package main.Distributor;

import java.io.IOException;
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
        System.out.println("Enter your distributor role");
        p1.setDistributor_type(myObj.nextLine());
        System.out.println("Enter your business name");
        p1.setBusiness_name(myObj.nextLine());
        System.out.println("Enter business description");
        p1.setBusiness_description(myObj.nextLine());

        try {
            Socket socket = new Socket("192.168.0.137", 1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
