package Views.company;

import utils.Colors;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CompanyMainView {
    private Socket socket;
    public CompanyMainView() {}

    public CompanyMainView(Socket socket) throws Exception{
        this.socket = socket;
    }

    public void view() throws IOException, ClassNotFoundException {
        boolean companyView = false;
        do{
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t1. Register New Company");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t2. View A Company's Information");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t3. View All Companies");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t4. Update Company Information");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t00. Back");
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter your choice"+ Colors.ANSI_YELLOW+" <1-00>"+Colors.ANSI_RESET+": ");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            String number = "1";

            switch (input){
                case "1":
                    System.out.println("Enter your role to verify if you have the rights to register a company");
                    String role = scan.nextLine();
                    if(!role.equals("System Admin")){
                        System.out.println("You are not allowed to register a company, ask the System Admin to do that task");
//                        companyView = false;
                        break;
                    }
                    NewCompanyView newCompanyView = new NewCompanyView(this.socket);
                    newCompanyView.view();
                    companyView = false;
                    break;
                case "2":
                    views.company.ReadCompanyView readCompanyView = new views.company.ReadCompanyView(this.socket);
                    readCompanyView.view();
                    break;
                case "3":
                case "4":
                    System.out.println("Sub-module not available, Sorry for any inconviniences");
                    break;
                case "00":
                    companyView = false;
                    break;
                default:
                    System.out.println(Colors.ANSI_RED+"\t\t\t\t\t\t\t\t\t\t\t\t\t\tINVALID CHOICE"+Colors.ANSI_RESET);
            }

        }while(companyView);
    }

}
