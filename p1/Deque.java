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
    }

    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tm = head;
        if (size==1) {
            tail=null;
            head=null;
            size--;
            return tm.element;
        }
        head = head.next;
        size--;
        return tm.element;
    }
     
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        if (size==1) {
            tail=null;
            head=null;
            size--;
            return tmp.element;
        }
        tail = tail.prev;
        size--;
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
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.removeFirst();
        System.out.println(deque.isEmpty());
    }

}

