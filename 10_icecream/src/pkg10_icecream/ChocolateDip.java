package pkg10_icecream;

import static pkg10_icecream.Price.CHOCO_DIP;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class ChocolateDip extends Topping {
    
    public ChocolateDip(Ice ice) {
        super(ice);
    }

    @Override
    public int getPrice() {
        return ice.getPrice() + CHOCO_DIP.price();
    }
    
     @Override
    public String getDescription(){
        return "chocolate dip " + ice.getDescription();
    }
    
    
}
