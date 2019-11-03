/**
 * List of my linkedlists.
 * 
 * @author     Abhiram Rayala
 */
class Stack<T> {
    /**
     * Constructs an empty list with size initialized to zero.
     */

    int size;
    Node<T> head;

    public Stack() {
        size = 0;

    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param      data  The data
     */
    public void push(final T data) {
        if (head == null ) {
            head = new Node(data);
            size++;
            return;
        }
        // Node temp
        Node tempHead = new Node(data);
        tempHead.setNext(head);
        head = tempHead;
        size++;
    }

    /**
     * Pops the object.
     *
     * @return     String get the head value and removes it
     */
    public T pop() {
        if (size == 0) return null;
        T data = head.getValue();
        head = head.getNext();
        size--;
        return data;
    }

    /**
     * gives the top value
     *
     * @return     Head value
     */
    public T peek() {
        return head.getValue();
    }

    boolean isEmpty() {
        return size == 0 ? true : false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }


    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String out = "";
        if (size == 0 ) return "Stack is empty";
        else {
            Node temp = head;
            while (temp != null) {
                out += temp.getValue();
                temp = temp.getNext();
            }
        }
        return out;
    }


}
