
package  Utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientServerConnector {
    public static ResponseBody serverClientConnnector(String json)throws Exception
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 5450)) {

            // writing to server
            ObjectOutputStream requestStream = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            ObjectInputStream responseStream = new ObjectInputStream(socket.getInputStream());
             List<String> dataTosend = new ArrayList<>();
             dataTosend.add(json);
            // sending request
            requestStream.writeObject(dataTosend);
            requestStream.flush();

            // getting response
//            List<Object> dataReturned = (List<Object>) responseStream.readObject();


            ResponseBody responseBody = new ResponseBody();

            return responseBody;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}