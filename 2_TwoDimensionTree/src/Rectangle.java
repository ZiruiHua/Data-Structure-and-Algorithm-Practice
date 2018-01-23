/**
 * The type Rectangle.
 */
public class Rectangle {

    /**
     * The search range.
     */
    double xmin;
    double xmax;
    double ymin;
    double ymax;

    /**
     * Instantiates a new Rectangle according to the search range user input.
     *
     * @param xmin the xmin
     * @param xmax the xmax
     * @param ymin the ymin
     * @param ymax the ymax
     */
    public Rectangle(double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
    }

    /**
     * If contains boolean.
     *  pre-condition: The rectangle has been constructed and the passed in node is valid
     *  post-condition: A true returned if the node is in the range of the rectangle otherwise returning flase
     * @param node the node
     * @return the boolean
     */
    public boolean ifContains(Node node) {
        if (node.key[0] >= xmin && node.key[0] <= xmax
                && node.key[1] >= ymin && node.key[1] <= ymax) {
            return true;
        }
        return false;
    }
}
