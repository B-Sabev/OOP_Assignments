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
    private Field myColor; // hardcoded, you have to update it with the controller
    private Field humanColor;
    
    
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
    
    
    
    @Override
    public int play() {
        Board[] possibleBoards = new Board[7];
        int[] values = {0, 0, 0, 0, 0, 0, 0};
        for(int i=0; i<Board.NCOL; i++){
            if(!this.board.colIsFull(i)){
                possibleBoards[i] = new Board(this.board.copy());
                possibleBoards[i].play(i, this.myColor);
                values[i] = minimax(possibleBoards[i], 5, true);
            } else {
                // if the col is full, make it impossible to pick
                values[i] = Integer.MIN_VALUE;
            }
        }
        
        int argmax = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<values.length;i++){
            if(values[i] > max){
                max = values[i];
                argmax = i;
            }
        }
        for(int v : values){
            System.out.println(v);
        }
        
        return argmax;
    }
    
    
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
    
    public int minimax(Board board, int depth, boolean maxPlayer){  
        if(depth == 0 || board.winning()){
            return valueOfBoard(board, maxPlayer);
        } else {
            // Min if maxPlayer, else Max
            int bestValue = maxPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
            int v = maxPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            Board[] child_boards = genPossibleBoards(this.board, this.myColor);
            for(Board child : child_boards){
                v = minimax(child, depth-1, !maxPlayer);
                bestValue = maxPlayer ? Math.max(bestValue, v) : Math.min(bestValue, v);
            }
            return bestValue;
        }
    }
    
    public int valueOfBoard(Board board, boolean maxPlayer){
        if(!board.winning()){
            return 0;
        } else if(maxPlayer) {
            return 1;
        } else {
            return -1;
        }
    }
    
   
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    public void getCopyOfBoard(Field[][] fields){
        this.board = new Board(fields);
    }
}
