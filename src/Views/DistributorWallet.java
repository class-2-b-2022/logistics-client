package Views;
import java.util.Scanner;

//save money, make transactions!!
public class DistributorWallet {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static void Wallet(){
        int choice;
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
//        System.out.println("");


        System.out.println("\n\n");
        System.out.println("                            WHAT DO YOU WANT TO DO WITH YOUR WALLET?                          ");
        System.out.println("                    (1) Get my Balance                    ");
        System.out.println("                    (2) Save to my Wallet                 ");
        System.out.println("                    (3) Withdraw from my Wallet           ");
        System.out.println(" Enter your choice: ");
        choice = scanner.nextInt();

        switch(choice){
            case 1:
                System.out.println("Total Balance of the Company");
                //getBalance()
                break;
            case 2:
                System.out.println("You successfully saved to your wallet");
                //saveToWallet();
                break;
            case 3:
                System.out.println("You successfully withdrawn from your wallet");
                //withdrawFromWallet();
                break;
            default:
                System.out.println("Please enter a valid choice");
        }
    }

    public static void main(String[] args){
        Wallet();
    }
}
