package pkg10_shoppingcart;

/**
 *
 * @author Borislav
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
