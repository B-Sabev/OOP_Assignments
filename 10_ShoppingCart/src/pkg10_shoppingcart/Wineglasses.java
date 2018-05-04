package pkg10_shoppingcart;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Wineglasses extends Item {

    public Wineglasses(){
        super("wine glass", 8.5);
    }
    
    @Override
    public double shippingCost() {
        return 6.75;
    }
    
}
