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
public class VanillaIce extends Ice {

    public VanillaIce() {
        super("vanilla ice");
    }
    
    @Override
    public int getPrice() {
        return 150;
    }
    
}
