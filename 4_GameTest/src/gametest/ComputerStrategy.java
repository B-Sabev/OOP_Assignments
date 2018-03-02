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
        return 0;
    }
    
    
    public Board[] genPossibleBoards(Field nextColor){
        if(!this.board.isFull()) {
            int emptyCols = 0;
            for(int i=0;i<Board.NCOL;i++){
                if(!this.board.colIsFull(i)){
                    emptyCols += 1;
                }     
            }
            Board[] possibleBoards = new Board[emptyCols];
            for(int i=0;i<possibleBoards.length;i++){
                if(!this.board.colIsFull(i)){
                    possibleBoards[i] = new Board(this.board.copy());
                    possibleBoards[i].play(i, nextColor);
                }     
            }
            return possibleBoards;
        }
        return null;
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
