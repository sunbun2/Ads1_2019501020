import java.util.Random;
import java.util.Iterator;
import java.util.Arrays;
public class RandomizedQueue<Item> implements Iterable<Item>  {
    Item[] arr;
    int size;
    public RandomizedQueue() {
        arr = (Item[]) new Object[1000];
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
        Random rand = new Random();
        int a = rand.nextInt(size);
        Item b = arr[a];  
        for (int j=a;j<size;j++) {
            arr[j+1] = arr[j];
        }
        //resize();
        return b;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size==0) throw new java.util.NoSuchElementException(); 
        Random rand = new Random();
        int a = rand.nextInt(size);
        return arr[a];  
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
            if (!hasNext()) return null;
            Item element = arr[i];
            i++;
            return element;
        }
    }
    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> a = new RandomizedQueue();
        a.enqueue("hii");
        a.enqueue("hello");
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println(a.sample());
        System.out.println(a.dequeue());
    }
}