/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringOfBeads;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Austin
 */
public class StringOfBeads extends Application {
    
    Circle circ;
    Line line;
    int newX = 15;
    int newY = 15;
    Color c = Color.rgb(0,0,255);
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        circ = new Circle(10.0, 10.0, 10.0, c);
        circ.setLayoutX(175);
        circ.setLayoutY(150);
        line = new Line(0, 0, circ.getLayoutX(), circ.getLayoutY());
        
        Pane root = new Pane();
        root.getChildren().add(line);
        root.getChildren().add(circ);

        Scene scene = new Scene(root, 300, 250);
        
        //need to figure out how to change the color of each new bead
        //get beads to follow line. MouseMoved event within MouseClicked event?
        scene.setOnMouseClicked((MouseEvent e) -> {
            int redder = 100;
            int bluer = 15;
            Color c2 = Color.rgb(0+redder, 0, 255 - bluer);
            redder += 15;
            bluer -= 15; 
            Circle circle = new Circle(10, 10, 10, c2);
      
            //circle.setFill(c2);
            circle.setLayoutX(line.getEndX() - newX);
            newX += 15;
            circle.setLayoutY(line.getEndY() - newY);
            newY += 15;
            root.getChildren().add(circle);
//            Scene scene2 = new Scene(root, 300, 250);
//            scene2.setOnMouseMoved((MouseEvent e2) -> {
//                circle.relocate(line.getEndX() - newX, line.getEndY() - newY);
//            });
            //primaryStage.setScene(scene2);root.getChildren().add(circle);
        });
        
        scene.setOnMouseMoved((MouseEvent e) -> {
            circ.relocate(e.getX(), e.getY());
            line.setEndX(e.getX());
            line.setEndY(e.getY());
        });        
        
        primaryStage.setTitle("String of Beads");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}


