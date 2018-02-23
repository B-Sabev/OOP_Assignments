/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import pkg3_shapes.ShapeComperator.SortingMode;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO add the command line user interaction
        /*
        Read with scan.nextLine()
        Split into spaces
        Check if the first string is a valid command with switch()
        Execute command on case:
        */
        
        Shape[] shapes = {new Circle(0,1,2), 
                          new Circle(1,0,1),
                          new Rectangle(0,0,5,5),
                          new Rectangle(1,0,10,10)};
        
        for(Shape sh : shapes){
            System.out.println(sh.toString());
        }
        System.out.println(shapes[2].getLeftBorder() + " " + shapes[2].getBottomBorder());
        shapes[2].moveTo(1,1);
        System.out.println(shapes[2].getLeftBorder() + " " + shapes[2].getBottomBorder());
        
        System.out.println(shapes[0].toString());
        
        
        System.out.println("\n\n\n\n\n");
        
        String s = "circle 5.6 6.6";
        String[] split = s.split(" ");
        for(String s1 : split)
            System.out.println(s1);
        
        
        
        Circle c = new Circle(5,5,2);
        System.out.println(c.getX());
        c.moveTo(5, 5);
        System.out.println(c.getX());
        System.out.println(c.getArea());
        System.out.println(c.getBottomBorder());
        
        
        
        
        
        String[] fruits = new String[] {"Pineapple","Apple", "Orange", "Banana"};
        ShapeComperator comperator = new ShapeComperator(SortingMode.Y);
        
        Arrays.sort(shapes, comperator);
        Arrays.sort(fruits);
        
        for(Shape shape : shapes){
            System.out.println("\nLeft " + shape.getLeftBorder());
            System.out.println("Bottom " + shape.getBottomBorder());
            System.out.println("Area " + shape.getArea());
        }
       
    }
    
}
