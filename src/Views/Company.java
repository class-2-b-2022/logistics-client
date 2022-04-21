package Views;

import formats.CompanyModel;
import logic.CompanyManager;

import java.util.List;
import java.util.Scanner;
/**
 * @author Teta Butera Nelly
 * */
public class Company {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";

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

    public static void CompanyManagement() throws Exception{
        String leftAlignFormat = "| %-11s | %-4d |%n";
        int companyManagementChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    WHAT ARE YOU HERE FOR ?    -----"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Register new company _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    2. View all companies   _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    3. Edit company details    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    4. Delete a company   _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t Enter your choice:      "+ANSI_RESET);
        companyManagementChoice = scanner.nextInt();
        CompanyManager companyManager = new CompanyManager();

        switch (companyManagementChoice){
            case 1:
                companyManager.registerCompany();
                System.out.println(ANSI_MAG + "\t\t\t\t Added registered new company" + ANSI_RESET);
                System.out.format("+----------------+--------+%n");
                    System.out.format("| TIN       | Name      | Email   | %n");
                System.out.format("+----------------+--------+%n");

                System.out.format("+----------------+--------+%n");
                for (int i = 0; i < 5; i++) {
                    System.out.format(leftAlignFormat, " 205962103   | NYIRANGARAMA  | COMPANY |  Healthy  |", i * 125);
                }
                System.out.format("+-----------------+------+%n");
                break;

            case 2:
                System.out.println(ANSI_MAG + "\t\t\t\t  List of all companies " + ANSI_RESET);
                List<CompanyModel> companies = companyManager.viewCompanies();
                System.out.println("+__________________+_______________+%n");
                System.out.format("| TIN      | Name      | Email    | Type    | Phone   | Description    |");
                System.out.println("+__________________+_______________+%n");

                for(CompanyModel company : companies){
                    String line = String.format("   %s  |   %s  |   %s  |   %s  |   %s  |   %s  ", company.getTIN(),company.getName(),company.getEmail(),company.getType(),company.getPhone(),company.getDescription());
                    System.out.format(leftAlignFormat, line,2,3);
                }
                System.out.println("+__________________+_______________+%n");
                break;
        }

    }
    public static void Start() throws Exception {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t      Let's Get Started (Choose option)          "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Company Management _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    2. Exit    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\tEnter your choice:      "+ANSI_RESET);
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println(ANSI_MAG +"\t\t\t\t ``````````  Company Management System ````````````"+ANSI_RESET);
                System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
                System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);

                CompanyManagement();
                break;
            case 2:
                System.out.println(ANSI_MAG +"\t\t\t\t -----------  exiting .. ---------------  "+ANSI_RESET);

            default:
                System.out.println(ANSI_MAG +"\t\t\t\t No option selected "+ANSI_RESET);
        }
    }

    public static void main(String[] args) throws Exception {
        Company();
        Start();
    }
}
