package logic;

import java.util.*;
import formats.ProductModel;
import Utils.*;


public class ProductInventory {
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
      System.out.println("User Id? ");
      productModel.setUserId(sc.nextInt());

    
 RequestBody clientRequest=new RequestBody();
 clientRequest.setRoute("Inventory/Products");
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

}
