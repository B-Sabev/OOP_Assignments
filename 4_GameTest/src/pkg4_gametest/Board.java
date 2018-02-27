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
public class Board {
    // for the connect 4 game
    public Field[][] board;
    public static int NROW = 6;
    public static int NCOL = 7;

    public Board() {
        this.board = initBoard();
    }
    
    public final Field[][] initBoard(){
        Field[][] startBoard = new Field[Board.NROW][Board.NCOL];
        for(int i=0; i<Board.NROW; i++)
            for(int j=0; j<Board.NCOL; j++)
                startBoard[i][j] = new Field();
        return startBoard;    
    }
    
    // copy
    // winning
    // play
    // toString
    
    
    
    
    
}
