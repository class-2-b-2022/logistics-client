
package  utils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;


public class ConnectToServer {
    public ResponseBody ConnectToServer(RequestBody requestBody)throws Exception
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 1294)) {

            // writing to server
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            // reading from server
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            String line = null;


            // sending the user input to server
            out.writeObject(requestBody);
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