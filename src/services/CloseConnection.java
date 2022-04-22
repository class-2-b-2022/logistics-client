package services;

import java.io.IOException;
import java.net.Socket;

public class CloseConnection {
    private Socket socket;
    public void closeConnection( Socket socket) throws IOException {
        socket.close();
        System.out.println("Exited successfully..................");
    }
}
