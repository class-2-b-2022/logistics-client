package Views.Product;

import java.util.Scanner;
import logic.ProductInventory;

public class Product {

	public static void main(String[] args) throws Exception {
                               
productManagement();
	             }

	private static void productManagement() throws Exception {
		 int choice;
	        Scanner scanner = new Scanner(System.in);
	      
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t ________    1. Products Create _______");
	        System.out.println("\t\t\t\t ________    2. Products Read _______");
	        System.out.println("\t\t\t\t ________    3. Products Update _______");
	        System.out.println("\t\t\t\t ________    4. Products Delete _______");
	   
	        choice = scanner.nextInt();
	        ProductInventory product=new ProductInventory();
	        switch (choice){
            case 1:


product.registerProduct();
break;
             
       
            case 2:
                System.out.println("Read  ");
             break;
            case 4:
                System.out.println("Update  ");
             break;
            case 5:
                System.out.println("Delete  ");
             break;
            default:
                System.out.println("\t\t\t\t No option seleted ");
        }
	}

}
