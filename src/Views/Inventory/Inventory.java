package Views.Inventory;

import Utils.ClientServerConnector;
import Utils.ResponseBody;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ClientRequest;
import formats.InventoryModel;
import models.ProductModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET= "\u001B[0m";
    public static final String ANSI_MAG = "\u001b[1;35m";

    ObjectMapper objectMapper = new ObjectMapper();
    ClientRequest clientRequest = new ClientRequest();
    ResponseBody responseBody;
    String json = "";

    int branchId;
    InventoryModel inventoryModel = new InventoryModel();
    Scanner scanner = new Scanner(System.in);

    public void printWelcome(){
        System.out.println("\n");
        System.out.println("________________________________________"+ANSI_CYAN+"USER'S INVENTORY"+ANSI_RESET+"___________________________________________\n");
    }
    public List<Integer> viewProducts(int branchId){
        List<Integer> productIds = new ArrayList<Integer>();
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

                // insert the product id in the productIds array
                productIds.add(product.getProductId());
            }
            System.out.format("+-----------------+---------------------+%n");
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return productIds;
        }
    }
    public void viewInventory(){
        try {
            System.out.println("Enter your branch id to view Inventory: ");
            branchId= scanner.nextInt();

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
    public void createInventory(){
        try{
            InventoryModel inventoryModel = new InventoryModel();

            List<Integer> productIds;
            int productId;
            int status;
            int branchId;

            System.out.print("Enter your branch id to create Inventory: ");
            branchId = scanner.nextInt();

            System.out.print(" IN(0)/OUT?(1) ");
            status = scanner.nextInt();

            while(status != 0 && status != 1){
                System.out.println(ANSI_RED + "Please give a valid status of your inventory" + ANSI_RESET);
                System.out.print("status : ");
                status = scanner.nextInt();
            }

            if(status == 0){
                inventoryModel.setStatus("IN");
            }else{
                inventoryModel.setStatus("OUT");
            }

            productIds = this.viewProducts(branchId);
            System.out.println("which product? ");
            System.out.print("(Hint- Choose id from the listed products) : ");

            productId = scanner.nextInt();

            // Product Id validation
            while(!productIds.contains(productId)){
                System.out.println(ANSI_RED+ " Please give a valid productId " + ANSI_RESET);
                System.out.print("ProductId : ");
                productId = scanner.nextInt();
            }
            // End of product Id validation

            inventoryModel.setProductId(productId);

            System.out.println("How many products? ");
            inventoryModel.setQuantity(scanner.nextInt());

            // keep branch which registered the inventory
            inventoryModel.setBranchId(branchId);

            clientRequest.setRoute("/inventory");
            clientRequest.setAction("POST");
            clientRequest.setData(inventoryModel);
            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = new ClientServerConnector().serverClientConnnector(json);
            System.out.println(ANSI_GREEN + responseBody.getStatus() + ANSI_RESET);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateInventory(){
        try{
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteInventory(){
        try{
            System.out.println("Enter your inventory id to delete Inventory: ");
            int inventoryId = scanner.nextInt();
            ClientRequest clientRequest2 = new ClientRequest();
            clientRequest2.setRoute("/inventory");
            clientRequest2.setAction("DELETE");
            clientRequest2.setData(inventoryId);
            json = objectMapper.writeValueAsString(clientRequest2);
            responseBody = new ClientServerConnector().serverClientConnnector(json);
            System.out.println("Message: " + responseBody.getMessage() + " status: " +responseBody.getStatus() + " data: "+ responseBody.getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void checkProductQuantityInStock(int branchId, int productId, String name){
        List<Integer> data = new ArrayList<Integer>();
        data.add(branchId);
        data.add(productId);

        clientRequest.setRoute("/inventory");
        clientRequest.setAction("VIEW QUANTITY");
        clientRequest.setData(data);

        try{
            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = new ClientServerConnector().serverClientConnnector(json);
            System.out.println("There are " + responseBody.getData() + " of " + name + " in stock");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void Inventory() throws Exception {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;
        inventory.printWelcome();
        try {
            System.out.println("                    WHAT DO YOU WANT TO DO WITH YOUR INVENTORY?                          ");
            System.out.println("                    (1) Create Inventory                    ");
            System.out.println("                    (2) Get Inventory Details                    ");
            System.out.println("                    (3) Update my Inventory                 ");
            System.out.println("                    (4) Delete from my Inventory           ");
            System.out.println("                    (5) Check product Quantity in stock           ");
            System.out.print(" Enter your choice: ");
            choice = inventory.scanner.nextInt();
            switch (choice) {
                case 1:
                    inventory.createInventory();
                    break;
                case 2:
                    inventory.viewInventory();
                    break;
                case 3:
                    inventory.updateInventory();
                    break;
                case 4:
                    inventory.deleteInventory();
                    break;
                case 5:
                    System.out.print("Enter your branch id : ");
                    inventory.branchId = scanner.nextInt();


                    inventory.viewProducts(inventory.branchId);

                    int productId;
                    System.out.println("Which product? ");
                    productId = scanner.nextInt();

                    String productName;
                    System.out.println("product Name: ");
                    productName = scanner.next();

                    inventory.checkProductQuantityInStock(inventory.branchId, productId, productName);
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
