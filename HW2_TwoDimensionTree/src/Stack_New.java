/**
 * The type Stack new.
 */
public class Stack_New {

    /**
     * The Header. Top pointer of the stack
     */
    SingleNode header;//stack top
    /**
     * The Count.
     */
    int count;//number of nodes in the stack

    /**
     * Instantiates a new Stack new.
     */
    public Stack_New(){
        header=null;
        count =0;
    }

    /**
     * Is empty boolean.
     *  pre-condition: The stack has been constructed
     *  post-condition: A true returned if the size of the stakc is 0 otherwise return false
     * @return the boolean
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Push.
     *  pre-condition: The stack has been constructed and node is valid
     *  post-condition: A node is pushed into the top of the stack, it becomes the new header
     * @param value the value
     */
    public void push(Node value) {

        header=new SingleNode(value, header);
        count++;
    }

    /**
     * Pop node.
     *  pre-condition: The stack has been constructed
     *  post-condition: Return the node in the top of the stack, and the node is deleted from the stack
     * @return the node
     */
    public Node pop() {
        if (this.isEmpty()) {
            return null;
        }
        Node node=header.getValue();
        header=header.next;
        count--;
        return node;
    }

}
