
class Node {
    double[] key;
    //left bottom
    Node left;
    //right top
    Node right;
    //value is other part of the CSV other than X, Y
    String value;
    //level 0 / 1
    int level;

    public Node(double[] item, int level) {
        key = item;
        this.level = level;
        left = right = null;
    }
    public Node(double[] item, int level, String value) {
        key = item;
        this.level = level;
        left = right = null;
        this.value = value;
    }

    public double distanceToSquare(Node node) {
        return (key[0] - node.key[0]) * (key[0] - node.key[0])
                + (key[1] - node.key[1]) * (key[1] - node.key[1]);
    }
    public double distanceToEuclidean(Node node) {
        return Math.sqrt(distanceToSquare(node));
    }

    public boolean ifIntersectRec(Rectangle rec) {
        if (level % 2 == 0) {
            return rec.xmin <= key[0] && key[0] <= rec.xmax;
        } else {
            return rec.ymin <= key[1] && key[1] <= rec.ymax;
        }
    }
    public boolean isRightOfRec(Rectangle rec) {
        if (level % 2 == 0) {
            return rec.xmin < key[0] && rec.xmax < key[0];
        } else {
            return rec.ymin < key[1] && rec.ymax < key[1];
        }
    }


    public String toString() {
        return key[0] + " " + key[1] + " level: " + level;
    }
}