/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_shoppingcart;

/**
 *
 * @author Austin
 */
public abstract class Item {
    
    private String description;
    private double price;
    //private double shipping;
    
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
