package main.views.inventory;

import models.*;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Inventory {
    InventoryModel inventoryModel = new InventoryModel();
    Scanner sc = new Scanner(System.in);
    ClientRequest request;
    public void create(){
        try {
            Socket socket = new Socket("localhost",5450);
            OutputStream outToServer = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outToServer);

            System.out.println("IN/OUT? ");
            inventoryModel.setStatus(sc.nextLine());

            System.out.println("How many products? ");
            inventoryModel.setQuantity(sc.nextInt());

            System.out.print("Price per product : ");
            inventoryModel.setPrice(sc.nextLine());

            inventoryModel.setProductId(1);
            inventoryModel.setUserId(1);
            inventoryModel.setDate(new Date("2022-01-28"));
            request = new ClientRequest("/inventory", "post", inventoryModel);

            out.writeObject(request);
            InputStream serverResponse = socket.getInputStream();
            ObjectInputStream inFromServer = new ObjectInputStream(serverResponse);
            System.out.println(inFromServer.readObject());

            if (inFromServer.readObject() == null){
                System.out.println("Can't create an inventory with no products are registered");
                return;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
