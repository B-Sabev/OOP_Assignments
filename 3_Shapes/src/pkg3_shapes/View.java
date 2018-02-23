/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

import java.util.Arrays;
import java.util.Scanner;
import pkg3_shapes.ShapeComperator.SortingMode;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class View {
    
    private Shape[] shapes;
    private int num_shapes;
    public static final int MAX_NUM_SHAPES = 10;

    public View() {
        this.shapes = new Shape[MAX_NUM_SHAPES];
        this.num_shapes = 0;
    }
    
    public void userInteraction(){
        System.out.println(help());
        boolean quit = false;
        while(!quit){
            quit = userCommand();
        }
        System.out.println("Quitting...");
        System.exit(0);
    }
    
    public boolean userCommand() {
        boolean quit = false;

        Scanner scanner = new Scanner(System.in);
        System.out.print("$: ");
        String choice = scanner.nextLine();
        String[] split = choice.split(" ");
        double[] params;
        int index;
        
        Shape[] validShapes = new Shape[this.num_shapes];
        validShapes = Arrays.copyOfRange(this.shapes, 0, num_shapes);
        
        
        switch (split[0]) {
            case "quit":
                quit = true;
                break;
            case "show":
                break;
            case "circle":
       
                params = stringToDouble(subset(split, 1, split.length));
                if (split.length-1 != 3) {
                    throw new IllegalArgumentException("Exactly 3 parameters required!");
                } else {
                    // add a new circle
                    shapes[this.num_shapes] = new Circle(params[0], params[1], params[2]);
                    this.num_shapes++;
                }
                break;

            case "rectangle":
                System.out.println("Currenty we have " + this.num_shapes + " shapes");
                
                params = stringToDouble(subset(split, 1, split.length));
                if (split.length-1 != 4) {
                    throw new IllegalArgumentException("Exactly 4 parameters required!");
                } else {
                    // add a new rectrangle
                    shapes[this.num_shapes] = new Rectangle(params[0], params[1], params[2], params[3]);
                    this.num_shapes++;
                    
                }
                break;

            case "move":
                index = Integer.parseInt(split[1]);
                params = stringToDouble(Arrays.copyOfRange(split, 2, split.length));
                if (split.length-1 != 3) {
                    throw new IllegalArgumentException("Exactly 3 parameters required!");
                } else {
                    // move the shape of index, to mParameter dist
                    shapes[index].moveTo(params[0], params[1]);
                }
                break;
                
            case "remove":
                index = Integer.parseInt(split[1]);
                shapes[index] = null;
                this.num_shapes--;

            case "sort":
                ShapeComperator comperator = new ShapeComperator();
    
                if (split.length == 2 && split[1].equals("x")) {
                    comperator = new ShapeComperator(SortingMode.X);
                    
                } else if (split.length == 2 && split[1].equals("y")) {
                    comperator = new ShapeComperator(SortingMode.Y);
                    
                } 
                Arrays.sort(validShapes, comperator);
                for(int i=0;i<validShapes.length;i++){
                    this.shapes[i] = validShapes[i];
                }
                
                
                break;
            default:
                System.out.println("Please enter a valid command");
                break;
        }
        showShapes();
        return quit;
    }
    
    public static double[] stringToDouble(String[] strs) {
            double[] cDouble = new double[strs.length];
            for (int i=0; i<strs.length; i++) {
                cDouble[i] = Double.parseDouble(strs[i]);
            }
            return cDouble;
    }
    
    public String help(){
        return "Welcome to Geometric Objects.  What would you like to do?\n" +
                "1. quit - Quit the Program.\n" + 
                "2. show - lists the Geometric Objects.\n" +
                "3. circle x y r - adds a circle at (x, y) with radius r if the array is not full.\n" +
                "4. rectangle x y h w - adds a rectangle at (x, y) with height h and width w\n" + 
                "5. move i dx dy - moves the ith object over the specified distance in x and y direction\n" + 
                "6. sort - sorts the objects in the array\n" +
                "Please enter your choice.\n";
        
    }
    
    public void showShapes(){
        for(int i=0; i<this.num_shapes;i++){
            System.out.println(this.shapes[i].toString());
        }
    }
    
    public static double[] subset(double[] array, int i1, int i2){
        assert i2 > i1 : "Last index must be bigger than first";
        double[] subarray = new double[i2-i1];
        for(int i=i1;i<i2;i++){
            subarray[i-i1] = array[i];
        }
        return subarray;
        
    }
    public static String[] subset(String[] array, int i1, int i2){
        assert i2 > i1 : "Last index must be bigger than first";
        String[] subarray = new String[i2-i1];
        for(int i=i1;i<i2;i++){
            subarray[i-i1] = array[i];
        }
        return subarray;
        
    }
    
    
    
    
    
}
