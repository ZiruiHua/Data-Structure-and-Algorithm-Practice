/**
 * The type Double node.
 */
public class DoubleNode {

    private DoubleNode p;//prev pointer
    private Node ch;//value of the node is a Two D tree node
    private DoubleNode n;//next pointer

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
    public DoubleNode (Node ch, DoubleNode p, DoubleNode n) {
        this.ch = ch;
        this.p = p;
        this.n = n;
    }

    /**
     * Gets prev.
     *
     * @return the prev node
     * Big Theta(1) for all cases
     * Pre-condition: the current node should have a prev node, it's not the head
     * Post-condition: none
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
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void setPrev(DoubleNode prev) {
        this.p = prev;
    }

    /**
     * Gets next.
     *
     * @return the next node
     * Big Theta(1)
     * Precondition: the current node should have a next node, it's not the tail
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
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void setNext(DoubleNode next) {
        this.n = next;
    }

    /**
     * Gets c.
     *
     * @return the c
     * Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public Node getC() {
        return this.ch;
    }

    /**
     * Sets c.
     *
     * @param c the c
     * Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void setC(Node c) {
        this.ch = c;
    }
    public java.lang.String toString() {
        return ch.toString();
    }
}
