package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
            List<String> req = new ArrayList<>();
            req.add(json);
            out.writeObject(req);
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