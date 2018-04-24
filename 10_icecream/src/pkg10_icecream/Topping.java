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
public abstract class Topping extends Ice {
    protected Ice ice;

    public Topping(Ice ice) {
        super();
        this.ice = ice;
    }
    
}
