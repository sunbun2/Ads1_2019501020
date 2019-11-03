/**
 * Class for node.
 * @author     Abhiram Rayala
 */
class Node<T> {
	private T value;
	private Node next;

	/**
	 * Constructs a new instance.
	 */
	Node() {
		value = null;
		next = null;
	}

	/**
	 * Constructs a new instance.
	 *
	 * @param      value  The value
	 */
	Node(final T value) {
		this.value = value;
		next = null;
	}

	/**
	 * Constructs a new instance.
	 *
	 * @param      value  The value
	 * @param      next   The next
	 */
	Node(final T value , final Node next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * Sets the next.
	 *
	 * @param      node  The node
	 */
	void setNext(final Node node) {
		next = node;
	}

	/**
	 * Gets the next.
	 *
	 * @return     The next.
	 */
	Node getNext() {
		return next;
	}

	/**
	 * Gets the value.
	 *
	 * @return     The value.
	 */
	T getValue() {
		return value;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return "value 	" + value + "-> " + next.value ;
	}
}
