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
        Exercise description:
            Ice - is it the right way to implement the description ??
            Toppings - should I add their price to the ice cream price ???
        
        use decorator pattern
        generate example icecreams, printing their description and price (class with static methods, or in main)                   
        
        */
        Ice whippedVanillaIce = new WhippedCream(new VanillaIce());
        System.out.println(whippedVanillaIce.getDescription());
    }
    
}
