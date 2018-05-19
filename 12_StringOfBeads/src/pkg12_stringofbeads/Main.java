
package pkg12_stringofbeads;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/*
TODO 
    improve the code to have the last bead follow the mouse
    the last bead should be always at the center of the mouse
    and the line following the bead

*/

/**
 *
 * @author Borislav
 */
public class Main extends Application {
    
    private static final double START_X = 0, 
                                START_Y = 0;
    private static final int MAX_RGB_VAL = 255,
                             MIN_RGB_VAL = 0;
    private int numBeads = 0;
    

    
    
    @Override
    public void start(Stage primaryStage) {
        
        SimpleDoubleProperty MAX_RGB = new SimpleDoubleProperty(255);
        SimpleIntegerProperty numberOfBeads = new SimpleIntegerProperty(1);
        SimpleDoubleProperty gradient = new SimpleDoubleProperty();
        gradient.bind(MAX_RGB.divide(numberOfBeads));
     
        
        Group group = new Group();
        Pane pane = new Pane(group);

        pane.setPrefWidth(300);
        pane.setPrefHeight(300);

        group.setTranslateX(0);
        group.setTranslateY(0);
        
        group.getChildren().add(new Circle(50, 50, 10, Color.BLUE));
        /*
        pane.setOnMouseEntered(e -> {
      
            group.getChildren().get(0).setLayoutX(e.getX());
            group.getChildren().get(0).setLayoutY(e.getY());
        });
        */
        pane.setOnMouseMoved(e -> {
            group.getChildren().get(0).setLayoutX(e.getX());
            group.getChildren().get(0).setLayoutY(e.getY());
            e.consume();
        });
        
        pane.setOnMouseClicked(e -> {
            numBeads++;
            numberOfBeads.set(numberOfBeads.get() + 1);
            System.out.println(numberOfBeads.getValue() + " " + gradient.doubleValue());
            
            repaintBeads(gradient.doubleValue());
            
            ///colorAndAlignBeads(group, e.getX(), e.getY());
            
            /*
            group.getChildren().add(new Circle(e.getX(), //+ group.getLayoutX(),
                                               e.getY(), //+ group.getLayoutY(),
                                                10));
            colorBeads(group);
            alignBeads(e, group);
            */
            e.consume();
        });
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void colorAndAlign2(Group group, DoubleProperty mouseXProp, DoubleProperty mouseYProp){
        
    }
    
    
    private void colorAndAlignBeads(Group group, double mouseX, double mouseY) {
        group.getChildren().clear(); // delete all nodes in the group
        int gradient = MAX_RGB_VAL / numBeads; // gradient of the color
        double dx = (mouseX - START_X) / numBeads;
        double dy = (mouseY - START_Y) / numBeads;
        
        for(int i=0; i<numBeads; i++){
            Circle bead = new Circle(START_X + dx * ((double)i+1),
                                     START_Y + dy * ((double)i+1),
                                     10,
                                     Color.rgb(MAX_RGB_VAL - gradient * i, 
                                               MIN_RGB_VAL, 
                                               MIN_RGB_VAL + gradient * i));
            group.getChildren().add(bead);
        }
        group.getChildren().add(new Line(START_X, START_Y, mouseX, mouseY));
    
    }

    private void repaintBeads(double doubleValue) {
        
    }
    
}
