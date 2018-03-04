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
public class ComputerStrategy implements PlayerStrategy {
    
    private Board board;
    private Field myColor; 
    private Field humanColor;
    private PlayerObserver controller;
    private final int SEARCH_DEPTH = 4;
    
    public ComputerStrategy(Board board) {
        this.board = board;
        this.myColor = Field.YELLOW;
        this.humanColor = Field.RED;
    }

    public ComputerStrategy() {
        this.board = new Board();
        this.myColor = Field.YELLOW;
        this.humanColor = Field.RED;
    }
    
    /**
     * Play all possible moves, evaluate each of the possible boards with minimax
     * and select the one that maximizes the value
     * @return the column to play to arrive at the best heuristic value
     */
    @Override
    public int play() {  
        Board[] possibleBoards = new Board[Board.NCOL];
        int[] values = new int[Board.NCOL];
        for(int i=0; i<Board.NCOL; i++){
            if(this.board.colIsFull(i))
                // if a column is unplayable, make its value -inf
                values[i] = Integer.MIN_VALUE;
            else {
                // play every possible move and evaluate all results
                possibleBoards[i] = new Board(this.board.copy());
                possibleBoards[i].play(i, this.myColor);
                values[i] = minimax(possibleBoards[i], this.SEARCH_DEPTH, false);
            }
        }
        return argmax(values);
    }
    
    /**
     * Find the index of the largest number in an array
     * @param array
     * @return 
     */
    public static int argmax(int[] array){
        int argmax = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
                argmax = i;
            }
        }
        return argmax;
    }
    
    /**
     * Generate all possible boards from a give position in one turn
     * @param start_board
     * @param nextColor
     * @return array of all possible boards
     */
    public Board[] genPossibleBoards(Board start_board, Field nextColor){
        if(!start_board.isFull()) {
            int emptyCols = 0;
            for(int i=0;i<Board.NCOL;i++){
                if(!start_board.colIsFull(i)){
                    emptyCols += 1;
                }     
            }
            Board[] possibleBoards = new Board[emptyCols];
            for(int i=0;i<possibleBoards.length;i++){
                possibleBoards[i] = new Board(start_board.copy());
                possibleBoards[i].play(i, nextColor);     
            }
            return possibleBoards;
        }
        return null;
    }
    
    /**
     * Minimax search of the game board, return a value of the current position
     * @param game_board - current position of the board
     * @param depth - depth to evaluate
     * @param maxPlayer - is the maximizing player in turn
     * @return the heuristic value of the position
     */
    public int minimax(Board game_board, int depth, boolean maxPlayer){  
        if(depth == 0 || game_board.winning()){
            return valueOfBoard(game_board, !maxPlayer);
        } else {
            // Min if maxPlayer, else Max
            int bestValue = maxPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
            int v;
            
            Board[] child_boards = maxPlayer ? genPossibleBoards(game_board, this.myColor) :
                                                genPossibleBoards(game_board, this.humanColor);

            for(Board child : child_boards){
                // recursive call for the next player
                v = minimax(child, depth-1, !maxPlayer);
                bestValue = maxPlayer ? Math.max(bestValue, v) : Math.min(bestValue, v);
            }
            return bestValue;
        }
    }
    
    /**
     * Evaluate the board
     *      tie = 0
     *      win = +inf
     *      lose = -inf
     *      otherwise = 10 * all_2_in_row_col_diag + 100 * all_3_in_row_col_diag
     * @param board - current state of the board
     * @param maxPlayer - is the maximizing Player that made this position
     * @return a heuristic value of the board
     */
    public int valueOfBoard(Board board, boolean maxPlayer){
        int value=0;
        // the heuristic value of making 2 and 3 marks in a row, column or diag
        final int VALUE_OF_2 = 10; 
        final int VALUE_OF_3 = 100;
        
        if(board.isDraw())  // if it's a tie = 0
            value = 0;  
        else if(board.winning() && maxPlayer) // if win: +inf
            value = Integer.MAX_VALUE;
        else if(board.winning() && !maxPlayer) // if lose: -inf 
            value = Integer.MIN_VALUE;
        else {
            
            // not a win or draw, so eval the state based on the probability of win
            Field[][] combinations;

            for(int i=0; i<Board.NROW; i++){
                for(int j=0; j<Board.NCOL; j++){
                    // get each 2 combinations in row, col and diag
                    combinations = board.getRowColDiags(i, j, 2);
                    for(Field[] fields : combinations){
                        if(fields[0].equals(this.myColor) && board.areFieldsSame(fields)){
                            // if combination is made by the computer 
                            value += VALUE_OF_2;
                        }
                    }
                    
                    combinations = board.getRowColDiags(i, j, 3);
                    for(Field[] fields : combinations){
                        if(fields[0].equals(this.myColor) && board.areFieldsSame(fields)){
                            // if combination is made by the computer 
                            value += VALUE_OF_3;
                        }
                    }
                }
            }
        }  
        return value;  
    }
    
    @Override
    public void register(PlayerObserver controller) {
        this.controller = controller;
    }
   
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    /**
     * Create a new Board of a Field[][] and assign to this.board
     * @param fields
     */
    public void getCopyOfBoard(Field[][] fields){
        this.board = new Board(fields);
    }
}
