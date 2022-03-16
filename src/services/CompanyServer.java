package services;

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
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private static void startHandler (final Socket socket) {
        Thread thread = new Thread(() -> {
            try{
                OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

                String line = reader.readLine();
                JSONObject jsonObject = new JSONObject(line);

                writer.write(jsonObject + "\n");
                writer.flush();
                System.out.println("sending to from server \n" + jsonObject);


            } catch (IOException e) {
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