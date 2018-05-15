package pkg11_kitchentimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class View{
    
    private Stage primaryStage;
    private Controller controller;

    public View(Stage primaryStage) {
        controller = new Controller();
        this.primaryStage = primaryStage;
    }
    
    public void fillStage(){
        
        TextField entry = new TextField();
        
        entry.focusedProperty().addListener((arg0, oldValue, newValue) -> {
        if (!newValue) { //when focus lost
            controller.readTextField(entry.getText());
        }

    });
        /*
        StringProperty s = new SimpleStringProperty(entry.getText());
        StringProperty textVal = new SimpleStringProperty("");
        textVal.bind(s);
       */
        // start button
        Button startB = new Button();
        startB.setText("Start");
        startB.setOnAction(new Controller.startButtonEvent());
        
        
        // stop button
        Button stopB = new Button();
        stopB.setText("Stop");
        stopB.setOnAction(new Controller.stopButtonEvent());
        
        // quit button
        Button quitB = new Button();
        quitB.setText("Quit");
        quitB.setOnAction(new Controller.quitButtonEvent());
        
        // Add everything to the main scene
        VBox root = new VBox();
        root.getChildren().add(startB);
        root.getChildren().add(stopB);
        root.getChildren().add(quitB);
        root.getChildren().add(entry);
        root.getChildren().add(controller.getTimebar());
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Time Flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
