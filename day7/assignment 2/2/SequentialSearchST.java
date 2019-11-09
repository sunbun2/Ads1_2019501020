/**
 * . SequentialSearchST
 *
 * @param <K> generic type for key
 * @param <V> genetic type for value
 * @author Abhiram Rayala
 * @Credit Bob Sedgewick [Queue]
 */
public class SequentialSearchST<K extends Comparable<K>, V> {
    /**
     * . head node
     */
    public Node head;
    /**
     * . last node
     */
    public Node last;

    /**
     * . inner class
     *
     * @param <K> key generic type
     * @param <V> value
     */
    private class Node<K, V> {
        /**
         * . key of node
         */
        public K key;
        /**
         * . value of node
         */
        public V value;
        /**
         * . next of node
         */
        public Node<K, V> next;

        /**
         * . parametrised constructor
         *
         * @param key   key of node
         * @param value value of node
         */
        Node(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * . default constructor
     */
    SequentialSearchST() {
        head = null;
        last = null;
    }

    /**
     * . inserts the given key-value pair to the symbol table
     *
     * @param k key
     * @param v value
     */
    public void put(final K k, final V v) {
        if (head == null) {
            head = new Node(k, v);
            head.next = null;
            last = head;
        } else {
            if (!contains(k)) {
                Node oldFirst = head;
                head = new Node(k, v);
                head.next = oldFirst;
            } else {
                Node current = head;
                while (current != null) {
                    if (current.key.equals(k)) {
                        current.value = v;
                    }
                    current = current.next;
                }
            }
        }
    }

    /**
     * . get method fetches the corresponding value for the key
     *
     * @param k key
     * @return value if present, null if not
     */
    public V get(final K k) {
        // return value paired with Key.
        Node current = head;
        if (head.key.equals(k)) {
            V item = (V) head.value;
            head = head.next;
            return item;
        }
        while (current.next != null) {
            if (current.next.key.equals(k)) {
                V item = (V) current.next.value;
                Node hit = current.next;
                current.next = current.next.next;
                last.next = hit;
                last = last.next;
                last.next = null;
                return item;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * . contains checks for the element in the symbol table
     *
     * @param k key
     * @return true if present, false if not
     */
    public boolean contains(final K k) {
        Node current = head;
        while (current != null) {
            if (current.key.equals(k)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * . returns all the keys present
     *
     * @return iterable item
     */
    public Iterable<K> keys() {
        Queue<K> q = new Queue<K>();
        Node current = head;
        while (current != null) {
            q.enqueue((K) current.key);
            current = current.next;
        }
        return q;
    }
}
