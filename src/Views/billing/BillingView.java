package views.billing;
import formats.Wallet;
import logic.BillingManager;
import logic.TestingServerConnecting;


import java.util.Scanner;


//save money, make transactions!!
public class BillingView {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";

    public BillingView() {};
    public static void mainMethod(){
        System.out.println("\n\n");
        System.out.println("________________________________________"+ANSI_CYAN+"DISTRIBUTOR'S WALLET"+ANSI_RESET+"___________________________________________\n");

        System.out.print(ANSI_GREEN+"                                     ||"+ANSI_RESET );
        System.out.print(ANSI_GREEN+"                                     ||"+ANSI_RESET );
        System.out.println("");
        System.out.print("                                 ~  ~"+ANSI_GREEN +"||"+ANSI_RESET+"  ~");
        System.out.print("                              ~  ~"+ANSI_GREEN +"||"+ANSI_RESET+"  ~");
        System.out.println("");
        System.out.print("                                ~               ");
        System.out.print("                       ~               ");
        System.out.println("");
        System.out.print("                                 ~  ~"+ANSI_GREEN +"||"+ANSI_RESET +  "~");
        System.out.print("                                ~  ~"+ANSI_GREEN +"||"+ANSI_RESET +  "~");
        System.out.println("");
        System.out.print("                                         ~");
        System.out.print("                                       ~");
        System.out.println("");
        System.out.print("                                ~  ~"+ANSI_GREEN +" ||"+ANSI_RESET +"  ~");
        System.out.print("                             ~  ~"+ANSI_GREEN +" ||"+ANSI_RESET +"  ~");
        System.out.println("");
        System.out.print("                                     "+ANSI_GREEN +"||"+ANSI_RESET );
        System.out.print("                                     "+ANSI_GREEN +"||"+ANSI_RESET );


        try {
            TestingServerConnecting test = new TestingServerConnecting();
            while(true){
            int choice;
            int userId;
            float amount;
            System.out.println("\n\n");
            System.out.println("                            WHAT DO YOU WANT TO DO WITH YOUR WALLET?                          ");
            System.out.println("                    (1) Create Wallet                    ");
            System.out.println("                    (2) Get Wallet Details                    ");
            System.out.println("                    (3) Save to my Wallet                 ");
            System.out.println("                    (4) Withdraw from my Wallet           ");
            System.out.println("                    (5) Back to dashboard           ");
            System.out.println(" Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            BillingManager billingManager = new BillingManager();
            Wallet wallet = new Wallet();

            switch (choice) {
                case 1:
                    System.out.println("Enter your user id to create a wallet: ");
                    userId = scanner.nextInt();
                    billingManager.createWallet(userId, "CreateWallet");
                    break;
                case 2:
//                    test.connect(0,0);
                    break;
                case 3:
                    System.out.println("Enter your user id: ");
                    userId = scanner.nextInt();
                    System.out.println("Enter amount you want to save: ");
                    amount = scanner.nextFloat();
                    wallet.setUserId(userId);
                    wallet.setAmount(amount);
                    test.connect(wallet);
                    break;
                case 4:
//
                        System.out.println("Enter your user id: ");
                        userId= scanner.nextInt();
                        System.out.println("Enter amount you want to withdraw: ");
                        amount = scanner.nextFloat();
                        wallet.setUserId(userId);
                        wallet.setAmount(amount);
                        test.connect(wallet);

                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                }

            }
        }catch(Exception e){
//            e.printStackTrace()
        }
        }

}
