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
    
    public static enum FieldState { EMPTY, X, O };
    public FieldState state;

    public Field(FieldState state) {
        this.state = state;
    }

    public Field() {
        this.state = FieldState.EMPTY;
    }

    public FieldState getState() {
        return state;
    }

    public void setState(FieldState state) {
        this.state = state;
    }
    
    public FieldState other(){
        if(state.equals(FieldState.O))
            return FieldState.X;
        if(state.equals(FieldState.X)){
            return FieldState.O;
        }
        return FieldState.EMPTY;    
    }
    
    @Override
    public String toString(){
        if(state.equals(FieldState.O))
            return "O";
        if(state.equals(FieldState.X)){
            return "X";
        }
        return "_"; 
    }
}
