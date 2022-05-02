package views.Inventory;

import formats.*;
import Utils.*;
import Utils.ClientServerConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.ClientRequest;
import formats.InventoryModel;
import logic.TestingServerConnecting;;
import formats.ProductModel;
import formats.ResponseBody;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
    RequestBody clientRequest = new RequestBody();
    ConnectToServer connectToServer = new ConnectToServer();
    ResponseBody responseBody;
    String json = "";

    int branchId;
    InventoryModel inventoryModel = new InventoryModel();
    Scanner scanner = new Scanner(System.in);

    public void printWelcome(){
        System.out.println("\n");
        System.out.println("________________________________________"+ANSI_CYAN+"USER'S INVENTORY"+ANSI_RESET+"___________________________________________\n");
    }
    public List<ProductModel> viewProducts(int branchId){
        List<ProductModel> products = new ArrayList<ProductModel>();
        try {
            clientRequest.setRoute("/products");
            clientRequest.setAction("GET");
            clientRequest.setData(branchId);
            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = new ClientServerConnector().serverClientConnnector(json);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String json = (String) responseBody.getData();
            products = Arrays.asList(objectMapper.readValue(json, ProductModel[].class));

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
        finally {
            return products;
        }
    }
    public void viewInventory(){
        try {
            System.out.println("Enter your branch id to view Inventory: ");
            branchId= scanner.nextInt();

            clientRequest.setRoute("/inventory");
            clientRequest.setAction("GET");
            clientRequest.setData(branchId);
//
//            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = connectToServer.connectToServer(clientRequest);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<InventoryModel> inventories = Arrays.asList(objectMapper.readValue((JsonParser) responseBody.getData(), InventoryModel[].class));

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

            List<ProductModel> products;
            List<Integer> productIds = new ArrayList<Integer>();
            int productId;
            int status;
            int branchId;
            int productQuantity;

            System.out.print("Enter your branch id to create Inventory: ");
            branchId = scanner.nextInt();

            System.out.print(" IN(0)/OUT?(1) ");
            status = scanner.nextInt();

            products = this.viewProducts(branchId);
            for (ProductModel product:products){
                productIds.add(product.getProductId());
            }
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

            while(status != 0 && status != 1){
                System.out.println(ANSI_RED + "Please give a valid status of your inventory" + ANSI_RESET);
                System.out.print("status : ");
                status = scanner.nextInt();
            }


            System.out.println("How many products? ");
            productQuantity = scanner.nextInt();

            if(status == 0){
                inventoryModel.setStatus("IN");
            }else{
                int res = checkProductQuantityInStock(branchId, productId);
                while(res < productQuantity){
                    System.out.println(ANSI_RED + " You don't have enough goods in stock. You only have " + res + " of that product" + ANSI_RESET);
                    System.out.println(ANSI_CYAN + "Please input the product Quantity again: " + ANSI_RESET);
                    productQuantity = scanner.nextInt();
                }

                inventoryModel.setQuantity(productQuantity);
                inventoryModel.setStatus("OUT");
            }

            // keep branch which registered the inventory
            inventoryModel.setBranchId(branchId);

            clientRequest.setRoute("/inventory");
            clientRequest.setAction("POST");
            clientRequest.setData(inventoryModel);
//            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = connectToServer.connectToServer(clientRequest);
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
//            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = connectToServer.connectToServer(clientRequest);
            System.out.println(responseBody.getStatus());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteInventory(){
        try{
            System.out.println("Enter your inventory id to delete Inventory: ");
            int inventoryId = scanner.nextInt();
            RequestBody clientRequest2 = new RequestBody();
            clientRequest2.setRoute("/inventory");
            clientRequest2.setAction("DELETE");
            clientRequest2.setData(inventoryId);
            json = objectMapper.writeValueAsString(clientRequest2);
            responseBody = connectToServer.connectToServer(clientRequest2);
            System.out.println("Message: " + responseBody.getMessage() + " status: " +responseBody.getStatus() + " data: "+ responseBody.getData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int checkProductQuantityInStock(int branchId, int productId){
        List<Integer> data = new ArrayList<Integer>();
        data.add(branchId);
        data.add(productId);

        clientRequest.setRoute("/inventory");
        clientRequest.setAction("VIEW QUANTITY");
        clientRequest.setData(data);
        int resultQuantity = 0;
        try{
            json = objectMapper.writeValueAsString(clientRequest);
            responseBody = connectToServer.connectToServer(clientRequest);

            String responseFromServer = (String) responseBody.getData();
            String[] number =  responseFromServer.split("\"");
            resultQuantity = Integer.valueOf(number[1]);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return resultQuantity;
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

                    int res = inventory.checkProductQuantityInStock(inventory.branchId, productId);
                    System.out.println("There are " + res + " " + productName + "(s) in stock");

                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
