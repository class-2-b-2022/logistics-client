package views;

import services.CloseConnection;
import utils.Colors;
import views.company.CompanyMainView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Home  {
    private Socket socket;
    boolean homeView = false;

    public Home(Socket socket) {this.socket = socket;}
    public void view() throws Exception {
        int option;
        CloseConnection closeConn = new CloseConnection();
        CompanyMainView companyMainView = new CompanyMainView(socket);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {

            System.out.println("---------------------------------------------------------");
            System.out.println("---------------------LOGISTICS HOME-----------------------");
            System.out.println("                   1. COMPANY MANAGEMENT");
            System.out.println("                   00. EXIT");
            option = Integer.parseInt(reader.readLine());
            if(option == 00){
                closeConn.closeConnection(socket);
                homeView = false;
            }
            switch (option) {
                case 1:
                    companyMainView.view();
                    break;
                case 00:
//                    homeView = false;
                    closeConn.closeConnection(socket);
                    homeView = false;
                    break;
                default:
                    System.out.println(Colors.ANSI_RED + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tINVALID CHOICE" + Colors.ANSI_RESET);

            }
        }while(!homeView);
    }
}
