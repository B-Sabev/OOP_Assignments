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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        (new Connect4TUI()).playGame();
        
        /*
        Board board = new Board();
        ComputerStrategy strategy = new ComputerStrategy(board);
        Board[] new_boards = strategy.genPossibleBoards(Field.YELLOW);
        for(Board b : new_boards)
            System.out.println(b.toString());
        */
        
        /*
        TODO
            implement play in ComputerStrategy
            make Connect4TUI pretty
            Game, accept different turns, or create construct differently in Connect4TUI
        
            game stops if board is completely filled
            refuse to play col if it is already filled
       
            When you have spare time you can add features like choosing who has the first turn, reading the name
            of the human player, playing another game, quitting a game, getting a hint, and undo the last move.
         */
       
    }
    
}
