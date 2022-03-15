package logic;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import formats.ProductModel;
import formats.Vehicle;
import Utils.*;


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
      productModel.setPricePerBulk(sc.nextLine());
      System.out.println("Company Id? ");
    productModel.setCompanyId(sc.nextInt());
     

    
 RequestBody clientRequest=new RequestBody();
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
     RequestBody clientRequest = new RequestBody();
     clientRequest.setRoute("/products");
     clientRequest.setAction("READ");
     ConnectToServer clientServerConnector = new ConnectToServer();
     ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
     
     List<ProductModel> products= Arrays.asList(inputMapper.readValue(responseBody.getData(), ProductModel[].class));
    return products;
 }

}
