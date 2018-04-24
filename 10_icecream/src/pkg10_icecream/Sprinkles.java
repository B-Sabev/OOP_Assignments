/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_icecream;

/**
 *
 * @author Borislav
 */
public class Sprinkles extends Topping{

    public Sprinkles(Ice ice) {
        super(ice);
    }

    @Override
    public int getPrice() {
        return ice.getPrice();
    }
    
     @Override
    public String getDescription(){
        return ice.getDescription() + " with sprinkles";
    }
    
    
}
