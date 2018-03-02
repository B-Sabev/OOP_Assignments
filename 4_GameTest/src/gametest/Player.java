/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

/**
 *
 * @author Borislav
 */
public class Player {
    
    private final String name;
    private final Field color;
    private PlayerStrategy strategy;

    public Player(String name, Field color, PlayerStrategy strategy) {
        this.name = name;
        this.color = color;
        this.strategy = strategy; 
    }
    
    // getters for everything, setter only for strategy
    public void setStrategy(PlayerStrategy strategy) {
        this.strategy = strategy;
    }
   
    public String getName() {
        return name;
    }

    public Field getColor() {
        return color;
    }

    public PlayerStrategy getStrategy() {
        return strategy;
    }
}
