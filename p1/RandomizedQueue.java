import java.util.Random;
//implements Iterable<Item>
public class RandomizedQueue<Item>  {
    Item[] arr;
    int size;
    public RandomizedQueue() {
        arr = (Item[]) new Object[1000];
        size=0;
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
        return b;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size==0) throw new java.util.NoSuchElementException(); 
        Random rand = new Random();
        int a = rand.nextInt(size);
        return arr[a];  
    }

    // return an independent iterator over items in random order
    // public Iterator<Item> iterator() {
    //     return arr;
    // }

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