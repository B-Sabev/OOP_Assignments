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
public class WhippedCream extends Topping {

    public WhippedCream(Ice ice) {
        super(ice);
    }

    @Override
    public int getPrice() {
        return ice.getPrice() + 50;
    }
    
    @Override
    public String getDescription(){
        return "whipped " + ice.getDescription();
    }
    
}
