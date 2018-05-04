package pkg10_shoppingcart;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public abstract class Item {
    
    private String description;
    private double price;
    
    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public abstract double shippingCost();
}
