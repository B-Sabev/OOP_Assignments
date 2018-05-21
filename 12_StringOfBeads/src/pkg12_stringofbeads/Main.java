package pkg12_stringofbeads;

import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main extends Application {
    
    private static final double BEAD_SIZE = 10, // radius of the bead in pixels
                                START_X = 50,  // starting position of the bead
                                START_Y = 50;
    private static final int MAX_RGB_VAL = 255, // const for the color pallete
                             MIN_RGB_VAL = 0,
                             SCENE_HEIGHT = 300, // dimentions of scene and pane
                             SCENE_WIDTH = 300;
    
    @Override
    public void start(Stage primaryStage) {
       
        // Create the line and the first bead at START position
        Group group = initGroup(START_X, START_Y);
        Pane pane = new Pane(group);
        pane.setPrefWidth(SCENE_WIDTH);
        pane.setPrefHeight(SCENE_HEIGHT);
       
        pane.setOnMouseEntered(e -> { 
            alignBeads(group, e.getX(), e.getY());
            e.consume();
        });
       
        pane.setOnMouseMoved(e -> {
            alignBeads(group, e.getX(), e.getY());
            e.consume();
        });
   
        pane.setOnMouseClicked(e -> {
            group.getChildren().add(new Circle(0, 0, BEAD_SIZE, Color.BLUE));
            repaintBeads(group);
            alignBeads(group, e.getX(), e.getY());
            e.consume();
        });
        
        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("String Of Beads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Align the elements in the group according to the mouse position
     * @param group - contains all the nodes
     * @param mouseX 
     * @param mouseY 
     */
    private void alignBeads(Group group, double mouseX, double mouseY){
        int numBeads = group.getChildren().size() - 1;
        double dx = mouseX /((double) numBeads);
        double dy = mouseY  / ((double) numBeads);
        ((Line) group.getChildren().get(0)).setEndX(mouseX);
        ((Line) group.getChildren().get(0)).setEndY(mouseY);
        // iterate only over the beads
        for(int i=1; i<numBeads+1; i++){
            if( group.getChildren().get(i) instanceof Circle ){
                group.getChildren().get(i).setLayoutX(dx * i);
                group.getChildren().get(i).setLayoutY(dy * i);
            }   
        }
    }
    
    /**
     * Color the beads correspondingly to their number and position
     * @param group - contains all beads
     */
    private void repaintBeads(Group group) {
        List<Node> nodes = group.getChildren();
        // compute by how much the color value should change from one bead to the next
        int gradient = MAX_RGB_VAL / ( nodes.size() - 1 );
        
        for(int i=0; i<nodes.size(); i++){
           if (nodes.get(i) instanceof Circle){
               ((Circle) nodes.get(i)).setFill(Color.rgb(MAX_RGB_VAL - gradient * i, 
                                                         MIN_RGB_VAL, 
                                                         MIN_RGB_VAL + gradient * i));
           }
        }   
    }  
    
    /**
     * Initialize a group with one line and one bead at a start position set by arguments
     * @param startX - X position of the first bead
     * @param startY - Y position of the first bead
     * @return - a populated group
     */
    private Group initGroup(double startX, double startY){
        Group group = new Group();
        group.setTranslateX(0);
        group.setTranslateY(0);
        group.getChildren().add(new Line(0, 0, startX, startY));
        group.getChildren().add(new Circle(0, 0, BEAD_SIZE, Color.BLUE));
        // set the circle at the starting position
        group.getChildren().get(1).setLayoutX(startX);
        group.getChildren().get(1).setLayoutY(startY);
        return group;
    }
}
