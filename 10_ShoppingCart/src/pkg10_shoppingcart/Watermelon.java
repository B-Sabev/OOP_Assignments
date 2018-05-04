package pkg10_shoppingcart;


/*
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
*/

public class Watermelon extends Item {

    public Watermelon(){
        super("watermelon", 4.5);
    }
    
    @Override
    public double shippingCost() {
        return 6.75;
    }
    
}
