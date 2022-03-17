package Views.Dashboard;

import java.util.Scanner;
/* Author: Niyigena Yves*/
public class DashboardView {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
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

        int choice = scanner.nextInt();
        switch (choice){
            case 1:

        }

    }

}
