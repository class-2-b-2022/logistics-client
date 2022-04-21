package services;


import formats.RequestBody;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
    private static void startHandler (Socket socket) throws IOException, ClassNotFoundException {
        Thread thread = new Thread(() -> {
            ObjectInputStream objectInputStream = null;
            try{
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                List<String> dt = new ArrayList<>();
                dt = (List<String>) objectInputStream.readObject();
                System.out.println(dt.get(0));
                RequestBody requestBody = (RequestBody) dt.get(0);
                requestBody.getData();


//                System.out.println(requestBody.getAction());
//                System.out.println(requestBody.getAction());
//                JSONObject jsonObject = new JSONObject(requestBody.getData());
//                String companyName = jsonObject.getString("CompanyName");
//                String companyDescription = jsonObject.getString("CompanyDescription");
//                String companyEmail = jsonObject.getString("CompanyEmail");
//                String companyType = jsonObject.getString("CompanyType");
//                String companyPhone = jsonObject.getString("CompanyPhone");


<<<<<<< Updated upstream
//                System.out.println("sending to from server \n" + jsonObject);
=======
                writer.write(jsonObject + "\n");
                writer.flush();
                System.out.println("sending from server \n" + jsonObject);
>>>>>>> Stashed changes


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
