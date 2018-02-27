/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4_gametest;

import pkg4_gametest.Field.FieldState;

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
    
    public void play(int col, FieldState playerMark){
        // check for every row accross this column, insert the player mark on the first empty
        for(int i=Board.NROW-1; i>= 0;i--){
            if(this.board[i][col].getState().equals(FieldState.EMPTY)){
                this.board[i][col].setState(playerMark);
                break;
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
