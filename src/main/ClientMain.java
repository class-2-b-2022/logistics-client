package main;

import Views.DeliveryModel;

public class ClientMain {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void welcomeScreen(){
        /**
         * @author: Niyigena Yves
         */
        System.out.println("\n");

        System.out.println(ANSI_BLUE +"\t\t __                __    __________    __             _________       _______       ___           ___   _________    "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |              |  |  |          |  |  |           /          |   /   ___   \\    |   \\        /   |  |         | "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |      __      |  |  |  |-------   |  |          |   --------   |   /   \\   |   |    \\      /    |  |  |------  "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |     /  \\     |  |  |  |          |  |          |  |           |  |     |  |   |     \\    /     |  |  |        "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |    /    \\    |  |  |  |          |  |          |  |           |  |     |  |   |  |\\  \\  /  /|  |  |  |       "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |   /  /\\  \\   |  |  |  |____      |  |          |  |           |  |     |  |   |  | \\  \\/  / |  |  |  |____  "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |  /  /  \\  \\  |  |  |       |     |  |          |  |           |  |     |  |   |  |  \\    /  |  |  |       |  "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  | /  /    \\  \\ |  |  |  |----      |  |          |  |           |  |     |  |   |  |   \\__/   |  |  |  |----   "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  |/  /      \\  \\|  |  |  |          |  |          |  |           |  |     |  |   |  |          |  |  |  |        "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|  /  /        \\  \\  |  |  |          |  |          |  |           |  |     |  |   |  |          |  |  |  |        "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|    /          \\    |  |   _______   |   ______    |  \\_______    |   \\___/   |   |  |          |  |  |   _____  "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t|   /            \\   |  |          |  |          |   \\          |   \\         /    |  |          |  |  |         |"+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t ---              ---    ----------    ----------      ---------      -------       --            --    ---------    "+ANSI_RESET);

        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t          _______   ______                 "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t         |__   __| |  __  |                "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t            | |    | |  | |                "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t            | |    | |  | |                "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t            | |    | |__| |                "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t\t\t\t             -      ------                 "+ANSI_RESET);

        System.out.println(ANSI_BLUE +"\t\t\t\t __              ______         ________     ________       ________    __           "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |           /         \\    /          |  |         \\    |        |  |  |        "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  / --- \\  |  |  / ------    |   ----\\  \\   |  ------   |  |       "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  |     |  |  |  |           |  |     \\  |  |  |        |  |         "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  |     |  |  |  |           |  |     |  |  |  |        |  |          "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  |     |  |  |  |    __     |  |     |  |  |  | ___    |  |          "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  |     |  |  |  |   |__ \\   |  |     |  |  |       |   |  |         "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  |     |  |  |  |     \\  |  |  |     |  |  |  -----    |  |         "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|  |          |  |     |  |  |  |     |  |  |  |     /  |  |  |        |  |          "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|   ______    |   \\___ /  |  |  \\___  /  |  |   ____/  /   |  |______  |   ______  "+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t|          |   \\         /    \\         /   |         /    |         | |          |"+ANSI_RESET);
        System.out.println(ANSI_BLUE +"\t\t\t\t __________      ------         ------       --------       ---------   __________   "+ANSI_RESET);

        System.out.println("\n");
        System.out.println("\t\t\t\t ---------------------- OFFERING EXCELLENT LOGISTIC SERVICES --------------------");

    }
    public static void main(String[] args) throws Exception {
        DeliveryModel delivery = new DeliveryModel();
        delivery.Delivery();
        delivery.Start();
        welcomeScreen();





    }
}

