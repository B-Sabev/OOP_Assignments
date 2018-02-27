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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Board board = new Board();
       board.play(0, Field.FieldState.X);
       board.play(1, Field.FieldState.O);
       System.out.println(board.toString());
    }
    
}
