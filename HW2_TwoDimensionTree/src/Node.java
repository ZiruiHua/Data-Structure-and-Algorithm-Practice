/**
 * The type Node.
 */
class Node {
    /**
     * The Key is 2 doule array contains node's coordiate infor
     */
    double[] key;
    /**
     * The Left node of the current node
     */
    Node left;
    /**
     * The Right node of the current node.
     */
//right top
    Node right;
    /**
     * The Value.value is other part of the CSV other than X, Y
     */

    String value;
    /**
     * The Level.level 0 / 1
     */

    int level;

    /**
     * Instantiates a new Node. An empty constructor
     */
    public Node() {

    }

    /**
     * Instantiates a new Node.
     * Takes coordinate and axis
     * @param item  the item
     * @param level the level
     */
    public Node(double[] item, int level) {
        key = item;
        this.level = level;
        left = right = null;
    }

    /**
     * Instantiates a new Node.
     * Takes coordinate and axis and other information of the ndoe
     * @param item  the item
     * @param level the level
     * @param value the value
     */
    public Node(double[] item, int level, String value) {
        key = item;
        this.level = level;
        left = right = null;
        this.value = value;
    }

    /**
     * Distance to square double.
     *  pre-condition: The node has been constructed and contained coordinates info
     *  post-condition: Return the square distance between the node and an passed in node
     * @param node the node
     * @return the double
     */
    public double distanceToSquare(Node node) {
        return (key[0] - node.key[0]) * (key[0] - node.key[0])
                + (key[1] - node.key[1]) * (key[1] - node.key[1]);
    }

    /**
     * Distance to euclidean double.
     *  pre-condition: The node has been constructed and contained coordinates info
     *  post-condition: Return the distance between the node and an passed in node
     * @param node the node
     * @return the double
     */
    public double distanceToEuclidean(Node node) {
        return Math.sqrt(distanceToSquare(node));
    }

    /**
     * If intersect rec boolean.
     *  pre-condition: The node has been constructed and the passed in rectangle is valid
     *  post-condition: Return if the node intersect of the rectangle based on the axis of the node
     * @param rec the rec
     * @return the boolean
     */
    public boolean ifIntersectRec(Rectangle rec) {
        if (level % 2 == 0) {
            return rec.xmin <= key[0] && key[0] <= rec.xmax;
        } else {
            return rec.ymin <= key[1] && key[1] <= rec.ymax;
        }
    }

    /**
     * Is right of rec boolean.
     *  pre-condition: The node has been constructed and the passed in rectangle is valid
     *  post-condition: Return if the node is on the right / top of the rectangle based on the axis of the node

     * @param rec the rec
     * @return the boolean
     */
    public boolean isRightOfRec(Rectangle rec) {
        if (level % 2 == 0) {
            return rec.xmin < key[0] && rec.xmax < key[0];
        } else {
            return rec.ymin < key[1] && rec.ymax < key[1];
        }
    }

    /**
     * In middle boolean.
     * Not used
     * @param queryNode the query node
     * @param childNode the child node
     * @return the boolean
     */
    public boolean inMiddle(Node queryNode, Node childNode) {
        if (level % 2 == 0) {
            return queryNode.key[0] < key[0];
        } else {
            return queryNode.key[1] < key[1];
        }
    }
    public String toString() {
        return key[0] + " " + key[1] + " level: " + level + " location: " + value;
    }

}