import java.util.LinkedList;
import java.util.Queue;

public class TwoDTree {
    // Root of BST
    Node root;
    int size;
    // Constructor
    public TwoDTree() {
        root = null;
        size = 0;
    }

    // This method mainly calls insertRec()
    public void insert(double[] key) {
        root = insertHelper(root, key, 0);
    }


    /* A recursive function to insert a new key in BST */
    public Node insertHelper(Node root, double[] key, int depth) {

		/* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key, depth % 2);
            return root;
        }
        //cd is the current dimension, deciding compare x or y
        int cd = depth % 2;
		/* Otherwise, recur down the tree */
        if (key[cd] < root.key[cd]) {
            root.left = insertHelper(root.left, key, depth + 1);
        }
        else {
            root.right = insertHelper(root.right, key, depth + 1);
        }

		/* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void preorderPrint() {
        preorderHelper(root);
    }

    // A utility function to do inorder traversal of BST
    void preorderHelper(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.toString());
        preorderHelper(root.left);
        preorderHelper(root.right);
    }
    void levelorderPrint() {
        levelorderHelper(root);
    }

    void levelorderHelper(Node root) {
        if (root == null) {
            System.out.println("Level order error");
            return;
        }
        //implement it by self
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
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

    public ListOfCrimes findPointsInRange(double x1, double y1, double x2, double y2) {
        ListOfCrimes result = new ListOfCrimes();
        rangeHelper(root, new Rectangle(x1,x2,y1,y2), result);
        return  result;
    }

    public void rangeHelper(Node root, Rectangle range, ListOfCrimes result) {
        if (root == null) {
            return;
        }
        //if the current node intersect with range
        if (root.ifIntersectRec(range)) {
            if(range.ifContains(root)) {
                //add into result list
                result.add(root);
            } else {
                //go to both side
                rangeHelper(root.left, range, result);
                rangeHelper(root.right, range, result);
            }
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
    // Driver Program to test above functions
    public static void main(String[] args) {
        TwoDTree tree = new TwoDTree();
        double points[][] = {{3, 6}, {17, 15}, {13, 15}, {6, 12},
                {9, 1}, {2, 7}, {10, 19}};
        for (double[] cur : points) {
            tree.insert(cur);
        }
        //tree.preorder();
        tree.levelorderPrint();
    }
}
