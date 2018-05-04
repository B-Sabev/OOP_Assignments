/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Austin
 */
public abstract class ShoppingCart {
    
    List<Item> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
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
            if(!shippingCosts.contains(shipping))
                shippingCosts.add(shipping);
        }
        
        for(Double s : shippingCosts)
            totalShipping += s;
        
        
        return totalPrice + totalShipping;
    }
    
    public double pay(Payment paymentMethod) {
        double amount = computeCost();
        paymentMethod.pay(amount);
        return amount;
    }
    
}
