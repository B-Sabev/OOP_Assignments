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
        System.out.print("> ");
        
        String input = scanner.nextLine();
        String[] input_split = input.split(" ");
        
        switch (input_split[0]) {
            case "quit":
                quit = true;
                break;
            case "show":
                break;
            case "circle":
                createCircle(input_split);
                break;
            case "rectangle":
                createRectangle(input_split);
                break;
            case "move":
                move(input_split);
                break;
            case "remove":
                remove(input_split);
                break;
            case "sort":
                sortShapes(input_split);
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

    private void createCircle(String[] input_split) {
        if(this.num_shapes >= View.MAX_NUM_SHAPES){
            System.out.println("Maximum shapes reached");
        } else {
            if(input_split.length == 4){ // keyword + 3 params
                double[] params = stringToDouble(Arrays.copyOfRange(input_split, 1, input_split.length));
                shapes[this.num_shapes] = new Circle(params[0], params[1], params[2]);
                this.num_shapes++;
            } else {
                System.out.println("circle needs 3 parameters");
            }
        } 
    }

    private void createRectangle(String[] input_split) {
        if(this.num_shapes >= View.MAX_NUM_SHAPES){
            System.out.println("Maximum shapes reached");
        } else {
            if(input_split.length == 5){ // keyword + 4 params
                double[] params = stringToDouble(Arrays.copyOfRange(input_split, 1, input_split.length));
                shapes[this.num_shapes] = new Rectangle(params[0], params[1], params[2], params[3]);
                this.num_shapes++;
            } else {
                System.out.println("rectangle needs 4 parameters");
            } 
        }
    }

    private void move(String[] input_split) {
        if(input_split.length == 4){ // keyword + index + 2 positions
            int index = Integer.parseInt(input_split[1]);
            double[] params = stringToDouble(Arrays.copyOfRange(input_split, 2, input_split.length));
            shapes[index].moveTo(params[0], params[1]);
        } else {
            System.out.println("circle needs 4 parameters");
        }

              
    }

    private void remove(String[] input_split) {
        if(input_split.length == 2){ // keyword + index 
            int index = Integer.parseInt(input_split[1]);
            for(int i=index;i<shapes.length-1;i++){
                shapes[index] = shapes[index+1];
            }
            this.num_shapes--;
        } else {
            System.out.println("remove needs 1 parameters");
        }
        
    }

    private void sortShapes(String[] input_split) {
        ShapeComperator comperator = new ShapeComperator();
        Shape[] validShapes = new Shape[this.num_shapes];
        validShapes = Arrays.copyOfRange(this.shapes, 0, num_shapes);
    
        if (input_split.length == 2 && input_split[1].equals("x")) {
            comperator = new ShapeComperator(SortingMode.X);
        } else if (input_split.length == 2 && input_split[1].equals("y")) {
            comperator = new ShapeComperator(SortingMode.Y);
        }
        Arrays.sort(validShapes, comperator);
        for(int i=0;i<validShapes.length;i++){
            this.shapes[i] = validShapes[i];
        }
                
    }
    
    
    
    
    
    
}
