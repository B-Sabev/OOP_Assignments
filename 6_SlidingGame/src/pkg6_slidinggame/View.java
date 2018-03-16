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
    
    public static final int HARD_CODED = 1, 
                            RANDOM = 2, 
                            PARSE_INPUT = 3, 
                            QUIT = 4;
    private Scanner scan;

    public View() {
       scan = new Scanner(System.in);
    }

    public void initGame() {
        System.out.println("Welcome to the Sliding Game!");
        Configuration game;
        int choice;
        
        while(true){
            help();
            choice = scan.nextInt();
            switch(choice) {
                case HARD_CODED:     
                    game = getHardCodedGame();
                    showGameSolving(game);
                    break;
                case RANDOM:
                    game = getRandomGame();
                    showGameSolving(game);
                    break;
                case PARSE_INPUT:
                    game = parseGameFromInput();
                    showGameSolving(game);
                    break;
                case QUIT:     
                    System.out.println("Quitting...");
                    System.exit(0);
                    break;
                default:    
                    System.out.println("Please enter a valid choice between 1 and 4");
                    break;
                }
        }
    }
    
    public void help() {
        System.out.print("Select command:\n"
                        +"pre-built boards        (1)\n"
                        +"a random board          (2)\n"
                        +"create your own board   (3)\n"
                        +"quit                    (4)\n");
        System.out.print("> ");
    }

    private Configuration parseGameFromInput() {
        System.out.println("Please enter 1-16 in the order you want them to appear starting from the top left, 16 is for the hole");
        System.out.println("Seperate your numbers with a , (1,2,3,...) : ");
        
        int[] board = new int[SlidingGame.N * SlidingGame.N];
        // take the user input
        String  nums = scan.next();
        // split by ,
        String[] numbers = nums.trim().split(",");
        // parse to int
        for(int i=0; i<numbers.length; i++)
            board[i] = Integer.parseInt(numbers[i]);
        // create new game out of it and return it
        return new SlidingGame(board);
    }
    
    
    public void showGameSolving(Configuration game){
        System.out.println(game.toString());
        Solver solver = new Solver(game);
        Configuration solution = solver.solve();
        if(solution == null){
            System.out.println("The current game cannot be solved");
        } else {
            System.out.println("Found path with " + (solution.pathFromRoot().size()-1) + " steps");
            for(Configuration s : solution.pathFromRoot())
                System.out.println(s.toString());
        }
    }

    private Configuration getHardCodedGame() {
        int [] game = {16, 15, 4, 5,
                        1, 10, 13, 11,
                        8, 12, 9, 2,
                        6, 7, 3, 14};
        
        return new SlidingGame(game);
    }

    private Configuration getRandomGame() {
        return SlidingGame.randomGame(SlidingGame.N);
    }
}
