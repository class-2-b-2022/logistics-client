package views;

import formats.ReportModel;
import formats.Vehicle;
import logic.ReportManager;
import views.Dashboard.DashboardView;

import java.util.List;
import java.util.Scanner;

public class ReportView {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void Reports(){
        System.out.println(ANSI_CYAN +"\t\t\t\t                                                                   "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         -----    WELCOME TO REPORTS MODULE      -----             "+ANSI_RESET);
    }

    public static void ReportManagement() throws Exception{
        String leftAlignFormat = "| %-11s | %-4d |%n";
        int reportManagementChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    SELECT OPTION TO VIEW REPORTS    -----"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Inventory Reports _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    2. Company Reports    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t Enter your choice:      "+ANSI_RESET);

        reportManagementChoice = scanner.nextInt();
        ReportManager reportManager = new ReportManager();

        switch (reportManagementChoice){
            case 1:
                System.out.println(ANSI_MAG +"\t\t\t\t List of all vehicles "+ANSI_RESET);
                List<ReportModel> reportModels = reportManager.viewReports();
                System.out.format("+-----------------+---------------------+%n");
                System.out.format("| #Date    | Product   | Status       | Quantity  | Company Name |");
                System.out.format("+-----------------+------+%n");
                for ( ReportModel reportModel: reportModels) {
                    String line = String.format("  %s   |   %d    |   %s   | %d  | %s   ",reportModel.getDate(),reportModel.getProduct(),reportModel.getStatus(),reportModel.getQuantity(),reportModel.getCompanyName());
                    System.out.format(leftAlignFormat, line,2,3);
                }
                System.out.format("+-----------------+---------------------+%n");
                break;
        }
    }
    public static void Start() throws Exception{
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    Select an Option    -----"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Reports Management _______"+ANSI_RESET);
       System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    3. Back to Dashboard   _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\tEnter your choice:      "+ANSI_RESET);
        choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println(ANSI_MAG +"\t\t\t\t -----------  REPORT MANAGEMENT SYSTEM ---------------"+ANSI_RESET);
                System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
                System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);

                ReportManagement();
                break;
            case 3:
                DashboardView.mainMethod();
            default:
                DashboardView.mainMethod();
                System.out.println(ANSI_MAG +"\t\t\t\t No option seleted "+ANSI_RESET);
        }
    }
    public static void mainMethod() throws Exception{
        Reports();
        Start();
    }
}
