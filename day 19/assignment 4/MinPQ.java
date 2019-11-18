import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class MinPQ<Item> {
    private Item[] queue;
    private int size;
    private Comparator<Item> comparator;

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Item>) queue[i]).compareTo(queue[j]) > 0;
        }
        else {
            return comparator.compare(queue[i], queue[j]) > 0;
        }
    }


    public MinPQ (int c) {
        queue = (Item[]) new Object[c + 1];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Item min() {
        if (size == 0) throw new NoSuchElementException(" Queue Underflow ");
        return queue[1];
    }

    private void resize(int capacity) {
        assert capacity > size;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    public void insert(Item x) {
        if (size == queue.length - 1) resize(2 * queue.length);

        queue[++size] = x;
        swim(size);
    }

    public Item[] display() {
        return queue;
    }

    public Item delMin() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        Item min = queue[1];
        exch(1, size--);
        sink(1);
        queue[size+1] = null; 
        if ((size > 0) && (size == (queue.length - 1) / 4)) resize(queue.length / 2);
        return min;
    }

    private void exch(int i, int j) {
        Item swap = queue[i];
        queue[i] = queue[j];
        queue[j] = swap;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the total number of items");
        int n = s.nextInt();
        MinPQ<String> pq = new MinPQ(n);
        // This operation takes n*logn as it has n insert operations.
        for (int i = 0; i < n; i++) {
            String x = s.next();
            pq.insert(x);
        }

        System.out.println("Enter the number of max elements needed in queue");
        int y = s.nextInt();
        // This operation takes (n-k)*logn complexity.
        for (int j = 0;j < n-y; j++) {
            if (y>n) {
                System.out.println("Wrong entry try again");
                break;
            }
            System.out.println(pq.delMin());
        }
        s.close();
        System.out.println(Arrays.toString(pq.display()));
    }
}