package services;

import org.json.JSONObject;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class SendtoServer {
    private OutputStream output = null;
    private ObjectOutputStream objectOutput = null;
    private boolean isConnection = true;
    private JSONObject json;
    private Socket socket;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public SendtoServer(JSONObject json, Socket socket) throws IOException{
        this.socket = socket;
        this.json = json;
    }


    public boolean send() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        try{
            writer.write(json + "\n");
            writer.flush();
            System.out.println("sending to from server \n" + json);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
