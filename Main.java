/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Scanner;
=======
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import pkg3_shapes.ShapeComperator.SortingMode;
>>>>>>> ab9643efb20c844fc8bcfa9eab931d5d1d967481

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
<<<<<<< HEAD
        
        
        Shape[] shapes = {new Circle(4,4,2),
                          new Rectangle(1,2,5,7),
                          new Rectangle(2,1,5,5),
                          new Rectangle(3,0,5,9)
        };
        
        for(Shape sh : shapes){
            System.out.println(sh.toString());
        }
        
<<<<<<< HEAD
        
        //Austin - View
        System.out.println("Welcome to Geometric Objects.  What would you like to do?");
        System.out.println("1. quit - Quit the Program.");
        System.out.println("2. show - lists the Geometric Objects.");
        System.out.println("3. circle x y r - adds a circle at (x, y) with radius r if the array is not full.");
        System.out.println("4. rectangle x y h w - adds a rectangle at (x, y) with height h and width w");
        System.out.println("5. move i dx dy - moves the ith object over the specified distance in x and y direction");
        System.out.println("6. sort - sorts the objects in the array");
        System.out.println("Please enter your choice.");
        Scanner scanner = new Scanner (System.in);
        String choice = scanner.nextLine();
        String[] split = choice.split(" ");
        switch (choice) {
            case "quit":    System.exit(0);
                            break;
            case "show":    
                
            case "circle":  double[] parameters = stringToDouble(Arrays.copyOfRange(split, 1, split.length));
                            if (split.length != 3) {
                                throw new IllegalArgumentException("Exactly 3 parameters required!");
                            }
                            break;
            
            case "rectangle":   double[] params = stringToDouble(Arrays.copyOfRange(split, 1, split.length));
                                if (split.length != 4) {
                                    throw new IllegalArgumentException("Exactly 4 parameters required!");
                                }
                                break;
                
            case "move":    int mInt = Integer.parseInt(split[1]);
                            double[] mParameters = stringToDouble(Arrays.copyOfRange(split, 2, split.length));
                            if (split.length != 3) {
                                throw new IllegalArgumentException("Exactly 3 parameters required!");
                            }
                            break;
            
            case "sort":    if (split.length == 1 ) {
                                ShapeComperator comperator = new ShapeComperator();
                                Arrays.sort(shapes, comperator);
                            }
                            
                            if (split.length == 2 && split[1].equals("x")) {
                                ShapeComperator comperator = new ShapeComperator(SortingMode.X);
                                Arrays.sort(shapes, comperator);
                            }
                            
                            if (split.length == 2 && split[1].equals("y")) {
                                ShapeComperator comperator = new ShapeComperator(SortingMode.Y);
                                Arrays.sort(shapes, comperator);
                            }
        }
        
       
    }
        public static double[] stringToDouble(String choice) {
            String[] cString = choice.split(" ");
            double[] cDouble = new double[cString.length];
            
            for (int i=0; i<cString.length; i++) {
                cDouble[i] = Double.parseDouble(cString[i]);
            }
            return cDouble;
        }
=======
        Shape[] subset = Arrays.copyOfRange(shapes, 1, shapes.length);
=======
>>>>>>> def82e46e133f189eb626ce9b51cad34e2b23701
      
    }
    
    
    
>>>>>>> ab9643efb20c844fc8bcfa9eab931d5d1d967481
}

        
