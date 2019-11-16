import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.NoSuchElementException;
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> r = new RandomizedQueue();
        int a = Integer.parseInt(args[0]);
        try {
            for (int i = 0; i < a; i++) {
                    r.enqueue(StdIn.readString());
            }
            for (int j=0; j<a ;j++) {
                StdOut.println(r.dequeue());
            }
        }
        catch (NoSuchElementException e) {
        }
    }
 }