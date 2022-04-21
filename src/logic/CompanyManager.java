package logic;

import Utils.ConnectToServer;
import Views.Company;
import formats.ClientRequest;
import formats.ClientRequest.*;
import formats.CompanyModel;
import formats.RequestBody;
import formats.ResponseBody;

import java.util.Scanner;
/**
 * @author Teta Butera Nelly
 * */

public class CompanyManager {
    public void registerCompany() throws Exception {
        /*
        required fields for company
         TIN
         name
         email
         type
         phone
         description
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter company TIN : ");
        Integer TIN = scanner.nextInt();
        System.out.println("Enter the name");
        String name = scanner.next();
        System.out.println("Enter the email");
        String email = scanner.next();
        System.out.println("Enter the type");
        String type = scanner.next();
        System.out.println("Enter the company phone number");
        Integer phone = scanner.nextInt();
        System.out.println("Enter the description");
        String description = scanner.next();

        CompanyModel company = new CompanyModel();
        company.setTIN(TIN);
        company.setName(name);
        company.setEmail(email);
        company.setType(type);
        company.setPhone(phone);
        company.setDescription(description);

        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/company");
        clientRequest.setAction("register");

        clientRequest.setData(company);
        ConnectToServer clientServerConnector = new ConnectToServer();

        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        if(responseBody.getStatus() == "201"){
            System.out.println("Vehicle registered successfully");
            Company company1 = new Company();
            company1.CompanyManagement();
        }else{
            System.out.println("An error occurred behind your screen");
        }
    }


}
