
package  utils;
import models.ClientRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;


public class ClientServerConnector {
    public static ResponseBody serverClientConnnector(ClientRequest clientRequest)throws Exception
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 5450)) {

            // writing to server
            ObjectOutputStream requestStream = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            ObjectInputStream responseStream = new ObjectInputStream(socket.getInputStream());

            // sending request
            requestStream.writeObject(clientRequest);
            requestStream.flush();

            // getting response
            List<Object> dataReturned = (List<Object>) responseStream.readObject();


            ResponseBody responseBody = new ResponseBody(dataReturned);

            return responseBody;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}