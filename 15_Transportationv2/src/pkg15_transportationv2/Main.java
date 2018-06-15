package pkg15_transportationv2;

/**
 * main Class: create a Simulation and execute it.
 * 
 * @adapted from pieterkoopman
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Main {

    public static void main(String[] args) { 
        Simulation simulation = new Simulation();
        while (! simulation.ended()) {
            simulation.step();
        }
        simulation.showStatistics();
  }
}
