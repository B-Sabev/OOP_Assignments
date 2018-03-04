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
public interface PlayerObserver {

    /**
     * Update the controllers with their current strategy,
     * and the most recent copy of the board
     * @param strategy
     * @param field
     */
    public void update( PlayerStrategy strategy, Field[][] field);
}
