package Views.billing;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ClientRequest;
import formats.CreateWalletModel;
import logic.TestingServerConnecting;
import formats.*;
import utils.ClientServerConnector;

import java.util.Scanner;


//save money, make transactions!!
public class DistributorWalletView {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static void Wallet(){


        int choice;
        int userId;
        float amount;


        Scanner scanner = new Scanner(System.in);
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

            System.out.println("\n\n");
            System.out.println("                            WHAT DO YOU WANT TO DO WITH YOUR WALLET?                          ");
            System.out.println("                    (1) Create Wallet                    ");
            System.out.println("                    (2) Get Wallet Details                    ");
            System.out.println("                    (3) Save to my Wallet                 ");
            System.out.println("                    (4) Withdraw from my Wallet           ");
            System.out.println(" Enter your choice: ");
            choice = scanner.nextInt();

            TestingServerConnecting test = new TestingServerConnecting();

            switch (choice) {
                case 1:
                        System.out.println("Enter your user id to create a wallet: ");
                        userId = scanner.nextInt();

                    ClientRequest clientRequest = new ClientRequest();
                    clientRequest.setRoute("/billing");
                    clientRequest.setAction("CreateWallet");
                    CreateWalletModel newWallet = new CreateWalletModel(userId);
                    clientRequest.setData(newWallet);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String json = objectMapper.writeValueAsString(clientRequest);
                    ClientServerConnector.serverClientConnnector(json);
                case 2:
                    test.connect(0,0);
                    break;
                case 3:
                    System.out.println("Enter your user id: ");
                    userId = scanner.nextInt();
                    System.out.println("Enter amount you want to save: ");
                    amount = scanner.nextFloat();

                    test.connect(userId,amount);
                    break;
                case 4:
//
                    System.out.println("Enter your user id: ");
                    userId= scanner.nextInt();
                    System.out.println("Enter amount you want to withdraw: ");
                    amount = scanner.nextFloat();

                    test.connect(userId,amount);

                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }catch(Exception e){
//            e.printStackTrace()
        }
        }

    public static void main(String[] args){
        Wallet();
    }
}
