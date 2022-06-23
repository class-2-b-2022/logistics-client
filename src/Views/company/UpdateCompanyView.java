package views.company;

import formats.Company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Impano Alliance
 * */
public class UpdateCompanyView {
    private Socket socket;
    public UpdateCompanyView(){}
    public UpdateCompanyView(Socket socket){
        this.socket = socket;
    }
    public Company view() throws IOException, ClassNotFoundException {
//        JSONObject json = new JSONObject();
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Company company = new Company();
            System.out.println("\t\t\t------------------UPDATE_COMPANY_INFORMATION---------------------");
            try {
                System.out.println("        Enter New Company Name");
                String companyName = scan.next();
                System.out.println("        Enter New Company Email");
                String companyEmail = scan.next();
                System.out.println("        Enter New Company Phone");
                Integer companyPhone = scan.nextInt();
                System.out.println("        Enter New Company Type");
                String companyType = scan.next();
                while(!(companyType.equals("BRANCH")||companyType.equals("DISTRIBUTOR")||companyType.equals("MANUFACTURER")||companyType.equals("RESELLER"))){
                    System.out.print("Enter a valid type: BRANCH or DISTRIBUTOR or MANUFACTURER or RESELLER ");
                    companyType = scan.next();
                }
                System.out.println("        Enter New Company Description");
                String companyDescription = scan.next();
                company.setName(companyName);
                company.setEmail(companyEmail);
                company.setType(companyType);
                company.setPhone(companyPhone);
                company.setDescription(companyDescription);

            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        return company;
    }

}
