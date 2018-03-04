/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

import java.util.Scanner;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class ComputerController implements PlayerObserver {
    
    /**
     *
     * @param strategy
     */
    public ComputerController( ComputerStrategy strategy ) {
        strategy.register(this);
    }

    /**
     *
     * @param strategy
     * @param ncol
     * @param field
     */
    @Override
    public void update(PlayerStrategy strategy, Field[][] field) {
        ((ComputerStrategy) strategy).getCopyOfBoard(field);
    }
}
