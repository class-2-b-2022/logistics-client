package Views;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Login {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";

    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void startClient() throws UnknownHostException, IOException{
        socket = new Socket("192.168.1.235", 5450   );
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        String email;
        String password;
        Scanner scanner=new Scanner(System.in);
        System.out.println(ANSI_BLUE);
        System.out.println("\t\t\t\t\t\t Welcome to Logdel");
        System.out.println(ANSI_RESET);
        System.out.print("\t\t\tEmail:");
        email=scanner.nextLine();
        System.out.print("\t\t\tPassword:");
        password=scanner.nextLine();
        Utils.RequestBody clientRequest = new Utils.RequestBody();
//        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String response = read.readLine();
//        System.out.println("Response: " + response);
    }
    public static void main(String args[]){
        Login client = new Login();
        try {
            client.startClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}