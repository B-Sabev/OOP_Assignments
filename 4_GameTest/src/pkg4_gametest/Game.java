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
public class Game {
    
    public Board board;
    public Player player1;
    public Player player2;
    public Player nextPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1; // by default the first player
    }
    
    public void playTurn(){
        if(!this.board.winning()){
            int col = this.nextPlayer.play(); // ask the player for col to play
            this.board.play(col, this.nextPlayer.getColor()); // play on the board with the player's color
            this.nextPlayer = otherPlayer(this.nextPlayer); // give turn to the next player
        }
    }
    
    public Player otherPlayer(Player player){
        return player.equals(this.player1) ? this.player2 : this.player1;
    }
    
    
    
}
