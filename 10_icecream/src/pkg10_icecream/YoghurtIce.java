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
public class YoghurtIce extends Ice{

    public YoghurtIce() {
        super();
    }
    
    @Override
    public int getPrice() {
        return 200;
    }
}
