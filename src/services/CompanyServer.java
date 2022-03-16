package services;

import Utils.RequestBody;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CompanyServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5450)) {
            while (true) {
                Socket socket = serverSocket.accept();
                startHandler(socket);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void startHandler (final Socket socket) throws IOException, ClassNotFoundException {
        Thread thread = new Thread(() -> {

            try{
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                RequestBody requestBody = (RequestBody) objectInputStream.readObject();
                System.out.println(requestBody.getAction());
                JSONObject jsonObject = new JSONObject(requestBody.getData());
                String companyName = jsonObject.getString("CompanyName");
                String companyDescription = jsonObject.getString("CompanyDescription");
                String companyEmail = jsonObject.getString("CompanyEmail");
                String companyType = jsonObject.getString("CompanyType");
                String companyPhone = jsonObject.getString("CompanyPhone");


//                System.out.println("sending to from server \n" + jsonObject);


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
