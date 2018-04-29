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
//public class ShoppingCart extends Item {
//    String description;
//    Double price;
    
    List<Item> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }
    
    public void addItem(Item item) {
        this.items.add(item);
    }
    
    public void removeItem(Item item) {
        this.items.remove(item);
    }
    
    public double computeCost() {
        double sum = 0.0;
        for(Item item : items){
            sum += item.getPrice();
        }
        
        return sum;
    }
    
    public double pay(Payment paymentMethod) {
        double amount = computeCost();
        paymentMethod.pay(amount);
        return amount;
    }

//    @Override
//    public double shippingCost() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
