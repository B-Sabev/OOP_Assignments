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
public class HumanController implements PlayerObserver{
    
    private final Scanner in;

    /**
     *
     * @param strategy
     * @param in
     */
    public HumanController( HumanStrategy strategy, Scanner in ) {
        this.in = in;
        strategy.register(this);
    }
    
    /**
     *
     * @param strategy
     * @param ncol
     * @param fields
     */
    @Override
    public void update( PlayerStrategy strategy, Field[][] fields) {
        Board board = new Board(fields);
        int colToPlay = readColToPlay( board );
        ((HumanStrategy)strategy).setColToPlay(colToPlay);
    }
    
    
    /**
     * Read user input for the column to play
     * Repeats until it get a valid column to play and the column is not full
     * @param board - the current state of the board
     * @return a column to play in
     */
    private int readColToPlay( Board board ) {
        int number = 0;
        // enter a col 1-7
        while (!(0 < number && number <= Board.NCOL)) {
            System.out.print("Enter column to play "
                    + "(a positive integer, at most " + Board.NCOL
                    + "): ");
            System.out.flush();
            if (in.hasNextInt()) {
                number = in.nextInt();
            }
            in.nextLine();
            if(0 < number && number <= Board.NCOL && board.colIsFull(number-1)){
                System.out.println("Selected column is full, please choose another");
                number = 0; 
            }       
        }
        return number-1; // return the index 0 to 6
    }
    
    
}
