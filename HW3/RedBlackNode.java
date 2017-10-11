/**
 * The type Red black node.
 */
public class RedBlackNode {
    /**
     * The constant RED.
     */
    public static final int RED = 1;
    /**
     * The constant BLACK.
     */
    public static final int BLACK = 0;
    private ResultType data;
    private int color;
    private RedBlackNode p, lc, rc;

    /**
     * Instantiates a new Red black node.
     *
     * @param data  the data
     * @param color the color
     * @param p     the p
     * @param lc    the lc
     * @param rc    the rc
     */
    public RedBlackNode(ResultType data,
                        int color,
                        RedBlackNode p,
                        RedBlackNode lc,
                        RedBlackNode rc) {
        this.data = data;
        this.color = color;
        this.p = p;
        this.lc = lc;
        this.rc = rc;
    }

    /**
     * Gets data.
     * pre-condition: The node has been constructed
     * post-condition: Return the value ( a result type) of the node
     * @return the data
     */
    public ResultType getData() {
        return data;
    }

    /**
     * Sets data.
     * pre-condition: The node has been constructed
     * post-condition: The node has a data field
     * @param data the data
     */
    public void setData(ResultType data) {
        this.data = data;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Gets p.
     *
     * @return the p
     */
    public RedBlackNode getP() {
        return p;
    }

    /**
     * Sets p.
     *
     * @param p the p
     */
    public void setP(RedBlackNode p) {
        this.p = p;
    }

    /**
     * Gets lc.
     *
     * @return the lc
     */
    public RedBlackNode getLc() {
        return lc;
    }

    /**
     * Sets lc.
     *
     * @param lc the lc
     */
    public void setLc(RedBlackNode lc) {
        this.lc = lc;
    }

    /**
     * Gets rc.
     *
     * @return the rc
     */
    public RedBlackNode getRc() {
        return rc;
    }

    /**
     * Sets rc.
     *
     * @param rc the rc
     */
    public void setRc(RedBlackNode rc) {
        this.rc = rc;
    }
}
