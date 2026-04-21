package Inventory_Management;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	 static HashMap<Integer, Product> inventory = new HashMap<>();
	    static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {

	        while (true) {
	            System.out.println("\n1.Add Product 2.View 3.Search 4.Update 5.Delete 6.Exit");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1: addProduct(); break;
	                case 2: viewProducts(); break;
	                case 3: searchProduct(); break;
	                case 4: updateProduct(); break;
	                case 5: deleteProduct(); break;
	                case 6: System.exit(0);
	                default: System.out.println("Invalid choice");
	            }
	        }
	    }

	    static void addProduct() {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Quantity: ");
	        int qty = sc.nextInt();

	        System.out.print("Enter Price: ");
	        double price = sc.nextDouble();

	        inventory.put(id, new Product(id, name, qty, price));
	        System.out.println("Product Added!");
	    }

	    static void viewProducts() {
	        if (inventory.isEmpty()) {
	            System.out.println("No products available");
	            return;
	        }

	        for (Product p : inventory.values()) {
	            p.display();
	        }
	    }

	    static void searchProduct() {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();

	        if (inventory.containsKey(id)) {
	            inventory.get(id).display();
	        } else {
	            System.out.println("Product Not Found");
	        }
	    }

	    static void updateProduct() {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        if (inventory.containsKey(id)) {
	            Product p = inventory.get(id);

	            System.out.print("Enter new name: ");
	            p.name = sc.nextLine();

	            System.out.print("Enter new quantity: ");
	            p.quantity = sc.nextInt();

	            System.out.print("Enter new price: ");
	            p.price = sc.nextDouble();

	            System.out.println("Updated!");
	        } else {
	            System.out.println("Product Not Found");
	        }
	    }

	    static void deleteProduct() {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();

	        if (inventory.remove(id) != null) {
	            System.out.println("Deleted!");
	        } else {
	            System.out.println("Product Not Found");
	        }
	    }
	    
	    

}
