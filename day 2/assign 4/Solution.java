import java.util.Queue;
import java.util.LinkedList;
class Solution{
	public static String Josephus(final int a, final int b){
	String s = "";
	Queue<Integer> queue = new Queue();
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
