import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node tail;
    private int size;

    private class Node {
        Item element;
        Node next;
 
        public Node (Item element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
        Queue() {
            size = 0;
            tail = null; 
        }

        public void enqueue(Item a) {
            if (size == 0) {
                tail = new Node(a, null);
                tail.next = tail;
                size++;
                return;
            }
            Node n = new Node(a,tail.next);
            tail.next = n;
            tail = tail.next;
            size++;
        }

        public Item dequeue() {
            if (size == 0) throw new NoSuchElementException();
            if (size == 1) {
                Item i = tail.element;
                tail = null;
                return i;
            }
            Node i = tail.next;
            tail.next = tail.next.next;
            return i.element;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public static void main(String[] args) {
            Queue<String> a = new Queue();
            a.enqueue("Testing");
            a.enqueue("hii");
            a.enqueue("hello");
            a.enqueue("hamper");
            System.out.println(a.size());
            System.out.println(a.isEmpty());
            System.out.println(a.dequeue());
        }
}