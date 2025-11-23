public class InventoryManager {
    private Product[] products; 
    private int index = 0;

    public InventoryManager(int size){
        products = new Product[size];
    }
    
    public void addProduct(Product product){
        if (index < products.length){
            products[index] = product;
            index++;
        }
        else{
            System.out.println("\n*******Inventory is full*******\n");
        }
    }

    public void veiwProducts() { 
        System.out.println("\nInventory products\n-------------------------");
        for (int i = 0; i < products.length; i++) { 
            if (products[i] != null) { 
                products[i].displayProductInfo();
                System.out.println("-------------------------");
            } 
        } 
    }

    public void updateProduct(int id, double new_price, int new_quantity) throws ProductNotFoundException{ 
        for (int i = 0; i < products.length; i++) { 
            if (products[i] != null && products[i].getProductId() == id) { 
                products[i].setPrice(new_price); 
                products[i].setQuantity(new_quantity); 
                System.out.println("Product's price and quanity have been updated.");
                return;
            }
        }
        throw new ProductNotFoundException("Product with ID " + id + " not found.");
    }
    public void deleteProduct(int id) throws ProductNotFoundException{ 
        for (int i = 0; i < products.length; i++) { 
            if (products[i] != null && products[i].getProductId() == id){
                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[products.length - 1] = null;
                index--;
                System.out.println("Product has been deleted.");
                return;
            }
        }
        throw new ProductNotFoundException("Product with ID " + id + " not found.");
    }

    public Product searchProduct(int id) throws ProductNotFoundException {
        for (Product p : products) {
            if (p != null && p.getProductId() == id) {
                return p;
            }
        }
        throw new ProductNotFoundException("Product with ID " + id + " not found.");
    }

}
