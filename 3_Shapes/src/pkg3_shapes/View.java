/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3_shapes;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class View {
    
    private Shape[] shapes;
    public static final int MAX_NUM_SHAPES = 10;

    public View() {
        this.shapes = new Shape[MAX_NUM_SHAPES];
    }
    
    public void userInteraction(){
        System.out.println(help());
        boolean quit = false;
        while(!quit){
            quit = userCommand();
        }
        System.out.println("Quitting...");
    }
    
    public boolean userCommand(){
        // ask the user for input
        // switch for the commands
        // execture command - if quit return true, else return false
        // print the shapes 
       
        
        
        return true;
    }
    
    public String help(){
        return "Not supported yet";
    }
    
    public void showShapes(){
        for(Shape shape : this.shapes){
            System.out.println(shape.toString());
        }
    }
    
    
    
    
    
}
