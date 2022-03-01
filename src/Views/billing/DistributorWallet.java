package Views.billing;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.net.Socket;


//save money, make transactions!!
public class DistributorWallet {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static void Wallet(){


        int choice;
        String choiceText="";

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
            Socket socket = new Socket("localhost", 2334);
            OutputStream outToServer = socket.getOutputStream();
            DataOutputStream requestToServer = new DataOutputStream(outToServer);



            System.out.println("\n\n");
            System.out.println("                            WHAT DO YOU WANT TO DO WITH YOUR WALLET?                          ");
            System.out.println("                    (1) Get my Balance                    ");
            System.out.println("                    (2) Save to my Wallet                 ");
            System.out.println("                    (3) Withdraw from my Wallet           ");
            System.out.println(" Enter your choice: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    choiceText = "Get my Balance";
                    break;
                case 2:
                    choiceText = "Save to my Wallet";
                    break;
                case 3:
                    choiceText = "Withdraw from my Wallet";
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

            requestToServer.writeUTF(choiceText);

            InputStream inFromServer = socket.getInputStream();
            DataInputStream response = new DataInputStream(inFromServer);

            System.out.println(response.readUTF());

        }catch(Exception e){
//            e.printStackTrace()
        }
        }

    public static void main(String[] args){
        Wallet();
    }
}
