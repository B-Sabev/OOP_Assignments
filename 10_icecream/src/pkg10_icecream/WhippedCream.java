/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_icecream;

import static pkg10_icecream.Price.WHIPPED_CREAM;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class WhippedCream extends Topping {

    public WhippedCream(Ice ice) {
        super(ice);
    }

    @Override
    public int getPrice() {
        return ice.getPrice() + WHIPPED_CREAM.price();
    }
    
    @Override
    public String getDescription(){
        return "whipped " + ice.getDescription();
    }
    
}
