package pkg10_shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class ShoppingCart {
    
    private List<Item> items;
    private Payment paymentMethod;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
        paymentMethod = new IdealStrategy("Default bank",
                                     "999-999-999",
                                     "0000");
    }
    
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    
    public double computeCost() {
        // item price + shipping
        double totalPrice = 0;
        double totalShipping = 0;
        double shipping;
        ArrayList<Double> shippingCosts = new ArrayList<>();
        
        
        for(Item item : items){
            totalPrice += item.getPrice();
            shipping = item.shippingCost();
            
            // add only the shipping costs that have not occured yet
            if(!shippingCosts.contains(shipping))
                shippingCosts.add(shipping);
        }
        
        for(Double s : shippingCosts)
            totalShipping += s;
        
        
        return totalPrice + totalShipping;
    }
    
    public double checkOut() {
        double amount = computeCost();
        paymentMethod.pay(amount);
        items.clear();
        return amount;
    }
    
    
    public void changePaymentMethod(Payment newPaymentMethod) {
        this.paymentMethod = newPaymentMethod;
    }
    
}
