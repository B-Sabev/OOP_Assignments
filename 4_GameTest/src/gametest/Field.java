/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public enum Field {
    
    RED, YELLOW, EMPTY;
    
    public Field other(){
        switch(this){
            case RED:
                return YELLOW;
            case YELLOW:
                return RED;
            default:
                return EMPTY;
        }
    }
    
    @Override
    public String toString(){
        if(this.equals(YELLOW))
            return "O";
        if(this.equals(RED)){
            return "X";
        }
        return "."; 
    }
}
