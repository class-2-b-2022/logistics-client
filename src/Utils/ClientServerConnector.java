
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
    public ResponseBody serverClientConnnector(String json)throws Exception
    {
        // establish a connection by providing host and port
        ResponseBody res = new ResponseBody();
        // number
        try (Socket socket = new Socket("localhost", 5450)) {

            // writing to server
            ObjectOutputStream requestStream = new ObjectOutputStream(socket.getOutputStream());
            List<String> dataTosend = new ArrayList<>();
            dataTosend.add(json);
            // sending request
            requestStream.writeObject(dataTosend);



            // getting response
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String jsonReturned =  in.readUTF();
            ObjectMapper inputMapper = new ObjectMapper();
            // // jsonNodeRoot = inputMapper.readTree(jsonReturned);
            // res.setMessage(jsonNodeRoot.get("status").asText());
            // res.setData(jsonReturned.split("data\":")[1].split(",\"message\"")[0]);
            // res.setStatus((jsonNodeRoot.get("message").asText()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }
}