public class Product{ 
    private int productId; 
    private String product_name; 
    private double price;
    private int quantity; 

    public Product(){
        productId = 0;
        product_name = "Unknown";
        price = 0.0;
        quantity = 0;
    }
    public Product(int productId, String product_name, double price, int quantity) { 
        this.productId = productId; 
        this.product_name = product_name; 
        this.price = price; 
        this.quantity = quantity; 
    } 

    public int getProductId() { 

        return productId; 

    }
    public void setProductId(int productId) { 

        this.productId = productId; 

    }

    public String getProductName() { 

        return product_name; 

    }
    public void setProductName(String product_name) { 

        this.product_name = product_name; 

    } 

    public double getPrice() { 

        return price; 

    }
    public void setPrice(double price) { 

        this.price = price; 

    } 

    public int getQuantity() { 

        return quantity; 

    } 
    public void setQuantity(int quantity) { 

        this.quantity = quantity; 

    } 
    public void displayProductInfo() { 
        System.out.println("Product Id: " + productId); 
        System.out.println("Product name: " + product_name);
        System.out.println("Price: " + price);
        System.out.println("Quanitiy of product: " + quantity);
    } 
}