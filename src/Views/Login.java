package Views;
//import Views.Colors;
import java.awt.desktop.UserSessionEvent;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Login {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_BLACK="\u001B[30m";
    public static final String ANSI_RED="\u001B[31m";
    public static final String ANSI_GREEN="\u001B[32m";
    public static final String ANSI_YELLOW="\u001B[33m";
    public static final String ANSI_BLUE="\u001B[34m";
    public static final String ANSI_PURPLE="\u001B[35m";
    public static final String ANSI_CYAN="\u001B[36m";
    public static final String ANSI_WHITE="\u001B[37m";
    private Socket socket;
    public Login(){};
    public Login(Socket socket) throws Exception {
        this.socket = socket;

    }
    private boolean openLogin=false;
    public void view() throws Exception{
        authorize:do{
        String email;
        String password;
        Scanner scanner=new Scanner(System.in);
        System.out.println(ANSI_BLUE);
            System.out.println("\t\t\t\t\t\t Welcome to Logdel");
            System.out.println(ANSI_RESET);
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
         //   Data_format DataFormat=new Data_format(email,password);
//           AuthService authService=new AuthService(this.socket,authenticationDataFormat);
//            if(authService.authenticate()){
//                route(authService.getLoggedInUser)
//            }else{}
            System.out.println(ANSI_RED+"\t\t\tInvalid credentials\t\t\t"+ANSI_RESET);

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
