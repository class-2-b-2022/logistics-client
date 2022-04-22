package Views.Inventory;

import formats.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.InventoryModel;
import Utils.ConnectToServer;

import java.util.Scanner;

public class Inventory {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static void Inventory(){


        int choice;
        int userId;


        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("________________________________________"+ANSI_CYAN+"USER'S INVENTORY"+ANSI_RESET+"___________________________________________\n");

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
            System.out.println("                            WHAT DO YOU WANT TO DO WITH YOUR INVENTORY?                          ");
            System.out.println("                    (1) Create Inventory                    ");
            System.out.println("                    (2) Get Inventory Details                    ");
            System.out.println("                    (3) Update my Inventory                 ");
            System.out.println("                    (4) Delete from my Inventory           ");
            System.out.println(" Enter your choice: ");
            choice = scanner.nextInt();
            ObjectMapper objectMapper = new ObjectMapper();
            String json;
            ResponseBody responseBody;
            InventoryModel inventoryModel = new InventoryModel();
            ConnectToServer connect = new ConnectToServer();
            switch (choice) {
                case 1:
                    System.out.println("Enter your user id to create Inventory: ");
                    userId = scanner.nextInt();


                    RequestBody clientRequest = new RequestBody();
                    clientRequest.setRoute("/products");
                    clientRequest.setAction("GET");
                    clientRequest.setData(userId);
                    responseBody = connect.connectToServer(clientRequest);
                    System.out.println(responseBody.getData());

//                    System.out.println("IN/OUT? ");
                    inventoryModel.setStatus("IN");

                    System.out.println("which product? ");
                    System.out.print("(Hint: Choose id from given products) :: ");
                    inventoryModel.setProductId(scanner.nextInt());

                    System.out.println("How many products? ");
                    inventoryModel.setQuantity(scanner.nextInt());

                    // set user who registered inventory
                    inventoryModel.setUserId(userId);

                    clientRequest.setRoute("/inventory");
                    clientRequest.setAction("POST");
                    clientRequest.setData(inventoryModel);
                    json = objectMapper.writeValueAsString(clientRequest);
                    responseBody = connect.connectToServer(clientRequest);
                    System.out.println(responseBody.getStatus());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }catch(Exception e){
//            e.printStackTrace()
        }
    }

    public static void main(String[] args){
        Inventory();
    }
}
