package services;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SendtoServer {
    private OutputStream output = null;
    private ObjectOutputStream objectOutput = null;
    private boolean isConnection = true;
    InputStream input;
    ObjectInputStream objectInputStream;
    private String json;
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public SendtoServer(String json, Socket socket) throws IOException{
        this.socket = socket;
        this.json = json;
    }

    public boolean send() throws IOException {
        try{
            List<String> dataToSend = new ArrayList();
            dataToSend.add(this.json);
            this.output = this.socket.getOutputStream();
            this.objectOutput = new ObjectOutputStream(this.output);
            this.objectOutput.writeObject(dataToSend);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
