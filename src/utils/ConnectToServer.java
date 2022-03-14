package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.Socket;

public class ConnectToServer {
    public utils.ResponseBody res = new ResponseBody();
    public utils.ResponseBody connectToServer(RequestBody clientRequest)throws Exception
    {

        try (Socket socket = new Socket("192.168.1.66", 5450)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // sending the user input to server
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientRequest);
            out.writeObject(json);
            String jsonReturned =  in.readUTF();



            ObjectMapper inputMapper = new ObjectMapper();
            JsonNode jsonNodeRoot = inputMapper.readTree(jsonReturned);
            res.setMessage(jsonNodeRoot.get("status").asText());
            res.setData(jsonReturned.split("data\":")[1].split(",\"message\"")[0]);
            res.setStatus((jsonNodeRoot.get("message").asText()));
            return res;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}