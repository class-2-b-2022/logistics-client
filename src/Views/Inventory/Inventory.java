package Views.Inventory;

import Utils.ClientServerConnector;
import Utils.ConnectToServer;
import Utils.RequestBody;
import Utils.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import formats.ClientRequest;
import formats.InventoryModel;
import formats.Vehicle;
import logic.TestingServerConnecting;
import main.views.inventory.Product;
import models.ProductModel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static final String ANSI_MAG = "\u001b[1;35m";

    ObjectMapper objectMapper = new ObjectMapper();
    ClientRequest clientRequest = new ClientRequest();
    String json = "";
    ResponseBody responseBody;

    public void viewProducts(int branchId){
        try {
            clientRequest.setRoute("/products");
            clientRequest.setAction("GET");
            clientRequest.setData(branchId);
            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = new ClientServerConnector().serverClientConnnector(json);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<ProductModel> products = Arrays.asList(objectMapper.readValue(responseBody.getData(), ProductModel[].class));
            // System.out.println(responseBody.getData());
            String leftAlignFormat = "| %-11s | %-4d |%n";
            System.out.println(ANSI_MAG + "\t\t\t\t List of all products " + ANSI_RESET);
            System.out.format("| #Id    | Product Name    | Product Type       | Company Id  | Price per Bulk |");
            System.out.format("+-----------------+------+%n");
            for ( ProductModel product : products) {

                String line = String.format("%s    |  %s             |  %s          | %s         | %s        ",product.getProductId(),product.getProductName(),product.getProductType(),product.getCompanyId(), product.getPricePerBulk());
                System.out.format(leftAlignFormat, line, 2, 3);
            }
            System.out.format("+-----------------+---------------------+%n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void viewInventory(int branchId){
        try {
            clientRequest.setRoute("/inventory");
            clientRequest.setAction("GET");
            clientRequest.setData(branchId);

            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = new ClientServerConnector().serverClientConnnector(json);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<InventoryModel> inventories = Arrays.asList(objectMapper.readValue(responseBody.getData(), InventoryModel[].class));

            String leftAlignFormat = "| %-11s | %-4d |%n";
            System.out.println(ANSI_MAG + "\t\t\t\t List of all branch inventory " + ANSI_RESET);
//            System.out.format("| #Id    | Quantity   | Status      | Product Id  | Date | Company Id |");
            System.out.format("| Quantity   | Status      | Product Id | branch Id |");
            System.out.format("+-----------------+------+%n");
            for ( InventoryModel inventory : inventories) {

                String line = String.format("  %s    |   %s   | %s  | %s   ",inventory.getQuantity(),inventory.getStatus(),inventory.getProductId(), inventory.getBranchId());
                System.out.format(leftAlignFormat, line, 2, 3);
            }
            System.out.format("+-----------------+---------------------+%n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void Inventory() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        ClientRequest clientRequest = new ClientRequest();
        String json = "";
        ResponseBody responseBody;

        int choice;
        int branchId;

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
            System.out.println("                    WHAT DO YOU WANT TO DO WITH YOUR INVENTORY?                          ");
            System.out.println("                    (1) Create Inventory                    ");
            System.out.println("                    (2) Get Inventory Details                    ");
            System.out.println("                    (3) Update my Inventory                 ");
            System.out.println("                    (4) Delete from my Inventory           ");
            System.out.print(" Enter your choice: ");
            choice = scanner.nextInt();
            InventoryModel inventoryModel = new InventoryModel();
            Inventory inventory = new Inventory();
            switch (choice) {
                case 1:
                    System.out.println("Enter your branch id to create Inventory: ");
                    branchId = scanner.nextInt();
                    inventory.viewProducts(branchId);
//                    System.out.println("IN/OUT? ");
                    inventoryModel.setStatus("IN");

                    System.out.println("which product? ");
                    System.out.print("(Hint: Choose id from given products) :: ");
                    inventoryModel.setProductId(scanner.nextInt());

                    System.out.println("How many products? ");
                    inventoryModel.setQuantity(scanner.nextInt());

                    // set user who registered inventory
                    inventoryModel.setBranchId(branchId);

                    clientRequest.setRoute("/inventory");
                    clientRequest.setAction("POST");
                    clientRequest.setData(inventoryModel);
                    json = objectMapper.writeValueAsString(clientRequest);
                    responseBody = new ClientServerConnector().serverClientConnnector(json);
                    System.out.println(responseBody.getStatus());
                    break;
                case 2:

                    System.out.println("Enter your branch id to view Inventory: ");
                    branchId= scanner.nextInt();
                    inventory.viewInventory(branchId);
                    break;
                case 3:
                    System.out.println("Enter your branch id to update Inventory: ");
                    branchId = scanner.nextInt();
                    clientRequest.setRoute("/inventory");
                    clientRequest.setAction("VIEW");
                    clientRequest.setData(branchId);
                    System.out.println("Here is the initial record and you need to update it.");
                    json = objectMapper.writeValueAsString(clientRequest);
                    responseBody = new ClientServerConnector().serverClientConnnector(json);
                    System.out.println(responseBody.getData());

                    System.out.println("Enter new quantity: ");
                    inventoryModel.setQuantity(scanner.nextInt());

                    clientRequest.setRoute("/inventory");
                    clientRequest.setAction("UPDATE");
                    clientRequest.setData(inventoryModel);
                    json = objectMapper.writeValueAsString(clientRequest);
                    responseBody = new ClientServerConnector().serverClientConnnector(json);
                    System.out.println(responseBody.getStatus());
                    break;
                case 4:
                    System.out.println("Enter your inventory id to delete Inventory: ");
                    int inventoryId = scanner.nextInt();
                    ClientRequest clientRequest2 = new ClientRequest();
                    clientRequest2.setRoute("/inventory");
                    clientRequest2.setAction("DELETE");
                    clientRequest2.setData(inventoryId);
                    json = objectMapper.writeValueAsString(clientRequest2);
                    responseBody = new ClientServerConnector().serverClientConnnector(json);
                    System.out.println("Message: " + responseBody.getMessage() + " status: " +responseBody.getStatus() + " data: "+ responseBody.getData());
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }catch(Exception e){
//            e.printStackTrace()
        }
    }
}
