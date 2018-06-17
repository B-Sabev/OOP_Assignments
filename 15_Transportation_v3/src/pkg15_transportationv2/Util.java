package pkg15_transportationv2;

/**
 * Utilities for taxi simulation:
 * - getRandomNumber: random number between bounds
 * 
 * @adapted from pieterkoopman
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
import java.util.Random;

public class Util {
  private static final Random generator = new Random();

  /**
   * Generates a random number between from and to
   * 
   * @param from lower limit
   * @param to   upper limit
   * @return random number between from and to
   */
  public static int getRandomNumber(int from, int to) {
    if (from == to) {
      return from;
    }
    else {
      return from + generator.nextInt(to - from);
    }
  }
  
  public static void threadWaitRandomTime(int from, int to){
      try {
            Thread.sleep(getRandomNumber(from, to));
      } catch (InterruptedException e) {} 
  }
}
