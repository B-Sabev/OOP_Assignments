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
public class ComputerPlayer implements Player{
    
    public String name;
    public Field.FieldState color;
    
    @Override
    public int play() {
        // implement the play method
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
    public Field.FieldState getColor() {
        return this.color;
    }
    
    @Override
    public void setColor(Field.FieldState color) {
        this.color = color;
    }

    
    
}
