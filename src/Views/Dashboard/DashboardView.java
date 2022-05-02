package views.Dashboard;

import formats.User;
import logic.VehicleManager;
import Utils.CheckLoggedInStatus;
import views.DeliveryModel;
import views.Inventory.Inventory;
import views.billing.BillingView;

import java.io.IOException;
import java.util.Scanner;
/* Author: Niyigena Yves*/
public class DashboardView {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final Scanner scanner = new Scanner(System.in);
    public static VehicleManager vh = new VehicleManager();
    public static DeliveryModel delivery  = new DeliveryModel();
    public static void getCurrentUser() throws Exception {
        if(CheckLoggedInStatus.isLoggedIn()){
            User user = CheckLoggedInStatus.getLoggedInUser();
            System.out.println(ANSI_MAG +"\t\t\t\t Names: "+user.getNames()+ANSI_RESET);
        }
    }
    public static void mainMethod() throws Exception {
        getCurrentUser();
        System.out.println("\n");
        System.out.println(ANSI_BLUE +"\t\t\t\t================================= DASHBOARD ============================="+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t\t-------------"+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 1. Wallet "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 2. Inventory "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 3. Orders "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 4. Invoices "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 5. Receipts "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 6. Transport System "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t||\t 7. Reports "+ANSI_RESET);
        System.out.println("\t\t\t\t"+ANSI_BLUE+"||"+ANSI_RED +"\t 8. Logout"+ANSI_RESET);
        System.out.println("Choose from (1 - 8): ");

        int choice = scanner.nextInt();
        switch (choice){

            case 1:
                BillingView.mainMethod();
                break;
            case 2:
                Inventory.Inventory();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                DeliveryModel.mainMethod();
                break;
            case 7:
                break;
            case 8:
                CheckLoggedInStatus.logout();
                break;
            default:
                mainMethod();
        }

    }

}
