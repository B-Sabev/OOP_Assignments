package pkg15_transportation;

/**
 * main Class: create a Simulation and execute it.
 * 
 * @adapted from pieterkoopman
 * @author Austin s1016930
 */
public class Main {

  public static void main(String[] args) {
      Station station = new Station();
      //while (! station.isClosed()) {      
      Train train = new Train(station);
      Taxi taxi = new Taxi(1, 7, 3, station);
      taxi.genTaxis();
      train.genTrains();
      taxi.showStatistics();
      //}
      
      
      //station.enterStation(75);
      //taxi.takePassengers();
      

      
  }
}
