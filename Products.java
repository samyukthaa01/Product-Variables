
/*
 * 5. The data types of variables include int, String, char, boolean, float,
 * double, long, byte, short.
 * 6. Primitive data types include all the data types defined in Java
 * Non-primitive include Strings, arrays, and classes defined by programmers.
 * */


public class Products {

    //the productCount is a static variable meaning
    //it can be shared among instances of the class
    private static int productCount = 0;

    //the price of shipping fee is constant hence, final
    private final double shippingFee = 3.9;

    //below are the instance variables
    private String productId;
    private String productName;
    private double price;

    //this is a reference variable pointing to seller object
    private Seller seller;

    public Products(String productId, String productName, double price, Seller seller) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.seller = seller;
        productCount++;
    }

    // Method to display product details
    public void showProductDetails() {
        // Local variable called details
        String details =
                "Product ID: " + productId + "\n" +
                        "Product Name: " + productName + "\n" +
                        "Price: RM" + price + "\n" +
                        "Shipping Fee: RM" + shippingFee + "\n" +
                        "Seller: " + seller.getName();
        System.out.println(details);
    }

    public static class Seller {
        private String sellerName;

        public Seller(String name) {
            this.sellerName = name;
        }

        public String getName() {
            return sellerName;
        }
    }

    public static void main(String[] args) {
        //A new seller object
        Seller seller1 = new Seller("Seller A");

        // Creating Product objects
        Products product1 = new Products("P01", "Watch", 230.50, seller1);

        // Showing the product details
        product1.showProductDetails();

        //Displaying the total products added.
        System.out.println("Total Products: " + productCount);
    }

}
