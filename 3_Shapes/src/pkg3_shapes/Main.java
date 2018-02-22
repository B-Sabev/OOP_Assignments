/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

import java.lang.reflect.Array;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO create interface with all nessesary methods
        
        // TODO impliement the interface in 2 classes
        
        // TODO add the command line user interaction
        /*
        Read with scan.nextLine()
        Split into spaces
        Check if the first string is a valid command with switch()
        Execute command on case:
        */
        
        Circle c = new Circle(5,5,2);
        System.out.println(c.getX());
        c.moveTo(5, 5);
        System.out.println(c.getX());
        System.out.println(c.getArea());
        System.out.println(c.getBottomBorder());
        
        ShapeComperator comperator = new ShapeComperator();

        //Array.sort(some_array, comperator);
        
       
    }
    
}
