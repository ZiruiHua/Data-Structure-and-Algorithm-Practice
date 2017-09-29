import java.math.BigInteger;

/**
 * The type Integer node.
 */
public class IntegerNode {

    private IntegerNode p;
    private BigInteger value;
    private IntegerNode n;

    /**
     * Instantiates a new Integer node.
     */
    public IntegerNode() {
    }

    /**
     * Instantiates a new Integer node.
     *
     * @param value the value
     * @param p     the p
     * @param n     the n
     */
    public IntegerNode (BigInteger value, IntegerNode p, IntegerNode n) {
        this.value = value;
        this.p = p;
        this.n = n;
    }

    /**
     * Gets prev.
     *
     * @return the prev
     *  Big Theta(1) for all cases
     * Pre-condition: The node has been initialized and its has a prev pointer
     * Post-condition: the prev node is returned if exists, otherwise return null
     */
    public IntegerNode getPrev() {
        if (this.p == null) {
            return null;
        }
        return this.p;
    }

    /**
     * Sets prev.
     *
     * @param prev the prev
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the prev pointer of this node is set
     */
    public void setPrev(IntegerNode prev) {
        this.p = prev;
    }

    /**
     * Gets next.
     *
     * @return the next
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized, and the current node is not a tail
     * Post-condition: the prev node is returned if exists, otherwise return null
     */
    public IntegerNode getNext() {
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
    public void setNext(IntegerNode next) {
        this.n = next;
    }

    /**
     * Gets value.
     *
     * @return the value
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the value of this node is returned
     */
    public BigInteger getValue() {
        return this.value;
    }

    /**
     * Sets value.
     *
     * @param bigint the bigint
     * Big Theta(1) for all cases
     * Pre-condition: The node has been initialized
     * Post-condition: the value of this node is set
     */
    public void setValue(BigInteger bigint) {
        this.value = bigint;
    }
    public java.lang.String toString() {
        return this.value.toString();
    }
}
