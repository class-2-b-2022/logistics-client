package views.company;

import data_format.NewCompanyFormat;
import org.json.JSONObject;
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
        JSONObject json = new JSONObject();
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
                json.put("companyName", companyName);
                if (companyName.equals("00"))
                    break;


                System.out.println("        Enter  Company Email");
                String companyEmail = scan.next();
                json.put("companyEmail", companyEmail);
                if (companyEmail.equals("00"))
                    break;


                System.out.println("        Enter  Company Phone");
                String companyPhone = scan.next();
                json.put("companyPhone", companyPhone);
                if (companyPhone.equals("00"))
                    break;

                System.out.println("        Enter  Company Type");
                String companyType = scan.next();
                json.put("companyType", companyType);
                if (companyType.equals("00"))
                    break;

                System.out.println("        Enter  Company Description");
                String companyDescription = scan.next();
                json.put("companyDescription", companyName);
                if (companyDescription.equals("00"))
                    break;
                System.out.println(json+" ");
                CompanyService companyService = new CompanyService(this.socket);
                companyService.create(json);
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }



        }while(true);
    }
}
