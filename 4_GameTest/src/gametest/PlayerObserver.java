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
public interface PlayerObserver {
    public void update( HumanStrategy strategy, int ncol);
}