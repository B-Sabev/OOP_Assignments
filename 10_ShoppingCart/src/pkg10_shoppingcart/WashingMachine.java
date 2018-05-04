package pkg10_shoppingcart;

/**
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
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
