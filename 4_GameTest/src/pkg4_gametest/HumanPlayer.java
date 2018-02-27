/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4_gametest;

import pkg4_gametest.Field.FieldState;

/**
 *
 * @author Borislav
 */
public class HumanPlayer implements Player{
    
    public String name;
    public FieldState color;
    
    
    @Override
    public int play() {
        // TODO ask user for input
        return 0;
    }
    

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public FieldState getColor() {
        return this.color;
    }
    
    @Override
    public void setColor(FieldState color) {
        this.color = color;
    }

}
