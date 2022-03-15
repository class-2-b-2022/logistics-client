package Views;

import java.util.Scanner;
import logic.ProductInventory;

public class InventoryModel {

	public static void main(String[] args) throws Exception {
		 int choice;
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t              Let's Get Started           ");
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t  --------    Select an Option    -----");
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t ________    1. Products management _______");
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\t\t\t\t ________    2. Inventory   _______");
	        System.out.println("\t\t\t\t                                       ");
	        System.out.println("\tEnter your choice:      ");
	        choice = scanner.nextInt();
	        switch (choice){
	            case 1:
	                System.out.println("\t\t\t\t -----------  Product management ---------------");
	                System.out.println("\t\t\t\t                                       ");
	                System.out.println("\t\t\t\t                                       ");
productManagement();
	             
	            break;
	            case 2:
	                System.out.println("\t\t\t\t -----------  Manage Inventory ---------------  ");
	                // Tracking();
	            default:
	                System.out.println("\t\t\t\t No option seleted ");
	        }

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
