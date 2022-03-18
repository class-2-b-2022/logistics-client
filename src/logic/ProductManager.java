package logic;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import formats.ProductModel;

import utils.*;



public class ProductManager {
	ProductModel productModel=new ProductModel();
	//@Author INEZA Ange Michaella
	
 public void registerProduct() throws Exception {
	@SuppressWarnings("resource")
	Scanner sc= new Scanner(System.in);
	  
    System.out.println("-----------------Register product-----------------");
    System.out.println("Product Name? ");
      productModel.setProductName(sc.nextLine());
      System.out.println("Product Type? ");
      productModel.setProductType(sc.nextLine());
      System.out.println("Price per Bulk? ");
      productModel.setPricePerBulk(sc.nextInt());
      System.out.println("Company Id? ");
    productModel.setCompanyId(sc.nextInt());
     

    
 ClientRequest clientRequest=new ClientRequest();
 clientRequest.setRoute("/products");
 clientRequest.setAction("POST");
 clientRequest.setData(productModel);
 ConnectToServer clientServerConnector=new ConnectToServer();

 ResponseBody response=clientServerConnector.connectToServer(clientRequest);
 String result=response.getStatus();


 if(result.equals("201")) {
    System.out.println("Product registered successfully");
   }
 else{
	   System.out.println(response.getStatus());
       System.out.println("Error occured registering"+ " product");
   }
 
	
 }
 //@Author INEZA Ange Michaella
 public List<ProductModel> viewProducts() throws Exception {
     ObjectMapper inputMapper = new ObjectMapper();
     ClientRequest clientRequest = new ClientRequest();
     clientRequest.setRoute("/products");
     clientRequest.setAction("GET");
     clientRequest.setData(1);
     ConnectToServer clientServerConnector = new ConnectToServer();
     ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);

     String json = (String) responseBody.getData();
     List<ProductModel> products= Arrays.asList(inputMapper.readValue(json, ProductModel[].class));
     
    String leftAlignFormat = "| %-11s | %-4d |%n";
    System.out.println("\t\t\t\t List of all products ");
    System.out.format("| #Id    | Product Name    | Product Type       | Company Id  | Price per Bulk |");
    System.out.format("+-----------------+------+%n");
    for ( ProductModel product : products) {
        String line = String.format("%s    |  %s             |  %s          | %s         | %s        ",product.getProductId(),product.getProductName(),product.getProductType(),product.getCompanyId(), product.getPricePerBulk());
        System.out.format(leftAlignFormat, line, 2, 3);

    }
    System.out.format("+-----------------+---------------------+%n");

    return products;
 }

}
