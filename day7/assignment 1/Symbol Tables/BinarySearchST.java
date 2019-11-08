import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    public BinarySearchST() { 
        keys = (Key[]) new Comparable[1000]; 
        vals = (Value[]) new Object[1000]; 
    }   

    public int  rank(Key k) {
        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = k.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;                                                                                                                                                                                                                                                                                                                        
    }
    public void put(Key k, Value v) {
        if (v == null) {
            delete(k);
            return;
        }

        int i = rank(k);

        // key is already in table
        if (i < n && keys[i].compareTo(k) == 0) {
            vals[i] = v;
            return;
        }


        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = k;
        vals[i] = v;
        n++;
    }

    public Value get(Key k) {
        int i = rank(k);
        if (i < n && k.compareTo(keys[i]) == 0) return vals[i];
        else return null;
    }

    boolean contains(Key k) {
        return get(k) != null;
    }

    Key max() {
        return keys[n-1];
    }

    Key floor(Key k) {
        int i = rank(k);
        if (i < n && k.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

    public void delete(Key key) {
        if (n == 0) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

    } 

    public void deleteMin() {
        delete(min());
    }

    Key min() {
        return keys[0];
    }

    public Key[] keys() {
        if (isEmpty()) {
            return null;
        }
        return keys;
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += keys[i] + " ";
        }
        return str;
    }

}