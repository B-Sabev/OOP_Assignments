package pkg10_shoppingcart;

/**
 *
 * @author Borislav
 */
public class WashingMachine extends Item{

    public WashingMachine(){
        super("washing machine", 499);
    }
    
    @Override
    public double shippingCost() {
        return 30;
    }
    
}
