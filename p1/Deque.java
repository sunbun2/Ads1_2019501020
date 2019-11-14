import java.util.Iterator;
import java.util.NoSuchElementException;




public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;
     
    public Deque() {
        size = 0;
    }

    private class Node {
        Item element;
        Node next;
        Node prev;
 
        public Node(Item element, Node next, Node prev) {
            this.element = element;
            this.next = next;
              this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item element) {
        if (element==null) throw new IllegalArgumentException();
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
        System.out.println("adding: "+element);
    }
     
    /**
     * adds element at the end of the linked list
     * @param element
     */
    public void addLast(Item element) {
        if (element==null) throw new IllegalArgumentException();
        Node tmp = new Node(element, null, tail);
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        System.out.println("adding: "+element);
    }

    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        //head.prev = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }
     
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        //tail.next = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }


    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = head;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.element;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> b = new Deque();
        b.addFirst("hii");
        b.addLast("hello");
        b.removeLast();
        System.out.println(b.isEmpty());
        System.out.println(b.size());
        b.removeFirst();
        //System.out.println( b.removeLast());
    }

}
