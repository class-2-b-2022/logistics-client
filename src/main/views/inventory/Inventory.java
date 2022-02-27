package main.views.inventory;

import models.*;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Inventory {
    public void create(){
        try {
            Socket socket = new Socket("localhost",5450);
            OutputStream checkProducts = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(checkProducts);
            String data = "some dataa";
            ClientRequest request = new ClientRequest("/inventory", "create", data);
            out.writeObject(request);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
