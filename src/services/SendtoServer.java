package services;

import org.json.JSONObject;
import java.io.*;
import java.net.Socket;

public class SendToServer {
    private boolean isConnection = true;
    private JSONObject json;
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public SendToServer(JSONObject json, Socket socket) throws IOException{
        this.socket = socket;
        this.json = json;
    }

    public boolean send() throws IOException {
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
        try{
            writer.write(json+"\n");
            writer.flush();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
