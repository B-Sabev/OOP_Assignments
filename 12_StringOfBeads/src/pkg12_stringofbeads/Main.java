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
    
    private static final double BEAD_SIZE = 10;
    private static final int MAX_RGB_VAL = 255,
                             MIN_RGB_VAL = 0;
   
    


    @Override
    public void start(Stage primaryStage) {
       
        // Create line and first bead in a group
        Group group = new Group();
        group.setTranslateX(0);
        group.setTranslateY(0);
        group.getChildren().add(new Line(0, 0, 50, 50));
        group.getChildren().add(new Circle(0, 0, BEAD_SIZE, Color.BLUE));
        group.getChildren().get(1).setLayoutX(50);
        group.getChildren().get(1).setLayoutY(50);
        
        
        
        Pane pane = new Pane(group);
        pane.setPrefWidth(300);
        pane.setPrefHeight(300);
       
        pane.setOnMouseEntered(e -> { 
            alignBeads(group, e.getX(), e.getY());
            e.consume();
        });
       
        pane.setOnMouseMoved(e -> {
            alignBeads(group, e.getX(), e.getY());
            e.consume();
        });
        
        // create new bead, repaint and align the beads
        pane.setOnMouseClicked(e -> {
            group.getChildren().add(new Circle(0, 0, BEAD_SIZE, Color.BLUE));
            double grad = MAX_RGB_VAL / ((double) group.getChildren().size() - 1);
            repaintBeads(group, grad);
            alignBeads(group, e.getX(), e.getY());
            e.consume();
        });
        
        Scene scene = new Scene(pane, 300, 250);
        
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
    
    private void repaintBeads(Group group, double gradient) {
        List<Node> nodes = group.getChildren();
        for(int i=0; i<nodes.size(); i++){
           if (nodes.get(i) instanceof Circle){
               ((Circle) nodes.get(i)).setFill(Color.rgb(MAX_RGB_VAL - ((int) gradient * i), 
                                                         MIN_RGB_VAL, 
                                                         MIN_RGB_VAL + (int) gradient * i));
           }
        }   
    }  
}
