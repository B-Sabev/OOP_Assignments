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
public class HumanStrategy implements PlayerStrategy {

    private PlayerObserver controller;
    private int colToPlay;

    @Override
    public int play() {
        return this.colToPlay;
    }
    
    public void setColToPlay(int colToPlay){
        this.colToPlay = colToPlay;
    }
    
    public void register(PlayerObserver controller) {
        this.controller = controller;
    }
    
}
