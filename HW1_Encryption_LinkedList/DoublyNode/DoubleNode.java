/**
 * The type Double node.
 */
public class DoubleNode {

    private DoubleNode p;
    private char ch;
    private DoubleNode n;

    /**
     * Instantiates a new Double node.
     */
    public DoubleNode() {
        }

    /**
     * Instantiates a new Double node.
     *
     * @param ch the ch is the value of the node
     * @param p  the p is the prev node of the node
     * @param n  the n is the next node of the node
     */
    public DoubleNode (char ch, DoubleNode p, DoubleNode n) {
        this.ch = ch;
        this.p = p;
        this.n = n;
    }

    /**
     * Gets prev.
     *
     * @return the prev node
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized and its has a prev pointer
     * Post-condition: the prev node is returned if exists, otherwise return null
     */
    public DoubleNode getPrev() {
        if (this.p == null) {
            return null;
        }
        return this.p;
    }

    /**
     * Sets prev.
     *
     * @param prev the prev
     * set the prev node
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the prev pointer of this node is set
     */
    public void setPrev(DoubleNode prev) {
        this.p = prev;
    }

    /**
     * Gets next.
     *
     * @return the next node
     * Big Theta(1)
     * Pre-condition: The node has been initialized, and the current node is not a tail
     * Post-condition: the prev node is returned if exists, otherwise return null
     */
    public DoubleNode getNext() {
        if (this.n == null) {
            return null;
        }
        return this.n;
    }

    /**
     * Sets next.
     *
     * @param next the next
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the prev pointer of this node is set
     */
    public void setNext(DoubleNode next) {
        this.n = next;
    }

    /**
     * Gets c.
     *
     * @return the c
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the value of this node is returned
     */
    public char getC() {
        return this.ch;
    }

    /**
     * Sets c.
     *
     * @param c the c
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the value of this node is set
     */
    public void setC(char c) {
        this.ch = c;
    }
    public java.lang.String toString() {
        return Character.toString(ch);
    }
}
