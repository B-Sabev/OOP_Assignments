/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6_slidinggame;

import java.util.Scanner;
import static pkg6_slidinggame.SlidingGame.randomGame;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class View {
    
    private Scanner scan;

    public View() {
       scan = new Scanner(System.in);
    }

    public void initGame() {
        startMessage();
        
        while(true){
            int choice = scan.nextInt();
            System.out.print("\n");

            switch(choice) {
                case 1:     
                    showHardCodedGames();
                    break;
                case 2:
                    showRandomGame();
                    break;
                case 3:
                    Configuration game = parseGameFromInput();
                    
                    break;
                case 4:     
                    System.out.println("Thank you for playing!");
                    System.exit(0);
                    break;
                default:    
                    System.out.println("Please enter a valid choice between 1 and 4");
                    break;
                }
        }
    }
    
    public void startMessage() {
        System.out.println("Welcome to the Sliding Game!");
        System.out.print("Would you like to be provided with pre-built boards(1), a random board(2), create your own(3), or quit(4)? ");
        System.out.print("\n");
    }

    private void showHardCodedGames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showRandomGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Configuration parseGameFromInput() {
        System.out.println("Please enter 1-16 in the order you want them to appear starting from the top left, 16 is for the hole");
        System.out.println("Seperate your numbers with a , (1,2,3,...) : ");
        
        int[] board = new int[SlidingGame.N * SlidingGame.N];
        // take the user input
        String  nums = scan.next();
        // split by ,
        String[] numbers = nums.trim().split(",");
        for(int i=0; i<numbers.length; i++)
            board[i] = Integer.parseInt(numbers[i]);
        
        for(int b : board){
            System.out.println(b);
        }
        
        return new SlidingGame(board);
    }
    
    
    public void showGameSolving(Configuration game){
        System.out.println(game.toString());
        Solver solver = new Solver(game);
        Configuration solution = solver.solve();
        if(solution == null){
            System.out.println("The current game cannot be solved");
        } else {
            System.out.println("Found path with " + solution.pathFromRoot().size() + " steps");
            for(Configuration s : solution.pathFromRoot())
                System.out.println(s.toString());
        }
    }
}
