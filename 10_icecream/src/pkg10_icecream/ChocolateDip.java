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
public class ChocolateDip extends Topping {

    public ChocolateDip(Ice ice) {
        super(ice);
    }

    @Override
    public int getPrice() {
        return ice.getPrice() + 30;
    }
    
     @Override
    public String getDescription(){
        return "chocolate dip " + ice.getDescription();
    }
    
    
}
