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
    /** 
     * Board for a connect 4 game, dim 6x7
     */
    private Field[][] board;
    public static final int NROW = 6;
    public static final int NCOL = 7;

    public Board() {
        this.board = initBoard();
    }

    public Board(Field[][] board) {
        this.board = board;
    }
    
    public Field[][] getBoard() {
        return board;
    }

    public void setBoard(Field[][] board) {
        this.board = board;
    }
    
    /**
     * create a Field[][] with size of the connect 4 board 
     * filled with Field.EMPTY
     * @return the filled board
     */
    public final Field[][] initBoard(){
        Field[][] startBoard = new Field[Board.NROW][Board.NCOL];
        for(int i=0; i<Board.NROW; i++)
            for(int j=0; j<Board.NCOL; j++)
                startBoard[i][j] = Field.EMPTY;
        return startBoard;    
    }
    
    
    /**
     * Checks if a column is filled
     * @param col - column to check
     * @return true if the column is full and can't play there anymore,
     *         false otherwise
     */
    public boolean colIsFull(int col){
        for(int i=0;i<Board.NROW;i++)
            if(this.board[i][col].equals(Field.EMPTY))
                return false;
        return true;
    }
        
    /**
     * Checks if the board is full
     * @return
     */
    public boolean isFull(){
        for(int i=0;i<Board.NCOL;i++)
            if(!colIsFull(i))
                return false;
        return true;
    }
    
    /**
     * Checks the board for a winning position
     * winning is true if there is a non-EMPTY row, column or diagonal 
     * of 4 same filled fields 
     * @return boolean
     */
    public boolean winning(){
        // check rows cols and diagonals for winning position
        Field[][] rowColDiags = new Field[4][4];
        for(int i=0; i<Board.NROW; i++){
            for(int j=0; j<Board.NCOL; j++){
                // this.board[i][j] - take the row, col and diag and compare
                if(!this.board[i][j].equals(Field.EMPTY)){ // if it is empty, no need to check
                    rowColDiags = getRowColDiags(i,j,4);
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
    
    /**
     * Checks if the board is full, but nobody win
     * @return true if it is a draw, else false
     */
    public boolean isDraw(){
        return !winning() && isFull();
    }

    /**
     * For a given position on the board in (row,col) and
     * len, number of consecutive fields, get all valid rows, columns and diagonals 
     * @param row - 1st index of the field 
     * @param col - 2nd index of the field
     * @param len - number of consecutive fields
     * @return Field[][], 4 Field[] arrays with the increasing 
     *  row, column, left and right diagonal from the starting point
     */
    public Field[][] getRowColDiags(int row, int col, int len){
        Field[][] rowColDiags = new Field[4][len];
        
        for(int i=0;i<len;i++){ // i is 0,1,2,3
            if(row + len-1 < Board.NROW) // get a col
                rowColDiags[0][i] = this.board[row+i][col];
            else 
                rowColDiags[0][i] = Field.EMPTY;
            
            if(col + len-1 < Board.NCOL) // get a row
                rowColDiags[1][i] = this.board[row][col+i];
            else
                rowColDiags[1][i] = Field.EMPTY;
            
            if(row + len-1 < Board.NROW && col + len-1 < Board.NCOL) // get top left to bottom right diag
                rowColDiags[2][i] = this.board[row+i][col+i];
            else
                rowColDiags[2][i] = Field.EMPTY;
            
            if(row + len-1 < Board.NROW && col - len+1 > -1)
                rowColDiags[3][i] = this.board[row+i][col-i];
            else
                rowColDiags[3][i] = Field.EMPTY;
        }
        return rowColDiags;
    }
   
    /**
     * Check if all elements of the fields array are the same
     * @param fields - array
     * @return - true if all elements in fields are the same, false otherwise
     */
    public boolean areFieldsSame(Field[] fields){
        for(int i=0;i<fields.length-1;i++){
            if(!fields[i].equals(fields[i+1])) // if 2 consequtive entries are not equal
                return false;
        }
        return true;
    }
    
    /**
     * Make a copy of the board
     * @return copy of the board
     */
    public Field[][] copy(){
        Field[][] copyBoard = new Field[this.board.length][this.board[0].length];
        for(int i=0; i<this.board.length; i++)
            System.arraycopy(this.board[i], 0, copyBoard[i], 0, this.board[0].length);
        return copyBoard; 
    }
    
    /**
     * Play the playerColor at the selected col, updates this.board
     * @param col - col to play
     * @param playerColor - the player mark
     */
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
