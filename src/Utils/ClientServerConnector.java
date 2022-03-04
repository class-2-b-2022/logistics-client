
package  Utils;
import models.ClientRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClientServerConnector {
    public static Utils.ResponseBody serverClientConnnector(String json)throws Exception
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
            List<Object> dataReturned = (List<Object>) responseStream.readObject();


            Utils.ResponseBody responseBody = new Utils.ResponseBody(dataReturned);

            return responseBody;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}