package pkg10_icecream;

import static pkg10_icecream.Price.YOGHURT_ICE;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class YoghurtIce extends Ice{

    public YoghurtIce() {
        super();
        description = "yoghurt ice";
    }
    
    @Override
    public int getPrice() {
        return YOGHURT_ICE.price();
    }
}
