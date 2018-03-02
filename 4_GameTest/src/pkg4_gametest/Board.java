/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4_gametest;

import pkg4_gametest.Field.Color;

/**
 *
 * @author Borislav
 */
public class Board {
    // Connect 4 game
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
    
    public boolean winning(){
        // check rows cols and diagonals for winning position
        return false;
    }
    
    public Field[][] copy(){
        Field[][] copyBoard = new Field[this.board.length][this.board[0].length];
        for(int i=0; i<this.board.length; i++)
            System.arraycopy(this.board[i], 0, copyBoard[i], 0, this.board[0].length);
        return copyBoard; 
    }
    
    public void play(int col, Color playerColor){
        // check for every row accross this column, insert the player mark on the first empty
        if(col >= 0 && col < Board.NCOL){ // if col is valid
            for(int i=Board.NROW-1; i>= 0;i--){
                if(this.board[i][col].getState().equals(Color.EMPTY)){
                    this.board[i][col].setState(playerColor);
                    break;
                }
            }
        }
        
    }
   
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        for(int i=0; i<Board.NROW; i++){
            for(int j=0; j<Board.NCOL; j++){
                boardString.append(this.board[i][j].toString()).append(" ");
            }    
            boardString.append("\n");
        }
        return boardString.toString();         
    } 
}
