package pkg15_transportation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The train brings a number of passengers to a station in the simulation.
 * 
 * @adapted from pieterkoopman
 * @author Austin s1016930
 */
//public class Train {
public class Train implements Runnable {
  private int nrOfPassengers;
  private final Station station;
  private int nrOfTrips = 0;
  
  private final Lock lock;
  private Condition trainFull, trainEmpty;
  
  //private final Train train;
  
  //From Simulation
  public static final int TRAIN_TRIPS       = 10;
  public static final int MIN_TRAVELLERS    = 60;
  public static final int MAX_TRAVELLERS    = 90;
  //
  
//  public Train() {
//      this.station = new Station();
//      train = new Train();
//  }
  
  public Train(Station station) {
    lock = new ReentrantLock();
    this.station = station;
    this.nrOfPassengers = 0;
    //train = new Train(station);
  }
  
  public void genTrains() {
    Train train = new Train(station);
    if (train.getNrOfTrips() < TRAIN_TRIPS) {
      train.loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
      train.unloadPassengers();
    }
    else {
        closeStation();
    }
  }

  /**
   * Populate this train with number nrOfPassengers
   *
   * @param number the number of passengers of this train
   */
  public void loadPassengers(int number) {
    //nrOfPassengers = number;
    lock.lock();
    try {
        nrOfPassengers = number;
    } finally {
        lock.unlock();
    }
  }

  /**
   * empties this train and augment the number of Passengers at the station with
   * this nrOfPassenegers
   */
  public void unloadPassengers() {
//    nrOfTrips += 1;
//    station.enterStation(nrOfPassengers);
    lock.lock();
    try {
        nrOfTrips += 1;
        station.enterStation(nrOfPassengers);
    } finally {
        lock.unlock();
    }
  }

  public void closeStation() {
//    station.close();
    lock.lock();
    try {
        station.close();
    } finally {
        lock.unlock();
    }
  }

  public int getNrOfTrips() {
    //return nrOfTrips;
    lock.lock();
    try{
       return nrOfTrips; 
    } finally {
        lock.unlock();
    }
  }

    @Override
    public void run() {
        //unloadPassengers();
        lock.lock();
        try {
           ExecutorService executor = Executors.newCachedThreadPool();
           executor.execute(this);
           Thread.sleep(1000);
           trainFull.await();
           executor.shutdown();
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
    }
}
