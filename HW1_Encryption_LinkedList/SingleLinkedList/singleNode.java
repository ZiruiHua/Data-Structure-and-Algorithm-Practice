package part4;

/**
 * The type Single node.
 */
public class singleNode {
    /**
     * The Next.
     */
    singleNode next;
    /**
     * The Value.
     */
    char value;

    /**
     * Instantiates a new Single node.
     */
    public singleNode() {

    }

    /**
     * Instantiates a new Single node.
     *
     * @param value the value
     */
    public singleNode(char value) {
        this.value = value;
   }

    /**
     * Gets next.
     *
     * @return the next
     *  Big Theta(1) for all cases
     *  Pre-condition: the node is not the head
     *  Post-condition: none
     */
    public singleNode getNext() {
        return this.next;
   }

    /**
     * Sets next.
     *
     * @param next the next
     *  Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void setNext(singleNode next) {
       this.next = next;
   }

    /**
     * Gets c.
     *
     * @return the c
     *  Big Theta(1) for all cases
     *  Pre-condition: the node has value
     *  Post-condition: none
     */
    public char getC() {
        return this.value;
   }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
