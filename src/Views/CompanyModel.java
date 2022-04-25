package views;

import utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * @author Teta Butera Nelly
 * */

public class CompanyModel {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";
    static String leftAlignFormat = "| %-11s | %-4d |%n";
    static ClientRequest request;
    static Scanner scanner = new Scanner(System.in);
    static ConnectToServer connect = new ConnectToServer();

    public static void main (String[]args) throws Exception {


        Company();
        CompanyManagement();
    }

    public static void Company(){
        System.out.println(ANSI_CYAN+ "\t\t\t\t                         "+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                                      ___________________       "+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                                     |                   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                                     |   +   +   +   +   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                                     |   +   +   +   +   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                                     |   +   +   +   +   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t     _______________                 |   +   +   +   +   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |               |                |   +   +   +   +   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |               |                |                   | "+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |    +     +    |                |                   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |  +         +  |                |                   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |       +       |                |                   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |           ____|________________|____               |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |         *        WELCOME  TO         *             |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |         | COMPANY MANAGEMENT MODULE  |             |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |          _____________________________             |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |     ___       |                |   _____________   |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |    |   |      |                |  |_|_|_|_|_|_|_|  |"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t    |____|___|______|________________|___________________|"+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                                                            "+ANSI_RESET);
    }

    public static void createCompany() throws Exception {
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/company");
        clientRequest.setAction("INSERT");
        Company company = new Company();

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


        company.setTIN(TIN);
        company.setName(name);
        company.setEmail(email);
        company.setType(type);
        company.setPhone(phone);
        company.setDescription(description);

        ObjectMapper objectMapper = new ObjectMapper();
        clientRequest.setData(company);
        ResponseBody responseBody = connect.connectToServer(clientRequest);
        System.out.println("our server response " + responseBody.getMessage());

    }

    public static void viewCompanies() throws Exception{
        ObjectMapper inputMapper = new ObjectMapper();
        RequestBody clientRequest = new RequestBody();
        clientRequest.setRoute("/company");
        clientRequest.setAction("GET");
        ConnectToServer clientServerConnector = new ConnectToServer();
        ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);

        List<Company> companies = Arrays.asList(inputMapper.readValue((byte[]) responseBody.getData(), Company[].class));
        System.out.println(ANSI_MAG +"\t\t\t\t List of all companies "+ANSI_RESET);
        System.out.format("+-----------------+---------------------+%n");
        System.out.format("| NIT    | Name    | Email       | Type  | Phone number | Description  |");
        System.out.format("+-----------------+------+%n");
        for ( Company company : companies) {
            String line = String.format("  %s   |   %s    |   %s   | %s  | %s   |   %s  ", company.getTIN(),company.getName(),company.getEmail(),company.getType(),company.getPhone(),company.getDescription());
            System.out.format(leftAlignFormat, line,2,3);
        }
        System.out.format("+-----------------+---------------------+%n");
    }

    public static void CompanyManagement() throws Exception {
        int companyManagementChoice;

        System.out.println(ANSI_MAG + "\t\t\t\t  --------    WHAT ARE YOU HERE FOR ?    -----" + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t                                       " + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t ________    1. Register new company _______" + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t                                       " + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t ________    2. View all companies   _______" + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t                                       " + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t ________    3. Edit company details    _______" + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t                                       " + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t ________    4. Delete a company   _______" + ANSI_RESET);
        System.out.println(ANSI_MAG + "\t\t\t\t                                       " + ANSI_RESET);

        System.out.println(ANSI_MAG + "\t Enter your choice:      " + ANSI_RESET);
        companyManagementChoice = scanner.nextInt();



        switch (companyManagementChoice) {
            case 1:
                createCompany();
                break;

            case 2:
                viewCompanies();
            default:
                System.out.println("Enter valid choice");
        }
    }

}
