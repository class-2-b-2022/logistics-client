
package  Utils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ClientServerConnector {

    public static ResponseBody serverClientConnnector(String json)throws Exception
    {
        // establish a connection by providing host and port
        ResponseBody res = new ResponseBody();
        // number
        try (Socket socket = new Socket("192.168.1.34", 5450)) {

            // writing to server
            ObjectOutputStream requestStream = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
//            ObjectInputStream responseStream = new ObjectInputStream(socket.getInputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
             List<String> dataTosend = new ArrayList<>();
             dataTosend.add(json);
            // sending request
            requestStream.writeObject(dataTosend);
            requestStream.flush();

            // getting response
            String jsonReturned =  in.readUTF();
            System.out.println(jsonReturned);
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