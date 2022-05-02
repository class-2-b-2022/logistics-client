package views;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import Utils.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.*;
import views.Dashboard.DashboardView;

public class Login {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";

    Socket socket;
    BufferedReader read;
    PrintWriter output;

    public void startClient() throws Exception {
//        socket = new Socket("192.168.1.235", 5450   );
//        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        JSONObject jsonHolder = new JSONObject();
        ParserObj parserObj = new ParserObj();
        ObjectMapper objectMapper = new ObjectMapper();
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
//        System.out.println("Data  " + " {" + " Email : " + '"' + data.email + '"' + ", "+ " Password " + data.password + "}");
        LoginHelper loginHelper=new LoginHelper();
        ResponseBody responseBody=loginHelper.login(requestBody);

        if(Integer.parseInt(responseBody.getStatus()) == 200) {
            Properties property = new Properties();
            FileWriter fwrite = new FileWriter("C:\\apps\\projects\\logisticsProject\\logistics-client\\config.properties");
            jsonHolder = new JSONObject(responseBody.getData().toString());
            String userId = jsonHolder.get("userId").toString();
            property.setProperty("userId", userId);
            property.store(fwrite, "loggedIn user");
            System.lineSeparator().repeat(100);
            DashboardView.mainMethod();

        }else if(Integer.parseInt(responseBody.getStatus()) == 400){
            System.out.println("user");
            System.out.println(responseBody.getMessage());
            startClient();
        }
//        }
//        else{
//            System.out.println("An error occurred behind your screen");
//        }
    }
    //yvesisite@gmail.com pass123
    public  void mainMethod(){
        Login client = new Login();
        try {
            client.startClient();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}