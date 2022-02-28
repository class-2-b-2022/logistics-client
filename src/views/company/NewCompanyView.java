package views.company;

import data_format.NewCompanyFormat;
import services.CompanyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewCompanyView {
    private Socket socket;
    public NewCompanyView(){}
    public NewCompanyView(Socket socket){
        this.socket = socket;
    }
    public void view() throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do{
            System.out.println("\t\t\t------------------NEW-CUSTOMER---------------------");
            System.out.println("\n       00. Enter To Exit ");
            System.out.println("        Enter  Company Owner Code");
            try {
                int companyOwner = Integer.parseInt(reader.readLine());

                if (companyOwner == 00)
                    break;
                System.out.println("        Enter  Company Name");
                String companyName = scan.next();

                if (companyName.equals("00"))
                    break;


                System.out.println("        Enter  Company Email");
                String companyEmail = scan.next();
                if (companyEmail.equals("00"))
                    break;


                System.out.println("        Enter  Company Phone");
                String companyPhone = scan.next();
                if (companyPhone.equals("00"))
                    break;

                System.out.println("        Enter  Company Type");
                String companyType = scan.next();
                if (companyType.equals("00"))
                    break;

                System.out.println("        Enter  Company Description");
                String companyDescription = scan.next();
                if (companyDescription.equals("00"))
                    break;
                NewCompanyFormat format = new NewCompanyFormat(companyOwner, companyName, companyEmail, companyPhone, companyType, companyDescription);
                System.out.println(format.toString());
                CompanyService companyService = new CompanyService(this.socket);
                companyService.create(format);
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }



        }while(true);
    }
}
