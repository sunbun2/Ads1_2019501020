/**
 * LinearProbing
 * 
 * @param <K> generic type for keys
 * @param <V> generic type for values
 * @author Abhiram Rayala
 */
public class LinearProbing<K, V> {

    /**
     * bucket size
     */
    public int M;
    /**
     * array of keys
     */
    public K[] keys;
    /**
     * array of values
     */
    public V[] values;
    /**
     * count of keys present
     */
    public int numKeys;

    /**
     * default constructor
     */
    LinearProbing() {
        M = 15;
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
        numKeys = 0;
    }

    /**
     * parametrised constructor
     * 
     * @param capacity bucket size
     */
    LinearProbing(final int capacity) {
        M = capacity;
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
        numKeys = 0;
    }

    /**
     * generates the hash value for a key
     * 
     * @param key value
     * @return hash value
     */
    public int hash(final K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * resizes the hash table
     * 
     * @param reSize the bucket size it should be resized to
     */
    public void resize(final int reSize) {
        LinearProbing<K, V> temporary = new LinearProbing<K, V>(reSize);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temporary.put(keys[i], values[i]);
            }
        }
        keys = temporary.keys;
        values = temporary.values;
        M = reSize;
    }

    /**
     * inserts the key-value pair to the hash table
     * 
     * @param key   to be added
     * @param value to be added
     */
    public void put(final K key, final V value) {
        int i;
        if (numKeys >= 8 * M)
            resize(2 * M);

        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        numKeys++;
    }

    /**
     * fetches the value of the key passed
     * 
     * @param key to be checked
     * @return value of the key, null if not
     */
    public V get(final K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    /**
     * tells if the key is present or not
     * 
     * @param key to be checked
     * @return true if present, no if not
     */
    public boolean contains(final K key) {
        if (get(key) != null)
            return true;
        return false;
    }

    /**
     * deletes the key given and also rehashes the keys remaining until next
     * 
     * @param key to be deleted
     */
    public void delete(final K key) {
        int index = hash(key);
        while (true) {
            if (key.equals(keys[index])) {
                break;
            }
            index = (index + 1) % 10;
        }
        keys[index] = null;
        values[index] = null;
        numKeys--;
        for (index = (index + 1) % M; keys[index] != null; index = (index + 1) % 10) {
            K key1 = keys[index];
            V value1 = values[index];
            keys[index] = null;
            values[index] = null;
            numKeys--;
            put(key1, value1);
        }

        if (numKeys <= 2 * M)
            resize(M / 2);
    }

    /**
     * displays all the keys
     */
    public void display() {
        for (K k : keys) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (V v : values) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     * main method
     * 
     * @param args to be added in runtime
     */
    public static void main(String[] args) {
        LinearProbing<Integer, String> lp1 = new LinearProbing<Integer, String>(10);
        lp1.put(4, "A");
        lp1.put(2, "C");
        lp1.put(12, "I");
        lp1.put(13, "P");
        lp1.put(5, "P");
        lp1.put(1, "P");
        lp1.display();
        lp1.delete(13);
        lp1.display();
        System.out.println(lp1.get(12));

    }

}