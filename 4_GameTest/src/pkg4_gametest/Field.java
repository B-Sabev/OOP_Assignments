/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4_gametest;

/**
 *
 * @author Borislav
 */
public class Field {
    
    public static enum Color { RED, YELLOW, EMPTY};
    public Color state;

    public Field(Color state) {
        this.state = state;
    }

    public Field() {
        this.state = Color.EMPTY;
    }

    public Color getState() {
        return state;
    }

    public void setState(Color state) {
        this.state = state;
    }
    
    public Color other(){
        if(state.equals(Color.RED))
            return Color.YELLOW;
        if(state.equals(Color.YELLOW)){
            return Color.RED;
        }
        return Color.EMPTY;    
    }
    
    @Override
    public String toString(){
        if(state.equals(Color.YELLOW))
            return "O";
        if(state.equals(Color.RED)){
            return "X";
        }
        return "_"; 
    }
}
