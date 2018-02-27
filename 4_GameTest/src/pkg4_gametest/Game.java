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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Game(Board board, Player player1, Player player2) {
        this.board = new Board();
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
