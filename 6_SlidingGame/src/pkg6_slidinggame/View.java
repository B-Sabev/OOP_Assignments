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
public class View extends SlidingGame {

    public View(int[] start) {
        super(start);
    }

    public static void initGame() {
        //int choice = 0;
        //startMessage();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Sliding Game!");
        System.out.print("Would you like to be provided with pre-built boards(1), a random board(2), create your own(3), or quit(4)? ");
        int choice = scan.nextInt();
        System.out.print("\n");
        
        switch(choice) {
            case 1:     
                        break;
            case 2:     SlidingGame s = randomGame(SlidingGame.N);
                        break;
            case 3:     scan.useDelimiter(",");
                        System.out.println("Please enter 1-15 in the order you want them to appear starting from the top left");
                        System.out.println("Seperate your numbers with a , (1,2,3,...) : ");
                        //int nums = scan.nextInt();
                        int[] n = new int[15];
                        String  nums = scan.nextLine();
                        System.out.print(nums);

                        String[] numbers = nums.trim().split(",\\s+");

//                        for (int i = 0; i < numbers.length; i++) {
//                            n[i] = Integer.parseInt(numbers[i]);
//                        }
//                        
//                        for (int x = n[0]; x < n.length; x++) {
//                            
//                        }
                        
                        break;
            case 4:     System.out.println("Thank you for playing!");
                        System.exit(0);
                        break;
            default:    System.out.println("Please enter a valid choice between 1 and 4");
                        break;
        }
    }
    
//    public static void startMessage() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Welcome to the Sliding Game!");
//        System.out.print("Would you like to be provided with pre-built boards(1), a random board(2), create your own(3), or quit(4)? ");
//        int choice = scan.nextInt();
//        System.out.print("\n");
//    }
}
