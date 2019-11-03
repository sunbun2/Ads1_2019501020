import java.util.Queue;
import java.util.LinkedList;
/**
 * This class is used to implement the game.
 * @author Abhiram Rayala
 */

class Solution{
	private Solution() {
	}
	/**
	 * This method returns a string in the order of dequeue of the elements.
	 * @param a the number of inputs starting from 0.
	 * @param b the value at which the dequeue should be done
	 * @return string yes or no.
	 */
	public static String Josephus(final int a, final int b){
	String s = "";
	Queue<Integer> queue = new LinkedList<>();
	for (int t = 0; t < a; t++) {
	    queue.add(t);
	}
	// System.out.println(queue);
    // int l = queue.size();
	while (queue.size() > 1) {
	    for (int k = 0; k < b-1; k++) {
	        int a1 = queue.remove();
	        queue.add(a1);
	    }
	    s = s + queue.remove() + " ";
	}
	s = s + queue.remove();
	// System.out.println(s);
	return s;
	}
}
