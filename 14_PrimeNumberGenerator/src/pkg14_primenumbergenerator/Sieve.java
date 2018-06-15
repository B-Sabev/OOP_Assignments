package pkg14_primenumbergenerator;

/**
 *
 * @author Borislav Sabev s4726863
 */
public class Sieve implements Runnable{
    private final int prime;
    private Buffer<Integer> in, out;

    public Sieve(int prime, Buffer in, Buffer out) {
        this.prime = prime;
        this.in = in;
        this.out = out;
    }
    
    /**
     * Takes every element from the in buffer and
     * copies all elements not divisible by the prime
     */
    public void filter(){
        while(true){
            int num = in.get();
            if(num % prime != 0)
                out.put(num);
        }
        
    }

    @Override
    public void run() {
        filter();
    }
    
}
