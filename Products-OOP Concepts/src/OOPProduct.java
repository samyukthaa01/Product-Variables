// Abstract class Product to show the Abstraction
abstract class Product {
    private static int productCount = 0;
    private final double shippingFee = 3.9;

    private String productId;
    private String productName;
    private double price;
    private Seller seller;


    public Product(String productId, String productName, double price, Seller seller) throws InvalidProductException {
        if (productId == null || productId.isEmpty()) {
            throw new InvalidProductException("Product ID cannot be null or empty");
        }
        if (productName == null || productName.isEmpty()) {
            throw new InvalidProductException("Product Name cannot be null or empty");
        }
        if (price < 0) {
            throw new InvalidProductException("Price cannot be less than RM0");
        }
        if (seller == null) {
            throw new InvalidProductException("Seller cannot be null");
        }
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.seller = seller;
        productCount++;
    }

    // Encapsulation implemented using getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public static int getProductCount() {
        return productCount;
    }

    // Abstract method
    public abstract void showProductDetails();
}

/*Product is inherited by the subclass Groceries
Polymorphism: The showProductDetails() method is overridden in groceries subclass
 */

class Groceries extends Product {

    private String brand;

    public Groceries(String productId, String productName, double price, Seller seller, String brand) throws InvalidProductException {
        super(productId, productName, price, seller);
        if (brand == null || brand.isEmpty()) {
            throw new InvalidProductException("Brand cannot be null or empty");
        }
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void showProductDetails() {
        try {
            String details = "Product ID: " + getProductId()
                    + "\n" + "Product Name: " + getProductName()
                    + "\n" + "Price: RM" + getPrice() + "\n"
                    + "Shipping Fee: RM" + getShippingFee()
                    + "\n" + "Seller: " + getSeller().getName()
                    + "\n" + "Brand: " + brand;

            System.out.println(details);
        } catch (Exception e) {
            System.err.println("Error getting product details: " + e.getMessage());
        }


    }
}

// Product is inherited by subclass of Clothing
class Clothing extends Product {

    private String size;

    public Clothing(String productId, String productName, double price, Seller seller, String size) throws InvalidProductException {
        super(productId, productName, price, seller);
        if (size == null || size.isEmpty()) {
            throw new InvalidProductException("Size cannot be null or empty");
        }
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void showProductDetails() {
        try {
            String details = "Product ID: " + getProductId()
                    + "\n" + "Product Name: " + getProductName()
                    + "\n" + "Price: RM" + getPrice()
                    + "\n" + "Shipping Fee: RM" + getShippingFee()
                    + "\n" + "Seller: " + getSeller().getName()
                    + "\n" + "Size: " + size;
            System.out.println(details);
        } catch (Exception e) {
            System.err.println("Error getting product details: " + e.getMessage());
        }
    }
}
    // Seller class
    class Seller {
        private String sellerName;

        public Seller(String name) {
            this.sellerName = name;
        }

        public String getName() {
            return sellerName;
        }

        public void setName(String sellerName) {
            this.sellerName = sellerName;
        }
    }

    public class OOPProduct {
        public static void main(String[] args) {
            try {

                // A new seller object is created
                Seller seller1 = new Seller("Seller ABS");

                Product groceries = new Groceries("G001", "Flour", 5.0, seller1, "Rose");
                Product clothing = new Clothing("C001", "T-Shirt", 50.0, seller1, "M");

                // Showing the product details
                groceries.showProductDetails();
                clothing.showProductDetails();

//                clothing.setProductName();

                // Displaying the total products added.
                System.out.println("Total Products: " + Product.getProductCount());
            } catch (InvalidProductException e) {
                System.err.println("Error creating product: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid argument: " + e.getMessage());
            }
        }
    }