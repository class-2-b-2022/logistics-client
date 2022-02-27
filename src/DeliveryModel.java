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
    public static void Start(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t  --------    SELECT AN OPTION    -----"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    1. Vehicle Management _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t ________    2. Tracking    _______"+ANSI_RESET);
        System.out.println(ANSI_MAG +"\t\t\t\t                                       "+ANSI_RESET);
        System.out.println(ANSI_MAG +"\tEnter your choice:      "+ANSI_RESET);
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println(ANSI_MAG +"\t\t\t\t Vehicle management System "+ANSI_RESET);
               // VehicleManagement();
            break;
            case 2:
                System.out.println(ANSI_MAG +"\t\t\t\t Track your delivery  "+ANSI_RESET);
                // Tracking();
        }
    }
    public static void main(String[] args) {
        Delivery();
        Start();
    }
}
