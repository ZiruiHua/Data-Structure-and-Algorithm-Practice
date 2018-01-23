/**
 * The type Single node is used to stored info in the stack
 */
public class SingleNode {
    private Node value;
    /**
     * The Next. The pointer to the next node
     */
    SingleNode next;

    /**
     * Instantiates a new Single node.
     *
     * @param value the value
     */
    public SingleNode(Node value){
        this(value,null);
    }

    /**
     * Instantiates a new Single node.
     *
     * @param value the value
     * @param n     the n
     */
    public SingleNode(Node value,SingleNode n){
        this.value=value;
        next=n;
    }

    /**
     * Gets value.
     *  pre-condition: The node has been constructed
     *  post-condition: Return the value ( a tree node) of the single node
     * @return the value
     */
    public Node getValue() {
        return value;
    }
}
