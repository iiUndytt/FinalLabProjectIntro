import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);
        InventoryManager inventory = null;
        boolean invCheck = true; //Array Exception Size Handling
        while (true){

            if (invCheck){
                try{
                    System.out.print("Enter the size of your inventory: ");
                    int size = key.nextInt();
                    inventory = new InventoryManager(size);
                    invCheck = false;
                } catch (Exception e){
                    System.out.println("Invalid input. Please enter a valid input");
                    key.nextLine();
                    continue;
                }
            }

            System.out.println("====== Inventory Management System ======");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = key.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number only.");
                key.nextLine();
                continue;
            }

            if (choice == 1){ //Add Product
                try {

                    System.out.print("Enter Product ID: ");
                    int id = key.nextInt();
                    key.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = key.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = key.nextDouble();

                    System.out.print("Enter Product Quantity: ");
                    int qty = key.nextInt();

                    System.out.print("Enter (1) if the Product has an expiry date, (2) if it does not: ");
                    int expdCheck = key.nextInt();

                    if (expdCheck == 1){ // Check if its perishable or not
                        key.nextLine();
                        System.out.print("Enter the expiry date (MMM/DD/YYYY): ");
                        String expd = key.nextLine();

                        PerishableProduct p = new PerishableProduct(id, name, price, qty, expd);
                        inventory.addProduct(p);
                    }
                    else if (expdCheck == 2){
                        Product p = new Product(id, name, price, qty);
                        inventory.addProduct(p);
                    }
                    else{
                        System.out.println("\nNot a valid input, please try again\n");
                        continue;
                    }
                }
                catch (Exception e){
                    System.out.println("Invalid input! Enter a input.");
                    key.nextLine();
                }
            }

            else if (choice == 2){ //View Products
                inventory.veiwProducts();
                }

            else if (choice == 3){ //Update Product
                try{
                    System.out.print("Enter Product ID to update: ");
                    int id = key.nextInt();

                    System.out.print("Enter new price: ");
                    double new_price = key.nextDouble();

                    System.out.print("Enter new quantity: ");
                    int new_quantity = key.nextInt();

                    inventory.updateProduct(id, new_price, new_quantity);
                    }
                catch (ProductNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch (Exception e){
                    System.out.println("Invalid input! Enter a input.");
                    key.nextLine();
                    }
                }

            else if (choice == 4){ // Delete Product
                try {
                    System.out.print("Enter Product ID to be deleted: ");
                    int id = key.nextInt();
                    inventory.deleteProduct(id);
                }
                catch (ProductNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch (Exception e){
                    System.out.println("Invalid input! Enter a valid number.");
                    key.nextLine();
                }
            }
            else if (choice == 5){ // Search Product
                try {
                    System.out.print("Enter Product ID to search: ");
                    int id = key.nextInt();
                    Product p = inventory.searchProduct(id);
                    System.out.println("Product Found: ");
                    p.displayProductInfo();
                }
                catch (ProductNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch (Exception e){
                    System.out.println("Invalid input!");
                    key.nextLine();
                }
            }
            else if (choice == 6){ //Exit
                System.out.println("Goodbye!");
                key.close();
                break;
            }

            try {
                if (choice < 1 || choice > 6) {
                    throw new InvalidInputException("\n*****Invalid Option*****\n");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }
}
