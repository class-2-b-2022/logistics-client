package View;
import View.Colors;
import java.awt.desktop.UserSessionEvent;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Login {
    private Socket socket;
    public Login(){};
    public Login(Socket socket) throws Exception {
        this.socket = socket;
//        UserSessionEvent userSession=new UserSession():
//        if(userSession.isLoggedin()){
//   String json=userSession.getUserJsonObject();
        //ObjectMapper objectMapper=new ObjectMapper();
        //JsonNode jsonNode=ObjectMapper.readTree(json);
        //route(jsonNode.get("appUser").asText());
//    }else{
        //openLogin=true;
        //this.view();
    //}
    }
    private boolean openLogin=false;
    public void view() throws Exception{
        authorize:do{
        String email;
        String password;
        Scanner scanner=new Scanner(System.in);
        System.out.println(Colors.ANSI_BLUE);
            System.out.println("\t\t\t\t\t\t Welcome to Logdel");
            System.out.println(Colors.ANSI_RESET);
//            System.out.println("\t\t\t\t\t\tLogin\n");
            System.out.println("\t\t\tEmail:");
            email=scanner.nextLine();
            if(email.equals("00")){
                break authorize;
            }
            System.out.println("\t\t\tPassword:");
            password=scanner.nextLine();
            if(password.equals("00")){
                break authorize;
            }
            Data_format DataFormat=new Data_format(email,password);
//           AuthService authService=new AuthService(this.socket,authenticationDataFormat);
//            if(authService.authenticate()){
//                route(authService.getLoggedInUser)
//            }else{}
            System.out.println(Colors.ANSI_RED+"\t\t\tInvalid credentials\t\t\t"+Colors.ANSI_RESET);

        }
        while (openLogin);
    }
    public static void main(String[] args) throws Exception {
        Login login =new Login();
        login.view();
        Properties properties = new Properties();
//        properties.setProperty("Token", "bruce");
//        properties.setProperty("UserId", "0");
        System.out.println(properties.getProperty("Token"));
    }
}
