/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_shoppingcart;


public class Watermelon extends Item {

    public Watermelon(){
        super("watermelon", 4.5);
    }
    
    @Override
    public double shippingCost() {
        return 6.75;
    }
    
}
