
package Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ConnectToServer {
    public ResponseBody connectToServer(RequestBody clientRequest)throws Exception
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("192.168.1.93", 5450)) {

            // writing to server
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            String line = null;

            // sending the user input to server
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(clientRequest);
            System.out.println(json);
            out.writeObject(json);
            out.flush();

            // displaying server reply
            List<Object> dataReturned = (List<Object>) in.readObject();

            ResponseBody responseBody = new ResponseBody(dataReturned);

            return responseBody;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}