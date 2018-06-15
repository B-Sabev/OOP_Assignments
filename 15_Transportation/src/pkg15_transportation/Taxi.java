package pkg15_transportation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Taxi for the Simulation.
 * It takes passengers from the station and keeps basic historical data.
 * 
 * @adapted from pieterkoopman
 * @author Austin s1016930
 */
//public class Taxi {
public class Taxi implements Runnable {

    private final int taxiId;
    private final int maxNrOfPassengers;
    private final int transportationTime;
    private final Station station;
    
    //From Simulation
    public static final int CAPACITY_SMALL    = 4;
    public static final int CAPACITY_LARGE    = 7;
    public static final int TIME_SMALL        = 2;
    public static final int TIME_LARGE        = 3;
    public static final int NR_OF_TAXIS       = 4;
    public static final int NR_OF_SMALL_TAXIS = 2;
    //
    
    private int totalNrOfPassengers = 0;
    private int nrOfRides = 0;
    private int nextTaxi = 0;
    
    private Lock lock;
    private Condition taxiFull, taxiEmpty;
    
    private final Taxi[] taxis;
    //private Taxi taxi;
  
    public Taxi(int nr, int maxNumberOfPassengers, int transportationTime, Station station) {
        this.taxiId = nr;
        this.maxNrOfPassengers = maxNumberOfPassengers;
        this.transportationTime = transportationTime;
        this.station = station;
        lock = new ReentrantLock();
        taxis = new Taxi[NR_OF_TAXIS];
//        for (int i = 0; i < NR_OF_TAXIS; i++) {
//            taxis[i] = i < NR_OF_SMALL_TAXIS ?
//                    new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station) : 
//                    new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
//        }
        //genTaxis();
        //System.out.println("Taxi " + nr + " created");
    }
    

    public void genTaxis() {
        Station station = new Station();
        for (int i = 0; i < NR_OF_TAXIS; i++) {
            taxis[i] = i < NR_OF_SMALL_TAXIS ?
                    new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station) : 
                    new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
            System.out.println("Taxi " + (i+1) + " created");
        }
        station.enterStation(75);
        if (station.getWaitingPassengers() > 0) {
            taxis[nextTaxi].takePassengers();
            nextTaxi = (nextTaxi + 1) % NR_OF_TAXIS;
        }
        //station.enterStation(75);
        takePassengers();
    }
    
    /**
     * Try to take the maximum number of passengers from the station. 
     * If actual number op passengers is less then that number is taken
     * When there are no passengers the taxi just waits a little
     */
    public void takePassengers() {
        //Station.enterStation(5);
        int passengersWaiting = station.getWaitingPassengers();
        if ( passengersWaiting > 0 ) {
            int nrOfPassengers = Math.min(passengersWaiting, maxNrOfPassengers);
            station.leaveStation(nrOfPassengers);
            totalNrOfPassengers += nrOfPassengers;
            nrOfRides++;
            System.out.println("Taxi " + taxiId + " takes " + nrOfPassengers + " passengers");
        } else {  
            System.out.println("There are no passengers for taxi " + taxiId);  
        }
    }
    /**
     * Calculates the total time of this taxi by multiplying the number of rides by the transportation time
     * @return total time
     */
    public int getTotalTransportationTime() {
        return transportationTime * nrOfRides;
    }
    

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }
    
    public void showStatistics() {
        System.out.println("All persons have been transported");
        System.out.println("Total transport time in this simulation:" + getTotalTime(taxis));
        System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
        System.out.println("Total number of persons transported in this simulation: " + getTotalNrOfPassengers(taxis));
    }
      
    private static int getTotalTime(Taxi[] taxis) {
    int time = 0;
    for (Taxi taxi : taxis) {
      time += taxi.getTotalTransportationTime();
    }
    return time;
    }
    
    private static int getTotalNrOfPassengers(Taxi[] taxis) {
    int total = 0;
    for (Taxi taxi : taxis) {
      total += taxi.getTotalNrOfPassengers();
    }
    return total;
    }

    @Override
    public void run() {
        lock.lock();
        try {
           ExecutorService executor = Executors.newCachedThreadPool();
           executor.execute(this);
           Thread.sleep(1000);
           taxiFull.await();
           //executor.awaitTermination( 500, TimeUnit.MILLISECONDS );
           executor.shutdown();
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
    }
}
