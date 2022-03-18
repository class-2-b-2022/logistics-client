package Views;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import Utils.*;
import formats.ClientRequest;
import formats.Data_format;
import formats.Users;

public class Login {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";

    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void deleteUser() throws Exception {
//        Scanner scanner=new Scanner(System.in);
//        System.out.print("User Email to delete: ");
//        String email;
//        email=scanner.nextLine();
        Data_format dataFormat=new Data_format();
        dataFormat.setEmail("email");
        dataFormat.setPassword("pass123");
        RequestBody requestBody=new RequestBody();
        requestBody.setAction("deleteuser");
        requestBody.setRoute("/user");
        requestBody.setData(dataFormat);
        ConnectToServer connectToServer=new ConnectToServer();
        ResponseBody responseBody=connectToServer.connectToServer(requestBody);
        System.out.println(responseBody.getMessage());
    }    public void updateUser() throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.print("update email: ");
        String email;
        email=scanner.nextLine();
        Users dataFormat=new Users();
        dataFormat.setEmail(email);
        dataFormat.setPassword("pass123");
        RequestBody requestBody=new RequestBody();
        requestBody.setAction("deleteuser");
        requestBody.setRoute("/user");
        requestBody.setData(dataFormat);
        ConnectToServer connectToServer=new ConnectToServer();
        ResponseBody responseBody=connectToServer.connectToServer(requestBody);
        System.out.println(responseBody.getMessage());
    }
    public void startClient() throws Exception {
//        socket = new Socket("192.168.1.235", 5450   );
//        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
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
        Data_format data=new Data_format();
        data.setEmail(email);

        data.setPassword(password);
        RequestBody requestBody = new RequestBody();
        requestBody.setAction("login");
        requestBody.setRoute("/users");
        requestBody.setData(data);
//        data.
        //yvesisite@gmail.com
        System.out.println("Data  " + " {" + " Email : " + '"' + data.email + '"' + ", "+ " Password " + data.password + "}");
        ConnectToServer connectToServer=new ConnectToServer();
        ResponseBody responseBody=connectToServer.connectToServer(requestBody);
        if(responseBody.getStatus() == "200") {
            System.out.println("Login successfully");
        }
        System.out.println("Status: " +responseBody.getStatus());
        System.out.println("Status: " +responseBody.getData());

//        }
//        else{
//            System.out.println("An error occurred behind your screen");
//        }
    }
    //yvesisite@gmail.com pass123
    public static void main(String args[]){
        Login client = new Login();
        try {
//            client.startClient();
            client.deleteUser();
//            for today tasks,is using some javascript allowed.
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}