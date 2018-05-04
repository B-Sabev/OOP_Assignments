/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11_kitchentimer;

import java.time.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Borislav
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField entry = new TextField();
        
        
        // start button
        Button startB = new Button();
        startB.setText("Start");
        startB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                /// read the value of the text field - make it more robuts to errors
                Integer value1 = Integer.valueOf(entry.getText());
                System.out.println("Hello World! + " +value1);
            }
        });
        
        
        // stop button
        Button stopB = new Button();
        stopB.setText("Stop");
        stopB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        
        // quit button
        Button quitB = new Button();
        quitB.setText("Quit");
        quitB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        
        
        
        // how to add buttons at set places ??
        VBox root = new VBox();
        root.getChildren().add(startB);
        root.getChildren().add(stopB);
        root.getChildren().add(quitB);
        root.getChildren().add(entry);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            Start, Quit and Stop button
            timeline
            textbox 
        
        */
        launch(args);
    }
    
}
