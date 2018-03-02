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
public class Player {
    
    private String name;
    private Field color;
    private PlayerStrategy strategy;

    public Player(String name, Field color, PlayerStrategy strategy) {
        this.name = name;
        this.color = color;
        this.strategy = strategy; 
    }

    public Player(PlayerStrategy strategy) {
        this.strategy = strategy;
        this.name = "";
        this.color = Field.EMPTY;
    }

    public void setStrategy(PlayerStrategy strategy) {
        this.strategy = strategy;
    }
    
    public PlayerStrategy getStrategy() {
        return strategy;
    }
   
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Field getColor() {
        return color;
    }

    public void setColor(Field color) {
        this.color = color;
    }
}
