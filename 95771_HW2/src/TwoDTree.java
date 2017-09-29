import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Two d tree.
 */
public class TwoDTree {
    /**
     * The Root.
     */
// Root of BST
    Node root;
    /**
     * The Size.
     */
    int size;
    /**
     * The Range search count. How many nodes are examined by range search function
     */
    int rangeSearchCount;

    /**
     * Instantiates a new Two d tree.
     */
// Constructor
    public TwoDTree() {
        root = null;
        size = 0;
        rangeSearchCount = 0;
    }

    /**
     * Insert.
     *  pre-condition: The tree has been constructed
     *  post-condition: A crime record is added into the tree as a tree node and the size of the tree plus one
     * @param key   the key
     * @param value the value
     */
    public void insert(double[] key, String value) {
        size++;
        root = insertHelper(root, key, 0, value);
    }


    /**
     * Insert helper node.
     *  pre-condition: The tree has been constructed
     *  post-condition: A crime record is added into the tree along with the current tree, return the root of the current tree
     * @param root  the root
     * @param key   the key
     * @param depth the depth
     * @param value the value
     * @return the node
     */
    public Node insertHelper(Node root, double[] key, int depth, String value) {
		// If the tree is empty, create a new node and set it as the root
        if (root == null) {
            root = new Node(key, depth % 2, value);
            return root;
        }
        //cd is the current dimension, deciding compare x or y
        int cd = depth % 2;
        if (key[cd] < root.key[cd]) {
            //go down and left to add this record
            root.left = insertHelper(root.left, key, depth + 1, value);
        }
        else {
            // go right or top to add this record
            root.right = insertHelper(root.right, key, depth + 1, value);
        }
        return root;
    }

    /**
     * Pre order print.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: Call the pre-order helper function to recursively display the tree in pre order.
     * Best case: Theta(nlogn) when the tree is a complete binary tree
     * Worse case: Theta(n*2) when each node of the tree only has left or right node
     */
// This method mainly calls InorderRec()
    public void preOrderPrint() {
        preorderHelper(root);
    }

    /**
     * Preorder helper.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: recursively display the tree in pre order
     * @param root the root
     */
// A utility function to do inorder traversal of BST
    public void preorderHelper(Node root) {
        //base case
        if (root == null) {
            return;
        }
        System.out.println(root.toString());
        //go to left sub tree
        preorderHelper(root.left);
        //go to right sub tree
        preorderHelper(root.right);
    }

    /**
     * In order print.
     *pre-condition: The 2d tree has been constructed.
     *post-condition: The 2d tree is displayed with a pre-order traversal.
     */
    public void inOrderPrint() {
        inorderHelper(root);
    }

    /**
     * Inorder helper.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: recursively display the tree in in order
     * @param root the root
     */
    public void inorderHelper(Node root) {
        if (root == null) {
            return;
        }
        preorderHelper(root.left);
        System.out.println(root.toString());
        preorderHelper(root.right);
    }

    /**
     * Post order print.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: The 2d tree is displayed with a post-order traversal by calling helper function
     */
// This method mainly calls InorderRec()
    public void postOrderPrint() {
        postOrderHelper(root);
    }

    /**
     * Post order helper.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: The 2d tree is displayed with a post-order traversal recursively
     * @param root the root
     */
// A utility function to do inorder traversal of BST
    public void postOrderHelper(Node root) {
        if (root == null) {
            return;
        }
        preorderHelper(root.left);
        preorderHelper(root.right);
        System.out.println(root.toString());
    }

    /**
     * Levelorder print.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: The 2d tree is displayed with a level-order traversal by calling helper function
     * Time Compeixity is Theta(N) N is the number of nodes, each node is visited 1-3 times (one for leaf
     * , three for non-leaf node) and each push pop is O(1).
     */
    public void levelorderPrint() {
        levelorderHelper(root);
    }

    /**
     * Levelorder helper.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: The 2d tree is displayed with a level-order traversal by using a queue
     * @param root the root
     */
    public void levelorderHelper(Node root) {
        if (root == null) {
            System.out.println("Level order error");
            return;
        }
        Queue_New queue = new Queue_New();
        //Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //in the for loop, go through all the node in this level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                System.out.println(cur.toString());
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

    /**
     * Reverse level order print.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: The 2d tree is displayed with a reverse level-order traversal
     */
    public void reverseLevelOrderPrint() {
        reverseLevelOrderHelper(root);
    }

    /**
     * Reverse level order helper.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: The 2d tree is displayed with a reverse level-order traversal by using a stack and a queue
     * @param root the root
     */
    public void reverseLevelOrderHelper(Node root) {
        //use a stack to print tree in reverse sequence
        if (root == null) {
            System.out.println("Level order error");
            return;
        }
        //implement it by self later
        Queue_New queue = new Queue_New();
        Stack_New stack = new Stack_New();
        //Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                stack.push(cur);
                //System.out.println(cur.toString());
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().toString());
        }
    }


    /**
     * Find points in range list of crimes.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: return a list containing all the nodes lie in the certain range
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     * @return the list of crimes
     */
    public ListOfCrimes findPointsInRange(double x1, double y1, double x2, double y2) {
        ListOfCrimes result = new ListOfCrimes();
        rangeHelper(root, new Rectangle(x1,x2,y1,y2), result);
        return  result;
    }

    /**
     * Range helper.
     * pre-condition: The 2d tree has been constructed.
     * post-condition: add all the nodes lie in the certain range into the result list
     * @param root   the root
     * @param range  the range
     * @param result the result
     */
    public void rangeHelper(Node root, Rectangle range, ListOfCrimes result) {
        //System.out.println("Current: " + root);
        if (root == null) {
            return;
        }
        rangeSearchCount++;

        //if the current node intersect with range
        if (root.ifIntersectRec(range)) {
            if(range.ifContains(root)) {
                //add into result list
                result.add(root);
            }
            //then go to both side
            rangeHelper(root.left, range, result);
            rangeHelper(root.right, range, result);

        } else {
        //if the node is the in the right or left side of the range (without intersect)
            //node is in the right side of the range (video situation)
            if (root.isRightOfRec(range)) {
                //go to left
                rangeHelper(root.left, range, result);
            } else {
                //go to right
                rangeHelper(root.right, range, result);
            }
        }

    }

    /**
     * Nearest neighbor.
     *
     * @param x1 the x 1
     * @param x2 the x 2
     */
    public void nearestNeighbor(double x1, double x2) {
        double[] val = {x1, x2};
        Node node = new Node(val,2);
        nearestHelper(node, new Node(), Double.MAX_VALUE, root);
    }

    /**
     * Nearest helper.
     *
     * @param queryNode   the query node
     * @param nearestNode the nearest node
     * @param minDistance the min distance
     * @param node        the node
     */
    public void nearestHelper(Node queryNode, Node nearestNode, double minDistance, Node node) {
        if (node == null) {
            return;
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
//a mini test driver class for testing
    public static void main(String[] args) {
        TwoDTree tree = new TwoDTree();
        double points[][] = {{3, 6}, {17, 15}, {13, 15}, {6, 12},
                {9, 1}, {2, 7}, {10, 19}};
        for (double[] cur : points) {
            tree.insert(cur, "location");
        }
//        ListOfCrimes list = tree.findPointsInRange(0, 0, 20, 20);
//
//        System.out.println("Examined " + list.size() + " nodes during search");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println( list.get(i).toString());
//        }
        //tree.preorder();
        tree.reverseLevelOrderPrint();
        System.out.println("size: " + tree.size);
    }
}
