/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_icecream;

/**
 * Enum to hold the price list of all items
 * 
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public enum Price {

    VANILLA_ICE (150),
    YOGHURT_ICE (200),
    WHIPPED_CREAM (50),
    CHOCO_DIP (30);
    
    private int price;
    private Price (int price){
        this.price = price;
    } 
    
    public int price(){
        return price;
    }
}
