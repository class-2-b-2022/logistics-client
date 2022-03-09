//package views;
//
//import utils.Colors;
//import views.company.CompanyMainView;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//public class Home {
//    private Socket socket;
//    boolean homeView = true;
//    public Home(Socket socket) {this.socket = socket;}
//    public void view() throws Exception {
//        int option;
//        do {
//            CompanyMainView companyMainView = new CompanyMainView(socket);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("---------------------------------------------------------");
//            System.out.println("---------------------LOGISTICS HOME-----------------------");
//            System.out.println("                   1. COMPANY MANAGEMENT");
//            System.out.println("                   00. EXIT");
//            option = Integer.parseInt(reader.readLine());
//            switch (option) {
//                case 1:
//                    companyMainView.view();
//                    break;
//                case 00:
////                    homeView = false;
//                    socket.close();
//                    break;
//                default:
//                    System.out.println(Colors.ANSI_RED + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tINVALID CHOICE" + Colors.ANSI_RESET);
//
//            }
//        }while(homeView);
//    }
//}
