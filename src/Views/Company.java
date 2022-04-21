package Views;

import java.util.Scanner;

public class Company {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void Company(){
        System.out.println(ANSI_CYAN+ "\t\t\t\t                         "+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                         "+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t     ------ WELCOME TO COMPANY MODEL -----      "+ANSI_RESET);
        System.out.println(ANSI_CYAN+ "\t\t\t\t                         "+ANSI_RESET);
    }

    public static void CompanyManagement() throws Exception{
        String leftAlignFormat = "| %-11s | %-4d |%n";
        int CompanyManagementChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    SELECT AN OPTION    -----"+ANSI_RESET);
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
        CompanyManagementChoice = scanner.nextInt();

    }

}
