/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

import java.util.Scanner;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Connect4TUI {
    
    private Game game;
    private Player user;
    private Player computer;
    private Scanner in;

    /**
     *
     */
    public Connect4TUI() {
        this.user = new Player("Player", Field.RED, new HumanStrategy());
        this.computer = new Player("Computer", Field.YELLOW, new ComputerStrategy());
        this.game = null;
        this.in = new Scanner(System.in);
    }
    
    public void playGame(){
        // welcome the player, ask for name, turn and set the game
        initGame();
        // create the controllers
        HumanController humanControl = new HumanController((HumanStrategy)this.user.getStrategy(), this.in);
        ComputerController computerControl = new ComputerController((ComputerStrategy)this.computer.getStrategy());
        
        // while the game is finished 
        while(!this.game.getBoard().winning() && !this.game.getBoard().isDraw()){
            // print the board
            System.out.println(this.game.getBoard().toString());
            // update controllers 
            updateControllers(humanControl, computerControl);
            // play turn
            this.game.playTurn();
        }
        reportWin();
        playAgain();
    }
    
    /**
     * Initialize the game with custom player name and turn
     */
    public void initGame(){
        welcomeMessage();
        String playerName = askForName();  // ask user for name
        int turn = askForTurn();           // ask who to go first
        this.user.setName(playerName);   // set the user's name
        this.game = new Game(new Player[]{this.user, this.computer}, turn-1);
    }
    
    public void welcomeMessage(){
        System.out.println("Welcome to Connect 4 game");
        System.out.println("You can play the game against a computer");
    }
    
    /**
     * Report the winner or a tie
     */
    public void reportWin(){
        System.out.println(this.game.getBoard().toString());
        if(this.game.getBoard().winning()){
            String winnerName = this.game.getPlayers()[this.game.winner()].getName();
            System.out.println("\nThe winner is " + winnerName + "\n");
        } else if (this.game.getBoard().isDraw()){
            System.out.println("It's a tie");
        }
    }
    
    /**
     * Ask the user for their name
     * @return
     */
    public String askForName(){
        System.out.print("Enter your name: ");
        String name = in.next();
        return name;
    }
    
    /**
     * Ask the user whose turn should be in the beginning
     * @return
     */
    public int askForTurn(){
        int index = 0;
        while(index<1 || index>2){
            System.out.print("Select who to start first,(1 for you, 2 for computer): ");
            index = in.nextInt();
        }
        return index;
    }
    
    /**
     * Update the controllers with an information about the board
     * @param humanControl
     * @param computerControl
     */
    public void updateControllers(HumanController humanControl, ComputerController computerControl){
        // update depending on user or computer
        if(game.getNextPlayer() == 0){
            humanControl.update(this.user.getStrategy(), this.game.getBoard().copy());
        }
        else {
            computerControl.update(this.computer.getStrategy(), this.game.getBoard().copy());
        }
    }
    
     /**
     * Prompts the user to play the game again.
     */
    public void playAgain() {
        System.out.println("Would you like to play another game? (y or n)");
        String replay = in.next();
        if (replay.equals("y") || replay.equals("Y") ) {
            playGame();
        } else if (replay.equals("n") || replay.equals("N")) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
//        else {
//            System.out.println("Please enter a valid choice.");
//        }
    }
    
}
