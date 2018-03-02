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
public class Board {
    // Connect 4 game
    private Field[][] board;
    public static int NROW = 6;
    public static int NCOL = 7;

    public Board() {
        this.board = initBoard();
    }

    public Board(Field[][] board) {
        this.board = board;
    }
    
    
    
    public final Field[][] initBoard(){
        Field[][] startBoard = new Field[Board.NROW][Board.NCOL];
        for(int i=0; i<Board.NROW; i++)
            for(int j=0; j<Board.NCOL; j++)
                startBoard[i][j] = Field.EMPTY;
        return startBoard;    
    }
    
    public boolean winning(){
        // check rows cols and diagonals for winning position
        Field[][] rowColDiags = new Field[4][4];
        for(int i=0; i<Board.NROW; i++){
            for(int j=0; j<Board.NCOL; j++){
                // this.board[i][j] - take the row, col and diag and compare
                if(!this.board[i][j].equals(Field.EMPTY)){ // if it is empty, no need to check
                    rowColDiags = getRowColDiags(i,j);
                    // row, col and diag filled with the proper values or empty
                    // if any of them is the same (EMPTY is excuded), then it is winnable
                    for(Field[] fields : rowColDiags){
                        if(!fields[0].equals(Field.EMPTY) && areFieldsSame(fields))
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
    // for this.board[row][col] get all the valid 4 row, 4 col and left, right diag
    public Field[][] getRowColDiags(int row, int col){
        Field[][] rowColDiags = new Field[4][4];
        
        for(int i=0;i<4;i++){ // i is 0,1,2,3
            if(row + 3 < Board.NROW) // get a col
                rowColDiags[0][i] = this.board[row+i][col];
            else 
                rowColDiags[0][i] = Field.EMPTY;
            
            if(col + 3 < Board.NCOL) // get a row
                rowColDiags[1][i] = this.board[row][col+i];
            else
                rowColDiags[1][i] = Field.EMPTY;
            
            if(row + 3 < Board.NROW && col + 3 < Board.NCOL) // get top left to bottom right diag
                rowColDiags[2][i] = this.board[row+i][col+i];
            else
                rowColDiags[2][i] = Field.EMPTY;
            
            if(row + 3 < Board.NROW && col - 3 > -1)
                rowColDiags[3][i] = this.board[row+i][col-i];
            else
                rowColDiags[3][i] = Field.EMPTY;
        }
        return rowColDiags;
    }
   
    // Checks if a fields array has all the same values
    public boolean areFieldsSame(Field[] fields){
        for(int i=0;i<fields.length-1;i++){
            if(!fields[i].equals(fields[i+1])) // if 2 consequtive entries are not equal
                return false;
        }
        return true;
    }
    
    public Field[][] copy(){
        Field[][] copyBoard = new Field[this.board.length][this.board[0].length];
        for(int i=0; i<this.board.length; i++)
            System.arraycopy(this.board[i], 0, copyBoard[i], 0, this.board[0].length);
        return copyBoard; 
    }
    
    public void play(int col, Field playerColor){
        // check for every row accross this column, insert the player mark on the first empty
        if(col >= 0 && col < Board.NCOL){ // if col is valid
            for(int i=Board.NROW-1; i>= 0;i--){ // start from the bottom
                if(this.board[i][col].equals(Field.EMPTY)){
                    this.board[i][col] = playerColor;
                    break;
                }
            }
        }
        
    }
    
    public boolean colIsFull(int col){
        for(int i=0;i<Board.NROW;i++)
            if(this.board[i][col].equals(Field.EMPTY))
                return false;
        return true;
    }
        
    public boolean isFull(){
        for(int i=0;i<Board.NCOL;i++)
            if(!colIsFull(i))
                return false;
        return true;
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
