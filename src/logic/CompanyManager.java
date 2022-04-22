package logic;

import Utils.ConnectToServer;
import Views.CompanyModel;
import formats.Company;
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

        Company company = new Company();
        company.setTIN(TIN);
        company.setName(name);
        company.setEmail(email);
        company.setType(type);
        company.setPhone(phone);
        company.setDescription(description);

        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/company");
        clientRequest.setAction("INSERT");
        clientRequest.setData(company);
        ConnectToServer clientServerConnector = new ConnectToServer();

        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
        if(responseBody.getStatus() == "201"){
            responseBody.getMessage();
            CompanyModel company1 = new CompanyModel();
            company1.CompanyManagement();
        }else{
            System.out.println("An error occurred behind your screen");
        }
    }

//    public List<Company> viewCompanies() throws Exception{
//        ObjectMapper inputMapper = new ObjectMapper();
//        RequestBody clientRequest = new RequestBody();
//        clientRequest.setRoute("/company");
//        clientRequest.setAction("view");
//        ConnectToServer clientServerConnector = new ConnectToServer();
//        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
//        System.out.println(responseBody.getData());
//        List<Company> companies = Arrays.asList(inputMapper.readValue((byte[]) responseBody.getData(), Company[].class));
//        return companies;
//    }


}
