/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_icecream;

/**
 *
 * @author Borislav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        How to forbid whippedCream followed by chocolated dip ???
        Exercise description:
            Ice - is it the right way to implement the description ??
            Toppings - should I add their price to the ice cream price ???
                        should I modify the description ??
        
        use decorator pattern
        generate example icecreams, printing their description and price (class with static methods, or in main)                   
        
        */
        Ice whippedVanillaIce = new ChocolateDip(new WhippedCream(new VanillaIce()));
        
        System.out.println(whippedVanillaIce);
        System.out.println(whippedVanillaIce.getPrice());
        
        
        Ice vanillaIce = new VanillaIce();
        System.out.println(vanillaIce.getDescription());
    }
    
}
