import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Arrays;

public class RandomizedQueue<Item> implements Iterable<Item>  {
    private Item[] arr;
    private int size;
    public RandomizedQueue() {
        arr = (Item[]) new Object[150];
        size = 0;
    }

    private void resize() {
        Item[] tempKeys = Arrays.copyOf(this.arr, this.arr.length * 2);
        this.arr = tempKeys;
    }

    public boolean isEmpty() {
        return size==0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item==null) throw new IllegalArgumentException();
        arr[size++] = item;
        if (size>=arr.length/2) { resize(); }
    }

    // remove and return a random item
    public Item dequeue() {
        if (size==0) throw new java.util.NoSuchElementException(); 
        int a = StdRandom.uniform(size);
        Item b = arr[a];  
        for (int j = a; j < size; j++) {
            arr[j] = arr[j+1];
        }
        arr[size]=null;
        size--;
        return b;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size==0) throw new java.util.NoSuchElementException(); 
        int u = StdRandom.uniform(size);
        return arr[u];  
    }
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }
    // return an independent iterator over items in random order
    private class RandomIterator implements Iterator<Item> {
        private int i;
        public boolean hasNext()  { return i < size; }
        public void remove()      { throw new UnsupportedOperationException();  }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item element = arr[i];
            i++;
            return element;
        }
    }
    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> a = new RandomizedQueue<Integer>();
        a.enqueue(896);
        a.enqueue(564);
        a.enqueue(326);
        a.dequeue();
        a.enqueue(751);
        //a.isEmpty();
        System.out.println(a.dequeue());
        
        // System.out.println(a.size());
        // System.out.println(a.isEmpty());
        // System.out.println(a.sample());
        // System.out.println(a.dequeue());
    }
}