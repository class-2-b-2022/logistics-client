package services;

import Utils.RequestBody;
import Utils.ResponseBody;
import org.json.JSONObject;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class SendtoServer {
    private OutputStream output = null;
    private ObjectOutputStream objectOutput = null;
    private boolean isConnection = true;
    private JSONObject json;
    private RequestBody requestBody;
    private Socket socket;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public SendtoServer(RequestBody clientRequest, Socket socket) throws IOException{
        this.socket = socket;
        this.requestBody = clientRequest;
    }


    public boolean send() throws IOException {

        try{
            System.out.println(requestBody.getAction());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(requestBody);


//            System.out.println("sending to from server \n" + String.valueOf(requestBody));
        }catch(Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        return true;
    }
}
