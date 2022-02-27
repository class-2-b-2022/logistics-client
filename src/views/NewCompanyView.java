package views;

import data_format.NewCompanyFormat;
import services.CompanyService;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NewCompanyView {
    private Socket socket;
    public NewCompanyView(){}
    public NewCompanyView(Socket socket){
        this.socket = socket;
    }
    public void view() throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("\t\t\t------------------HOME >> NEW-CUSTOMER---------------------");
            System.out.println("\n       00. Return ");
            System.out.println("        Enter  Company Name");
            String companyName = scan.nextLine();

            if (companyName.equals("00"))
                break;


            System.out.println("        Enter  Company Email");
            String companyEmail = scan.nextLine();
            if (companyEmail.equals("00"))
                break;


            System.out.println("        Enter  Company Phone");
            String companyPhone = scan.nextLine();
            if (companyPhone.equals("00"))
                break;

            System.out.println("        Enter  Company Type");
            String companyType = scan.nextLine();
            if (companyType.equals("00"))
                break;

            System.out.println("        Enter  Company Description");
            String companyDescription = scan.nextLine();
            if (companyDescription.equals("00"))
                break;


            NewCompanyFormat format = new NewCompanyFormat(companyName, companyEmail, companyPhone, companyType, companyDescription);

            CompanyService companyService = new CompanyService(this.socket);
            companyService.create(format);
        }while(true);
    }
}
