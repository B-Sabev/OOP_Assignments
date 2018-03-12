/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

/**
 *
 * @author Borislav
 */
public enum Move {
    NORTH, SOUTH, EAST, WEST;
    
    public int[] toIndex(){
        int dx=0;
        int dy=0;
        switch(this){
            case NORTH:
                dy = -1;
                break;
            case SOUTH:
                dy = 1;
                break;
            case EAST:
                dx = 1;
                break;
            case WEST:
                dx = -1;
                break;
            default: 
        }
        return new int[]{dx, dy};
    }
    
    public static Move[] getMoves(){
        return new Move[]{NORTH, SOUTH, WEST, EAST};
    }
}
