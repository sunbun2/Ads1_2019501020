import java.util.*;

public class BST<Key extends Comparable<Key>,
Value extends Comparable<Value>> {
	/**.
	 * This is the root node
	 * of the tree
	 */
	private Node root;

	/**
	 * This class describes a node
	 */
	private class Node {
		/**.
		 * Stores the key
		 */
		private Key key;

		/**.
		 * Stores the value
		 */
		private Value value;

		/**.
		 * Holds the reference to
		 * the left part
		 */
		private Node left;

		/**.
		 * Holds the reference to the
		 * right part
		 */
		private Node right;

		/**.
		 * holds the size of the node
		 * Leftnodes + rightNode + itself
		 */
		private int counter;

		/**.
		 * Constructs a new instance.
		 *
		 * @param      key    The key
		 * @param      value  The value
		 */
		Node(final Key key, final Value value) {
			this.key = key;
			this.value = value;
			this.counter = 0;
			this.left = null;
			this.right = null;
		}

		/**.
		 * Constructs a new instance.
		 *
		 * @param      key    The key
		 * @param      value  The value
		 * @param      size   The size
		 */
		Node(final Key key, final Value value, final int counter) {
			this.key = key;
			this.value = value;
			this.counter = counter;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * Constructs a new instance.
	 */
	public BST() {
		this.root = null;
	}

	/**.
	 * This method returns the size of the
	 * total BST
	 *
	 * @return     { returns the size }
	 */
	public int size() {
		int count = size(root);
		return count;
	}

	/**.
	 * This method is a helper method
	 * gives the size of the node that
	 * is passed as an argument.
	 *
	 * @param      node  The node
	 *
	 * @return     { size of the passed node }
	 */
	private int size(final Node node) {
		if (node == null) {
			return 0;
		}
		return node.counter;
	}

	/**.
	 * This method add the data to the
	 * BST.
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	public void put(final Key key, final Value value) {
		if (key == null) {
			return;
		}
		root = put(root, key, value);
	}

	/**.
	 * This is a helper method
	 * that implements the insertion into
	 * the BST using recursion.
	 *
	 * @param      node   The node
	 * @param      key    The key
	 * @param      value  The value
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Node put(final Node node, final Key key, final Value value) {
		// if the BST is empty
		if (node == null) {
			Node newNode = new Node(key, value, 1);
			return newNode;
		}

		// Compare the key to the current node
		int compValue = key.compareTo(node.key);

		// if key is less than the given node
		// traverse left. To the right if the
		// given node is greater than current node.
		// Hit if it's equal then replace it's value.
		if (compValue < 0) {
			node.left = put(node.left, key, value);
		} else if (compValue > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		node.counter = 1 + size(node.left) + size(node.right);
		return node;
	}

	/**.
	 * This method implements the
	 * non recurive version of the 
	 * insert method
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	public void myPut(final Key key, final Value value) {
		// if the BST is empty
		if (root == null) {
			Node newNode = new Node(key, value, 1);
			root = newNode;
			return;
		}
		Node current = root;
		Node previous = null;
		boolean foundFlag = false;

		// traverse through the BST 
		// while maintaining the links
		// to current node and the previous node
		while (current != null) {
			previous = current;
			int compValue = key.compareTo(current.key);
			if (compValue < 0) {
				// if the key is less than the current node
				current = current.left;
			} else if (compValue > 0) {
				// if the key is greater than the current node
				current = current.right;
			} else {
				// it's a match 
				current.value = value;
				foundFlag = true;
				break;
			}
		}

		// if the element already exists our 
		// job is done we can exit 
		if (foundFlag) {
			return;
		}		
		// creating a new node // update the counter later
		Node newNode = new Node(key, value, 1);

		// if the key is less the previous node
		if (key.compareTo(previous.key) < 0) {
			previous.left = newNode;
		} else if (key.compareTo(previous.key) > 0) {
			previous.right = newNode;
		}

		// updaing the counter of the of the previous node
		previous.counter = 1 + size(previous.left) + size(previous.right);
	}

	/**.
	 * Deletes the object.
	 */
	public void delete(final Key key) {
		if (key == null) {
			return;
		}
		root = delete(root, key);
	}

	/**.
	 * This method is a helper 
	 * method that deletes the node
	 * in BST.
	 *
	 * @param      node  The node
	 * @param      key   The key
	 *
	 * @return     { returns Node }
	 */
	private Node delete(final Node node, final Key key) {
		if (node == null) {
			return null;
		}
		// Compare the elements 
		int compValue = key.compareTo(node.key);
		if (compValue < 0) {
			// current key is less than the 
			// key at the node recurse down 
			// the tree to the left
			node.left = delete(node.left, key);
		} else if (compValue > 0) {
			// Current key is greated than the 
			// key at the node recurse down the
			// tree to the right
			node.right = delete(node.right, key);
		} else {
			// it's a match
			// nodes with one child
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			node.key = min(node.right);
			node.right = delete(node.right, node.key);
		}
		return node;
	}

	/**.
	 * This method deletes the minimum element
	 */
	public void deleteMin() {
		root = deleteMin(root);
		return;
	}

	/**.
	 * Deletes the minimum node in that
	 * sub tree
	 *
	 * @param      node  The node
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Node deleteMin(final Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.counter = size(node.left) + size(node.right) + 1;
		return node;
	}

	/**.
	 * deletes the maximum node
	 */
	public void deleteMax() {
		root = deleteMax(root);
		return;
	}

	/**.
	 * Helper method to delete the node
	 *
	 * @param      node  The node
	 *
	 * @return     { returns the updated subtree }
	 */
	private Node deleteMax(final Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.counter = size(node.left) + size(node.right) + 1;
		return node;
	}

	/**.
	 * This is a helper method that returns
	 * the minimum node in that part of the 
	 * sub tree
	 *
	 * @param      node  The node
	 *
	 * @return     { min node in that sub tree }
	 */
	private Key min(final Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current.key;
	}


	/**.
	 * Gets the value associated with
	 * the specified key
	 *
	 * @param      key   The key
	 *
	 * @return     { gets the value associated with key }
	 */
	public Value get(final Key key) {
		if (key == null) {
			return null;
		}
		Value result = get(root, key);
		return result;
	}

	/**.
	 * This method is a helper methods
	 * that traverses through the tree
	 * to find the key.
	 *
	 * @param      node  The node
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Value get(final Node node, final Key key) {
		Value result = null;
		if (node != null) {
			int compValue = key.compareTo(node.key);
			if (compValue < 0) {
				result = get(node.left, key);
			} else if (compValue > 0) {
				result = get(node.right, key);
			} else {
				result = node.value;
				return result;
			}
		}
		return result;
	}

	/**.
	 * This method returns the minimum
	 * key in BST
	 *
	 * @return     { Minimum key }
	 */
	public Key min() {
		Node current = root;
		if (current == null) {
			return null;
		}
		while (current.left != null) {
			current = current.left;
		}
		return current.key;
	}

	/**.
	 * This method returns the max
	 * key in BST
	 *
	 * @return     { Maximum key }
	 */
	public Key max() {
		Node current = root;
		if (current == null) {
			return null;
		}
		while (current.right != null) {
			current = current.right;
		}
		return current.key;
	}

	/**.
	 * This method returns the key
	 * less than or equals to the
	 * key in the argument
	 *
	 * @param      key   The key
	 *
	 * @return     { keys <= given key }
	 */
	public Key floor(final Key key) {
		if (key == null || size() == 0) {
			return null;
		}
		Node result = floor(root, key);
		if (result == null) {
			return null;
		}
		return result.key;
	}

	/**.
	 * This method is a helper method
	 * to compute the floor of the node.
	 *
	 * @param      node  The node
	 * @param      key   The key
	 *
	 * @return     { floor of the node }
	 */
	private Node floor(final Node node, final Key key) {
		if (node == null) {
			return null;
		}
		int compValue = key.compareTo(node.key);
		if (compValue == 0) {
			return node;
		} else if (compValue < 0) {
			return floor(node.left, key);
		} else {
			Node temp = floor(node.right, key);
			if (temp != null) {
				return temp;
			} else {
				return node;
			}
		}
	}

	/**.
	 * This method computes the 
	 * ceiling of the key provided
	 *
	 * @param      key   The key
	 *
	 * @return     { returns keys >= key }
	 */
	public Key ceiling(final Key key) {
		if (key == null) {
			return null;
		}
		Node result = ceiling(root, key);
		if (result == null) {
			return null;
		}
		return result.key;
	}

	/**.
	 * This is helper method to compute the 
	 * ceiling
	 *
	 * @param      node  The node
	 * @param      key   The key
	 *
	 * @return     { returns keys >= key }
	 */
	private Node ceiling(final Node node, final Key key) {
		// base case
		if (node == null) {
			return null;
		}
		int compValue = key.compareTo(node.key);
		if (compValue == 0) {
			return node;
		} else if (compValue < 0) {
			Node temp = ceiling(node.left, key);
			if (temp != null) {
				return temp;
			} else {
				return node;
			}
		} else {
			return ceiling(node.right, key);
		}
	}

	/**
	 * This method gives the indexth smallest key
	 *
	 * @param      index  The index
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Key select(final int index) {
		if (index < 0 || index > size()) {
			return null;
		}
		Node node = select(root, index);
		if (node == null) {
			return null;
		}
		return node.key;
	}

	/**.
	 * This is the helper method for select
	 *
	 * @param      node   The node
	 * @param      index  The index
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Node select(final Node node, final int index) {
		if (node == null) {
			return null;
		}
		int temp = size(node.left);
		if (temp > index) {
			return select(node.left, index);
		} else if (temp < index) {
			return select(node.right, index - temp - 1);
		} else {
			return node;
		}
	}

	/**.
	 * This method computes the rank of the 
	 * given key
	 *
	 * @param      key   The key
	 *
	 * @return     { count of keys less than the key }
	 */
	public int rank(final Key key) {
		int rank = 0;
		Node current = root;
		while (current != null) {
			int compValue = key.compareTo(current.key);
			if (compValue < 0) {
				current = current.left;
			} else if (compValue > 0) {
				// 1 - itself && size(current.left) - count of 
				// left subtree
				rank += 1 + size(current.left);
				current = current.right;
			} else if (compValue == 0) {
				rank += size(current.left);
			}
		}
		return rank;
	}

	/**.
	 * This method returns a queue with
	 * the data in BST
	 *
	 * @return     { returns a queue }
	 */
	public Iterable<Key> displayData() {
		Queue<Key> queue = new Queue<Key>();
		inorder(root, queue);
		return queue;
	}

	/**.
	 * This method implements the
	 * inorder traversal to get the
	 * elements from the data.
	 *
	 * @param      node   The node
	 * @param      queue  The queue
	 */
	private void inorder(final Node node, final Queue queue) {
		if (node == null) {
			return;
		}
		inorder(node.left, queue);
		queue.enqueue(node.key);
		inorder(node.right, queue);
	}

	// public static void main(String[] args) {
	// 	BST<Integer, String> bst = new BST<Integer, String>();
	// 	bst.put(10, "Hey");
	// 	bst.put(1, "Now");
	// 	bst.put(15, "Brown");
	// 	bst.put(3, "cow");
	// 	bst.put(2, "yo");
	// 	bst.put(2, "tuna");
	// 	System.out.println(bst.displayData().toString());
	// 	System.out.println(bst.rank(1));
	// }
}
