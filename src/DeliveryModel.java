package Views;
import java.util.Scanner;

public class DeliveryModel {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_MAG = "\u001b[1;35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void Delivery(){
        System.out.println(ANSI_CYAN +"\t\t\t\t                                                                   "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         -----    WELCOME TO DELIVERY MODEL      -----             "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t                                                                   "+ANSI_RESET);
        System.out.println(ANSI_CYAN+"\t\t\t\t            --------------------------------                        "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |                                  |_____________         "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |                                  | |~~~~~~~~~| |        "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |    ______   DELIVERY   ______    | |          | |       "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |                                  | |            | |     "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |                                  | | |           | |    "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |__________________________________| |______________|_|   "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |                                                     |   "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |       0 0 O                           0 0 0         |   "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t         |-----0       0---------------------- 0       0-------|   "+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t ________________0 0 0___________________________0 0 0_____________"+ANSI_RESET);
        System.out.println(ANSI_CYAN +"\t\t\t\t __________________________________________________________________"+ANSI_RESET);
    }
    public static void VehicleManagement(){
        String leftAlignFormat = "| %-11s | %-4d |%n";
        int VehicleManagementChoice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    SELECT AN OPTION    -----"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Add a vehicle _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    2. View all vehicles    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    3. Edit a vehicle    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    4. Delete a vehicle    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\tEnter your choice:      "+ANSI_RESET);
        VehicleManagementChoice = scanner.nextInt();
        switch (VehicleManagementChoice){
            case 1:
                System.out.println(ANSI_MAG +"\t\t\t\t Added new vehicle "+ANSI_RESET);
                // AddNewVehicle;
                System.out.format("+-----------------+------+%n");
                System.out.format("| Model       | Status  | Brand | Owner |Plate | %n");
                System.out.format("+-----------------+------+%n");
                for (int i = 0; i < 5; i++) {
                    System.out.format(leftAlignFormat, " AUDI A40   | AUDI  | COMPANY |  Healthy  |", i*125);
                }
                System.out.format("+-----------------+------+%n");
                break;
            case 2:
                System.out.println(ANSI_MAG +"\t\t\t\t List of all vehicles "+ANSI_RESET);
                // ViewVehicles();
                System.out.format("+-----------------+---------------------+%n");
                System.out.format("| Model       | Status  | Brand | Owner |Plate | %n");
                System.out.format("+-----------------+------+%n");
                for (int i = 0; i < 5; i++) {
                    System.out.format(leftAlignFormat, " AUDI A40   | AUDI  | COMPANY |  Healthy  |", i*115);
                }
                System.out.format("+-----------------+---------------------+%n");
                break;
            case 3:
                System.out.println(ANSI_MAG +"\t\t\t\t Edited successfully "+ANSI_RESET);
                // EditVehicle;
                System.out.format("+-----------------+------+%n");
                System.out.format("| Model       | Status  | Brand | Owner |Plate | %n");
                System.out.format("+-----------------+------+%n");
                for (int i = 0; i < 1; i++) {
                    System.out.format(leftAlignFormat, " AUDI A40   | AUDI  | COMPANY |  Healthy  |", i+1);
                }
                System.out.format("+-----------------+------+%n");
                break;
            case 4:
                System.out.println(ANSI_MAG +"\t\t\t\t Deleted successfully "+ANSI_RESET);
                //DeleteVehicle();
                System.out.format("+-----------------+------+%n");
                System.out.format("| Model       | Status  | Brand | Owner |Plate | %n");
                System.out.format("+-----------------+------+%n");
                for (int i = 0; i < 4; i++) {
                    System.out.format(leftAlignFormat, " AUDI A40   | AUDI  | COMPANY |  Healthy  |", i*125);
                }
                System.out.format("+-----------------+------+%n");
                break;
            default:
                System.out.println(ANSI_MAG +"\t\t\t\t No option seleted "+ANSI_RESET);
        }
    }
    public static void Start(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t              Let's Get Started           "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    Select an Option    -----"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Vehicle Management _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    2. Tracking    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\tEnter your choice:      "+ANSI_RESET);
        choice = scanner.nextInt();


        switch (choice){
            case 1:
                System.out.println(ANSI_MAG +"\t\t\t\t -----------  VEHICLE MANAGEMENT SYSTEM ---------------"+ANSI_RESET);
                System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
                System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
                VehicleManagement();
                break;
            case 2:
                System.out.println(ANSI_MAG +"\t\t\t\t -----------  TRACK YOUR PRODUCTS ---------------  "+ANSI_RESET);
                // Tracking();
            default:
                System.out.println(ANSI_MAG +"\t\t\t\t No option seleted "+ANSI_RESET);
        }
    }
    public static void main(String[] args) {
        Delivery();
        Start();
    }
}
