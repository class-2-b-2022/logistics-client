package main.views.inventory;

import models.*;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    InventoryModel inventoryModel = new InventoryModel();
    Scanner sc = new Scanner(System.in);
    ClientRequest request;
    public void create(){
        try {
            System.out.println("Welcome to Inventory MIS, register inventory please!");

            Socket socket = new Socket("localhost",5450);
            OutputStream outToServer = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outToServer);

            request = new ClientRequest("/inventory/getProducts", "get", "");
            out.writeObject(request);

            InputStream serverResponse = socket.getInputStream();
            ObjectInputStream inFromServer = new ObjectInputStream(serverResponse);

            List productResult = (List) inFromServer.readObject();
            if(productResult.isEmpty()){
                System.out.println("Not allowed to register the inventory. No products available");
                System.exit(1);
            }


            System.out.println("Choose from the following products: ");
            ProductModel productModel;
            for (int i=0; i<productResult.size(); i++){
                productModel = (ProductModel) productResult.get(i);
                System.out.println("id: " + productModel.getProductId() + " name: " + productModel.getProductName());
            }
            System.out.println(" ");
            System.out.println("IN/OUT? ");
            inventoryModel.setStatus(sc.nextLine());

            System.out.println("which product? ");
            inventoryModel.setProductId(sc.nextInt());

            System.out.println("How many products? ");
            inventoryModel.setQuantity(sc.nextInt());

            inventoryModel.setProductId(1);
            inventoryModel.setUserId(1);

            request = new ClientRequest("/inventory", "post", inventoryModel);
            out.writeObject(request);

            serverResponse = socket.getInputStream();
            System.out.println(serverResponse);


            inFromServer = new ObjectInputStream(serverResponse);
//            productResult = (List) inFromServer.readObject();
//            System.out.println(productResult);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
