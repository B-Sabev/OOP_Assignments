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
public class Game {

    private Board board;
    private Player[] players;
    private int nextPlayer;

    public Game(Player[] players) {
        this.board = new Board();
        this.players = players;
        this.nextPlayer = 0; //by default player1 is the first
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }
    
    public void playTurn(){
        if(!this.board.winning()){
            // ask the player for col to play
            int col = this.players[this.nextPlayer].getStrategy().play();
            // play the given column with the player color
            this.board.play(col, this.players[this.nextPlayer].getColor()); // play on the board with the player's color
            this.nextPlayer = otherPlayer(); // give turn to the next player
        }
    }
    
    public int otherPlayer(){
        return this.nextPlayer == 0 ? 1 : 0;
    }
    
    public int winner(){
        // if the board is in the winning position, nextPlayer is loser
        if(this.board.winning())
            return otherPlayer();
        return -1;
    }
    
}
