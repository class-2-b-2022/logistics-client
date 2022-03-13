package Views.Inventory;

import Utils.ClientServerConnector;
import Utils.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ClientRequest;
import formats.InventoryModel;
import logic.TestingServerConnecting;

import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static void Inventory(){
        int choice;
        int branchId;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("________________________________________"+ANSI_CYAN+"USER'S INVENTORY"+ANSI_RESET+"___________________________________________\n");

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
            ClientRequest clientRequest = new ClientRequest();

            System.out.println("Enter your branch id : ");
            branchId = scanner.nextInt();
            int status;
            switch (choice) {
                case 1:
                    System.out.println("INStock(0)/OUTStock(1)? ");
                    status = scanner.nextInt();
                    if(status == 0){inventoryModel.setStatus("INStock");}
                    else{inventoryModel.setStatus("OutStock");}

                    System.out.println("which product? ");
                    System.out.print("(Hint: Choose id from given products) :: ");
                    inventoryModel.setProductId(scanner.nextInt());

                    System.out.println("How many products? ");
                    inventoryModel.setQuantity(scanner.nextInt());

                    // set branch the inventory belongs to
                    inventoryModel.setUserId(branchId);

                    clientRequest.setRoute("/inventory");
                    clientRequest.setAction("POST");
                    clientRequest.setData(inventoryModel);
                    json = objectMapper.writeValueAsString(clientRequest);
                    responseBody = new ClientServerConnector().serverClientConnnector(json);
                    System.out.println(responseBody.getStatus());
                    break;
                case 2:
                    clientRequest = new ClientRequest();
                    clientRequest.setRoute("/inventory");
                    clientRequest.setAction("GET");
                    clientRequest.setData(branchId);
                    json = objectMapper.writeValueAsString(clientRequest);
                    responseBody = new ClientServerConnector().serverClientConnnector(json);
//                    System.out.format("+-----------------+---------------------+%n");
//                    System.out.format("| #Id    | Quantity    | Status       | ProductId  | userId | Date  |");
//                    System.out.format("+-----------------+------+%n");
                    System.out.println(responseBody.getData());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Inventory();
    }
}
