import java.math.BigInteger;

/**
 * The type Red black tree.
 */
public class RedBlackTree {
    /**
     * The Root.
     */
    RedBlackNode root, /**
     * The Nil.
     */
    nil;
    /**
     * The Count.
     */
    int count;

    /**
     * Instantiates a new Red black tree.
     */
    public RedBlackTree() {
        //leaf node is black, is a null node
        nil = new RedBlackNode(null, 0, null, null, null);
        root = nil;
        count = 0;
    }

    /**
     * Insert.
     *
     * @param z1 the z 1
     */
//Pre-condition: memory is available for insertion
    public void insert(ResultType z1) {
        RedBlackNode z = new RedBlackNode(z1, -1, null, null, null);
        RedBlackNode y = nil;
        RedBlackNode x = root;
        while (x != nil) {
            y = x;
            //z - x < 0 lexicographically
            if (z1.compareTo(x.getData()) < 0) {
                x = x.getLc();
            } else {
                x = x.getRc();
            }
        }
        z.setP(y);

        if (y == nil) {
            root = z;
        } else {
            if (z1.compareTo(y.getData()) < 0) {
                y.setLc(z);
            } else {
                y.setRc(z);
            }
        }
        z.setLc(nil);
        z.setRc(nil);
        z.setColor(1);
        RBInsertFixup(z);
    }

    /**
     * Rb insert fixup.
     *
     * @param z the z
     */
//z is the new node
    public void RBInsertFixup(RedBlackNode z) {
        RedBlackNode y;
        //parent node is red as well
        while (z.getP().getColor() == 1) {
            if (z.getP() == z.getP().getP().getLc()) {
                y = z.getP().getP().getRc();
                if (y.getColor() == 1) {
                    z.getP().setColor(0);
                    y.setColor(0);
                    z.getP().getP().setColor(1);
                    z = z.getP().getP();
                } else {
                    if (z == z.getP().getRc()) {
                        z = z.getP();
                        leftRotate(z);
                    }
                    z.getP().setColor(0);
                    z.getP().getP().setColor(1);
                    rightRotate(z.getP().getP());
                }
            } else {
                y = z.getP().getP().getLc();
                if (y.getColor() == 1) {
                    z.getP().setColor(0);
                    y.setColor(0);
                    z.getP().getP().setColor(1);
                    z = z.getP().getP();
                } else {
                    if (z == z.getP().getLc()) {
                        z = z.getP();
                        rightRotate(z);
                    }
                    z.getP().setColor(0);
                    z.getP().getP().setColor(1);
                    leftRotate(z.getP().getP());
                } //end else
            } //end else
        } //end while
        root.setColor(0);
    }

    /**
     * Left rotate.
     *
     * @param x the x
     */
// x.getRC is not nil
    // root's parent is nil
    public void leftRotate(RedBlackNode x) {
        RedBlackNode y = x.getRc();
        x.setRc(y.getLc());
        y.getLc().setP(x);
        y.setP(x.getP());

        if (x.getP() == nil)
            root = y;
        else {
            if (x == x.getP().getLc())
                x.getP().setLc(y);
            else
                x.getP().setRc(y);
        }
        y.setLc(x);
        x.setP(y);
    }

    /**
     * Right rotate.
     *
     * @param x the x
     */
// x.getLC is not nil
    // root's parent is nil
    public void rightRotate(RedBlackNode x) {
        RedBlackNode y = x.getLc();
        x.setLc(y.getRc());
        y.getRc().setP(x);
        y.setP(x.getP());
        // if x is at root then y becomes new root
        if (x.getP() == nil)
            root = y;
        else {
            // if x is a left child then adjust x's parent's left child or...
            if (x == x.getP().getLc())
                x.getP().setLc(y);
            else
                // adjust x's parent's right child
                x.getP().setRc(y);
        }
        y.setRc(x);
        x.setP(y);
    }

    /**
     * Lookup big integer.
     *
     * @param v1 the v 1
     * @return the big integer
     */
//same as binary search tree
    public BigInteger lookup(String v1) {
        RedBlackNode search = root;
        ResultType v = new ResultType(v1, new BigInteger("0"));
        while (search != nil) {
            count++;
            if (search.getData().equals(v))
                return search.getData().value;
            else if (search.getData().compareTo(v) > 0)
                search = search.getLc();
            else
                search = search.getRc();
        }
        return null;
    }

    /**
     * Gets recent compares.
     *
     * @return the recent compares
     */
    public int getRecentCompares() {
//        int temp = count;
//        count = 0;
        return count;
    }

    /**
     * In order traversal.
     *
     * @param t the t
     */
//Perfrom an inorder traversal of the tree. The inOrderTraversal(RedBlackNode) method is recursive and displays the content of the tree. It makes calls on System.out.println(). This method would normally be private.
    public void inOrderTraversal(RedBlackNode t) {
        if (t.getLc() != nil)
            inOrderTraversal(t.getLc());
        System.out.println(t.getData());
        if (t.getRc() != nil)
            inOrderTraversal(t.getRc());
    }

    /**
     * In order traversal.
     */
//The no argument inOrderTraversal() method calls the recursive inOrderTraversal(RedBlackNode) - passing the root.
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * Max height helper int.
     *
     * @param t the t
     * @return the int
     */
    public int maxHeightHelper(RedBlackNode t) {
        if (t == nil)
            return 0;
        else
            return Math.max(maxHeightHelper(t.getLc()), maxHeightHelper(t.getRc())) + 1;
    }

    /**
     * Max height int.
     *
     * @return the int
     */
    public int maxHeight() {
        return maxHeightHelper(root);
    }

    /**
     * Min height helper int.
     *
     * @param t the t
     * @return the int
     */
//if a tree only has right subtree or left subtree
    public int minHeightHelper(RedBlackNode t) {
       if (t == nil) {
           return Integer.MAX_VALUE;
       }
       if (root.getLc() == nil && root.getRc() == nil) {
           return 1;
       }

        return Math.min(maxHeightHelper(t.getLc()), maxHeightHelper(t.getRc())) + 1;

    }

    /**
     * Min height int.
     *
     * @return the int
     */
    public int minHeight() {
        return minHeightHelper(root);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        for (int i = 1; i <= 1000; i++) {
            //add 1 to 1000 into the tree, key is String, value is BigInteger
            String key = String.valueOf(i);
            BigInteger value = new BigInteger(key);
            ResultType res = new ResultType(key, value);
            redBlackTree.insert(res);
        }
        //print the tree as in-order
        redBlackTree.inOrderTraversal();
        /*
         * When inserting 1000 nodes into the tree, 2 * lg(1000 + 1) is 19.91
         * In this case, the maximum height of this black red tree is 16, which is smaller than 19.91
         */
        System.out.println("Maximum height of this red black tree is: " + redBlackTree.maxHeight());
        System.out.println("Minimum height of this red black tree is: " + redBlackTree.minHeight());
        //test look up
        System.out.println("Find value of the node 8: " + redBlackTree.lookup("8"));
        System.out.println("Number of nodes passed to look up this node: " +redBlackTree.getRecentCompares());
    }
}
