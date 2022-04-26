package Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import formats.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConnectToServer {
    public ResponseBody res = new ResponseBody();
    public ResponseBody connectToServer(RequestBody clientRequest)throws Exception
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 9050)) {

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // sending the user input to server
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientRequest);
          
            List<String> dt = new ArrayList<>();
            dt.add(json);
            out.writeObject(dt);
            System.out.println("Data sent, getting returned data");
            

            String jsonReturned =  in.readUTF();
            System.out.println("Response got");
            ObjectMapper inputMapper = new ObjectMapper();
            JsonNode jsonNodeRoot = inputMapper.readTree(jsonReturned);
            res.setStatus(jsonNodeRoot.get("status").asText());
            res.setMessage(jsonNodeRoot.get("message").asText());
            res.setData(jsonReturned.split("data\":")[1].split(",\"message\"")[0]);
            System.out.println("Message"+ res.getMessage());
            return res;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}