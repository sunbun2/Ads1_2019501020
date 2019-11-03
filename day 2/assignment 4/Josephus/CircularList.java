/**
 * List of my linkedlists.
 *
 * @author     srujan
 */
class CircularList {
	/**
	 * Constructs an empty list with size initialized to zero.
	 */

	int size;
	Node head;

	public CircularList() {
		// head = new Node();
		size = 0;

	}
	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param      data  The data
	 */
	public void add(final String data) {
		if (head == null ) {
			head = new Node(data);
			head.setNext(head);
			size++;
			return;
		}
		Node tempHead = head;
		while (tempHead.getNext() != head) {
			tempHead = tempHead.getNext();
		}
		tempHead.setNext(new Node(data, head));
		size++;
	}

	/**
	 * Removes a step.
	 *
	 * @param      step  The step
	 *
	 * @return     String vlaues of the elemetts
	 */
	public String removeStep(final int step) {
		Node temp = head;
		String str = "";
		int i = 1;
		while (temp.getNext() != temp) {
			if (i == step - 1) {
				i = 0;
				str += temp.getNext().getValue() + " ";
				temp.setNext(temp.getNext().getNext());
			} else {
				temp = temp.getNext();
				i++;
			}
		}
		str += temp.getValue();
		// System.out.println(str);
		return str;
	}


	/**
	 * Removes the specified index.
	 *
	 * @param      index  The index
	 *
	 * @return     removes the element in index and returns string
	 *
	 */
	public String remove(int index) {
		index = index % size;
		Node temp = head;
		if (index == 0) {
			String data = head.getValue();
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			head = head.getNext();
			temp.setNext(head);
			size--;
			return data;
		}
		for (int i = 1 ; i <= index - 1; i++) {
			temp = temp.getNext();
		}
		String data = temp.getNext().getValue();
		temp.setNext(temp.getNext().getNext());
		size--;
		return data;
	}


	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		Node temp = head;
		String out = head.getValue();
		while (temp.getNext() != head) {
			temp = temp.getNext();
			out += "  " + temp.getValue();
		}
		return out;
	}


	/**
	 * size
	 *
	 * @return     size of list
	 */
	public int size() {
		return size;
	}

	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

}
