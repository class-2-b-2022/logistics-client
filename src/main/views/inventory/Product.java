package main.views.inventory;
import formats.ProductModel;
import formats.*;
import java.io.*;
import java.net.*;
import java.util.*;
public class Product {
	ProductModel productModel=new ProductModel();
    Scanner sc = new Scanner(System.in);
    ClientRequest request;
    public void createProduct(){
        try {
            

            @SuppressWarnings("resource")
			Socket socket = new Socket("localhost",5450);
            OutputStream outToServer = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outToServer);
            

           


          
            System.out.println("Register product");
            System.out.println("Product Name? ");
              productModel.setProductName(sc.nextLine());
              System.out.println("Product Type? ");
              productModel.setProductType(sc.nextLine());
              System.out.println("Price per Bulk? ");
              productModel.setPricePerBulk(sc.nextLine());
              System.out.println("User Id? ");
              productModel.setUserId(sc.nextInt());

         


            request = new ClientRequest("inventory/products", "POST", productModel);
            out.writeObject(request);

            InputStream serverResponse = socket.getInputStream();
            ObjectInputStream inFromServer = new ObjectInputStream(serverResponse);
   System.out.println(inFromServer);
            
            List productResult = (List) inFromServer.readObject();
            System.out.println(productResult);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
