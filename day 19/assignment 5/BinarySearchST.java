import java.util.Arrays;

/**.
 * This class describes a binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class BinarySearchST<Key extends Comparable<Key>,
    Value extends Comparable<Value>> {
    /**.
     * Stores the keys
     */
    private Key[] keys;

    /**.
     * Stores the values
     */
    private Value[] values;

    /**.
     * Keeps track of the size of the array
     */
    private int counter;

    /**.
     * Constructs a new instance.
     */
    BinarySearchST() {
        this.keys = (Key[]) new Comparable[2];
        this.values = (Value[]) new Comparable[2];
        this.counter = 0;
    }

    /**.
     * Constructs a new instance.
     *
     * @param      capacity  The capacity
     */
    BinarySearchST(final int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Comparable[capacity];
        this.counter = 0;
    }

    /**.
     * This method adds the element to the
     * symbol table
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        if (key == null) {
            return;
        }

        
        int index = rank(key);

        // If the array is empty
        if (counter == 0) {
            keys[counter] = key;
            values[counter] = value;
            counter++;
            return;
        }
        
        if (counter == keys.length) {
            resize();
        }

        if (keys[counter-1].compareTo(key) < 0) {
            //System.out.println("check");
            //System.out.println(value);
            //System.out.println(counter);
            values[counter] = value;
            keys[counter] = key;
            counter++;
            return;
        }

        // Check if the element is already present
        if (index < counter && keys[index].compareTo(key) == 0) {
            values[index] = value;
            return;
        }


        // Shifting the elements to the right
        // by one place to make a hole
        for (int i = counter; i > index; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[index] = key;
        values[index] = value;
        counter++;
    }

    /**.
     * Deletes the given key.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            return;
        }
        if (counter == 0) {
            return;
        }

        // Compute the rank to get the index
        int index = rank(key);

        // Check to see if element is not present
        if (keys[index].compareTo(key) != 0) {
            System.out.println("Key is not present in the data");
            return;
        }

        // Shifting the elements to the left by one
        // to replace the element at that index
        for (int i = index; i < counter - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        counter--;


    }

    /**.
     * Deletes the minimum element of the array
     */
    public void deleteMin() {
        if (counter == 0) {
            return;
        }
        delete(keys[0]);
    }

    /**.
    * This method checks if the
    * key is present in the key array
    * or not
    *
    * @param      key   The key
    *
    * @return     { True: if present False otherwise }
    */
    public boolean contains(final Key key) {
        if (counter == 0) {
            return false;
        }
        int index = rank(key);
        if (index < counter && keys[index].compareTo(key) == 0) {
            return true;
        }
        return false;
    }

    /**.
     * Gets the specified key.
     *
     * @param      key   The key
     *
     * @return     { returns the value of the  }
     */
    public Value get(final Key key) {
        if (counter == 0) {
            return null;
        }
        int index = rank(key);
        if (index < counter && keys[index].compareTo(key) == 0) {
            return values[index];
        }
        return null;
    }

    /**.
     * This method returns the max key
     *
     * @return     { returns the max key }
     */
    public Key max() {
        if (counter == 0) {
            return null;
        }
        return keys[counter - 1];
    }

    /**.
     * Largest key that is present which is
     * less than the key in the argument
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(final Key key) {
        if (counter == 0) {
            return null;
        }
        int index = rank(key);
        if (index < counter && keys[index].compareTo(key) == 0) {
            return keys[index];
        }
        return keys[index - 1];
    }

    /**.
     * This method returns all the keys
     *
     * @return     { returns the keys in a sorted order }
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < counter; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    /**.
     * This method returns the number of
     * keys in the symbol table tha
     *
     * @param      key   The key
     *
     * @return     { returns the rank of the key }
     */
    public int rank(final Key key) {
        int low = 0;
        int high = counter - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                high = mid - 1;
            } else if (key.compareTo(keys[mid]) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    /**.
     * This method gives us the size
     * of the data
     *
     * @return     { total size of the data }
     */
    public int size() {
        return counter;
    }

    /**
     * This method prints out the data.
     */
    public void displayData() {
        for (int i = 0; i < counter; i++) {
            System.out.println("Key: " + keys[i] + " Value: " + values[i]);
        }
    }

    /**.
     * This method doubles the size
     * of the arrays
     */
    private void resize() {
        Key[] tempKeys = Arrays.copyOf(
                             this.keys, this.keys.length * 2);
        Value[] tempValues = Arrays.copyOf(
                                 this.values, this.values.length * 2);
        this.keys = tempKeys;
        this.values = tempValues;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, Integer> symbolTable = new BinarySearchST<Integer, Integer>();
        symbolTable.put(5, 0);
        symbolTable.put(1, 1);
        symbolTable.put(10, 2);
        System.out.println(symbolTable.max());
    }
}