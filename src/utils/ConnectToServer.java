package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.RequestBody;
import formats.ResponseBody;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/*import formats.*;*/
import java.io.*;
import java.net.Socket;
import formats.ResponseBody;
import formats.RequestBody;

public class ConnectToServer {
    public ResponseBody res = new ResponseBody();
    public ResponseBody connectToServer(RequestBody clientRequest)throws Exception
    {

        try (Socket socket = new Socket("localhost", 5450)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // sending the user input to server
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientRequest);

            List<String> dt = new ArrayList<>();
            dt.add(json);
            out.writeObject(dt);
            System.out.print("Sent to server");
            String jsonReturned =  in.readUTF();
            System.out.println(jsonReturned);
            System.out.println("a must to get response");
            System.out.println("Response got");
            ObjectMapper inputMapper = new ObjectMapper();
            JsonNode jsonNodeRoot = inputMapper.readTree(jsonReturned);
            res.setMessage(jsonNodeRoot.get("status").asText());
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