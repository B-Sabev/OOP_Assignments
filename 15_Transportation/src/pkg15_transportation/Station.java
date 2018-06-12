package pkg15_transportation;



/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 * 
 * @adapted from pieterkoopman
 * @author Austin s1016930
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    //private Taxi taxi;
//    private final Train train;
    private Station station;
    public static final int NR_OF_TAXIS  = 4;
    //private Taxi[] taxis;
    
    //private boolean hasEnded = false;
//    
//    public Station(int nrOfPassengersAtStation, int totalNrOfPassengers, boolean isClosed) {
//        this.nrOfPassengersAtStation = nrOfPassengersAtStation;
//        this.totalNrOfPassengers = totalNrOfPassengers;
//        this.isClosed = false;
//        //station = new Station(0, 0, false);
//        train = new Train(station);
//    }
    
    public void enterStation(int nrOfPassengers) {
        //getWaitingPassengers();
        station = new Station();
        //taxi = new Taxi(1, 7, 3, station);
        //taxis = new Taxi[NR_OF_TAXIS];
        nrOfPassengersAtStation += nrOfPassengers;
        totalNrOfPassengers += nrOfPassengers;
        System.out.println(nrOfPassengers + " passengers arrived at station");
    }
    
    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) {
      if ( nrOfPassengers <= nrOfPassengersAtStation )
        nrOfPassengersAtStation -= nrOfPassengers;
      else
        System.out.println( "leaveStation(" + nrOfPassengers + ") there are only "
            + nrOfPassengersAtStation + " passengers at the station." );
    }

    public int getWaitingPassengers() {
        return nrOfPassengersAtStation;
        //return totalNrOfPassengers;
    }
    
    public void close() {
        isClosed = true;
        //hasEnded = true;    ///////////////
    }
    
    public boolean isClosed() {
        return isClosed;     
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }
}
