package pkg10_icecream;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Sprinkles extends Topping{

    public Sprinkles(Ice ice) {
        super(ice);
    }

    @Override
    public int getPrice() {
        return ice.getPrice(); // spinkles are free
    }
    
     @Override
    public String getDescription(){
        return ice.getDescription() + " with sprinkles";
    }
    
    
}
