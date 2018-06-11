
package ooTaxi;

/**
 * main Class: create a SImulation and execute it.
 * 
 * @author pieterkoopman
 */
public class OOTaxiMain {

  public static void main(String[] args) {
    Simulation simulation = new Simulation();
    while (! simulation.ended()) {
      simulation.step();
    }
    simulation.showStatistics();
  }
}
