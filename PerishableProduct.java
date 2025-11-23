public class PerishableProduct extends Product { 
    private String expirydate;   

    public PerishableProduct(){ 
        super();
        this.expirydate = "None";
    } 

    public PerishableProduct(int productId, String product_name, double price, int quantity, String expirydate) { 
        super(productId, product_name, price, quantity); 
        this.expirydate = expirydate; 
    } 

    public String getExpirydate(){ 

        return expirydate; 

    }
    public void setExpirydate(String expirydate){ 

        this.expirydate = expirydate; 

    }
    
    @Override
    public void displayProductInfo(){ 
        super.displayProductInfo();
        System.out.println("Expiry Date: " + expirydate);
    } 
} 