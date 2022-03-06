package main.views.inventory;

import models.*;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    InventoryModel inventoryModel = new InventoryModel();
    Scanner sc = new Scanner(System.in);
    ClientRequest request;
    public void welcome(){
        System.out.println("--------------------Welcome to Inventory MS--------------------------");


    }
    public void create(){
        try {
            DataInputStream serverSaveResult;
            Socket socket = new Socket("localhost",5450);
            OutputStream outToServer = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outToServer);
            int userId = 1;

            request = new ClientRequest("/products", "GET", userId);
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
            System.out.print("(Hint: Choose id from given products) :: ");
            inventoryModel.setProductId(sc.nextInt());

            System.out.println("How many products? ");
            inventoryModel.setQuantity(sc.nextInt());

            // set user who registered inventory
            inventoryModel.setUserId(userId);

            request = new ClientRequest("/inventory", "POST", inventoryModel);
            out.writeObject(request);

            serverSaveResult = new DataInputStream(socket.getInputStream());

            if(serverSaveResult.readInt() > 0){
                System.out.print("successfully registered the inventory");
            }else {
                System.out.println("Please register the product Again. An error occured!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getInventories(int userId){
        try {
            Socket socket = new Socket("localhost",5450);
            OutputStream outToServer = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outToServer);
            // Send request to server
            this.request = new ClientRequest("/inventory", "GET", userId);
            out.writeObject(request);
            ObjectInputStream inventoryFromServer = new ObjectInputStream(socket.getInputStream());

            List inventoryResult = (List) inventoryFromServer.readObject();

           InventoryModel inventoryModel;
            for (int i=0; i<inventoryResult.size(); i++){
                inventoryModel = (InventoryModel) inventoryResult.get(i);
                System.out.println("product id: " + inventoryModel.getProductId() + " Quantity name: " + inventoryModel.getQuantity()
                + " Status " + inventoryModel.getStatus() + " User " + inventoryModel.getUserId());
            }
        }catch (Exception e){
            e.getMessage();
        }
    }
}
