public class BinarySearchST<Key extends Comparable<Key>, Value> {
    int[] keys;
    String[] value;
    int point;
    BinarySearchST(){
        keys = new Keys[1000];
        value = new Value[1000];
        point=0;
    }
    public void put(Key k, Value v) {
        keys[point] = k;
        value[point] = v;
    }
    Value get(Key k) {
        if (keys == null) throw new IllegalArgumentException("calls get() with a null key");
        key = Keys[0];
        int cmp = k.compareTo(key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    boolean contains(Key k) {

    }

}