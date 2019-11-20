// Referenece Bob Sedgewik

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    public class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 

    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
    public Key max() {
        return max(root).key;
    } 

    private Node max(Node x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    // This method takes node and min max keys as input.
    // We check whether min and max are equal to the min and max of the tree from node if not return false
    //
    private boolean isOrdered(Node n, Key min, Key max) {
        if (n == null) return true;
        if (max()!=max) return false;
        if (min()!=min) return false;
        if (min != null && n.key.compareTo(min) <= 0) return false;
        if (max != null && n.key.compareTo(max) >= 0) return false;
        return isOrdered(n.left, min, n.key) && isOrdered(n.right, n.key, max);
    } 

    // This method creates a node based on the key and value passed 
    // And the is ordered method is created using the node created.
    public boolean isOrdered(Key k,Value v,Key min,Key max){
        Node n = new Node(k, v, 0);
        boolean a = isOrdered(n, min, max);
        return a;
    }
    public static void main(String[] args) {
        BST<Integer,Integer> a = new BST();
        a.put(4,3);
        a.put(1,7);
        a.put(5, 10);
        System.out.println(a.isOrdered(4, 3, 1, 5));
    }
}


