package views.Product;

import java.util.Scanner;
import logic.ProductManager;

public class Product {

	public static void main(String[] args) throws Exception {
                               
productManagement();
	             }

	public static void productManagement() throws Exception {
		 int choice;
	        Scanner scanner = new Scanner(System.in);
	      
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t ________    1. Products Create _______");
	        System.out.println("\t\t\t\t ________    2. Products Read _______");
	        System.out.println("\t\t\t\t ________    3. Products Update _______");
	        System.out.println("\t\t\t\t ________    4. Products Delete _______");
	   
	        choice = scanner.nextInt();
	        ProductManager product=new ProductManager();
	        switch (choice){
            case 1:
product.registerProduct();
break;
             
       
            case 2:
                System.out.println("------Available products------");
                product.viewProducts();
             break;
            case 3:
                System.out.println("Update  ");
             break;
            case 4:
                System.out.println("Delete  ");
             break;
            default:
                System.out.println("\t\t\t\t No option seleted ");
        }
	}

}
