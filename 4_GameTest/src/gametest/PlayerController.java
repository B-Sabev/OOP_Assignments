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
public class PlayerController implements PlayerObserver{
    
    private final Scanner in;

    public PlayerController( HumanStrategy strategy, Scanner in ) {
        this.in = in;
        strategy.register(this);
    }
    
    @Override
    public void update( HumanStrategy strategy, int ncol ) {
        int colToPlay = readColToPlay( ncol );
        strategy.setColToPlay(colToPlay);
    }
    
    public void updateComputer( ComputerStrategy strategy, Field[][] board) {
        strategy.getCopyOfBoard(board);
    }
    
    private int readColToPlay( int ncol ) {
        int number = 0;
        // enter a col 1-7
        while (!(0 < number && number <= ncol)) {
            System.out.print("Enter column to play "
                    + "(a positive integer, at most " + ncol
                    + "): ");
            System.out.flush();
            if (in.hasNextInt()) {
                number = in.nextInt();
            }
            in.nextLine();
        }
        return number-1; // return the index 0 to 6
    }
    
    
}
