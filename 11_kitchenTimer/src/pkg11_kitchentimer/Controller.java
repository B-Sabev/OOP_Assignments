package pkg11_kitchentimer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Controller implements EventHandler<ActionEvent>{
    
    private static Timeline timeline;
    private static ProgressBar timebar;
    private int totalTime;
    private int ellapsedTime;
    
    public Controller(){
        timebar = new ProgressBar(1.0);
        timeline = new Timeline( new KeyFrame( Duration.seconds(1), this::handle));
        timeline.setCycleCount( Timeline.INDEFINITE );
        totalTime = 1;
        ellapsedTime = 0;
    }

    public ProgressBar getTimebar() {
        return timebar;
    }
    
    
    
    @Override
    public void handle(ActionEvent event) {
        double progressPassed = (1. / ((double) totalTime));
        System.out.println("Set progress bar");
        timebar.setProgress(timebar.getProgress() - progressPassed);
        
        ellapsedTime++;
        if(ellapsedTime == totalTime){
            System.out.print("Time ran out");
            ellapsedTime = 0; // reset ellapsed
            timeline.pause();
            timebar.setProgress(0.0);
            
            // set the background to RED
            
            
            
        }
            
      
        
        
    }
    /*
    Parse a text for the TextField in View
    the entry must be int > 0
    */
    public void readTextField(String text) {
        try{
            Integer value1 = Integer.valueOf(text);
            if(value1 > 0){
               totalTime = value1;
            } else {
                
                Alert alert = new Alert(Alert.AlertType.ERROR, 
                                        "Enter integer time in seconds");
                alert.showAndWait().filter(response -> response == ButtonType.OK); 
               
            }
        }catch(Exception e){
           
            Alert alert = new Alert(Alert.AlertType.ERROR, 
                                        "Please enter a valid number in the text field before pressing start");
            alert.showAndWait().filter(response -> response == ButtonType.OK);
            
        }
    }
  
    /**
     * Try to read integer value from the text field,
     * if error is thrown, output an error message
     */
    public static class startButtonEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            if(timebar.getProgress() == 0.0)
                timebar.setProgress(1.0);
            timeline.play();
        }
    }
    
    /**
     * Stops the time line bar
     */
    public static class stopButtonEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
                timeline.pause();
                System.out.println("STOP");
            }
    }

    /**
     * Quit the program
     */
    public static class quitButtonEvent implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
                System.exit(0);
        }
    }
}
