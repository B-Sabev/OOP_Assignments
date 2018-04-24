package pkg10_icecream;

import java.util.ArrayList;

/**
 * Create example instances of Ice and print them to the console
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class IceTest {
    
    public ArrayList<Ice> iceArray;
    
    public IceTest(){
        createIceCreams();
    }

    private void createIceCreams() {
        iceArray = new ArrayList<>();
        iceArray.add( new VanillaIce() );
        iceArray.add( new YoghurtIce() );
        iceArray.add( new Sprinkles( new VanillaIce() ) );
        iceArray.add( new Sprinkles( new YoghurtIce() ) );
        iceArray.add( new WhippedCream( new VanillaIce() ) );
        iceArray.add( new WhippedCream( new YoghurtIce() ) );
        iceArray.add( new ChocolateDip( new VanillaIce() ) );
        iceArray.add( new ChocolateDip( new YoghurtIce() ) );
        iceArray.add( new WhippedCream( new Sprinkles( new VanillaIce() ) ) );
        iceArray.add( new ChocolateDip( new Sprinkles( new YoghurtIce() ) ) );
        iceArray.add( new WhippedCream ( new ChocolateDip (new Sprinkles ( new VanillaIce() ) ) ) );
        iceArray.add( new ChocolateDip ( new WhippedCream (new Sprinkles ( new YoghurtIce() ) ) ) );
        
    }
    
    public void showIcecreams(){
        for(Ice ice : iceArray){
            System.out.println(ice +"\n");
        }
    }
    
}
