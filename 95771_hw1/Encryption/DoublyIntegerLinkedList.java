import java.math.BigInteger;

/**
 * The type Doubly integer linked list.
 */
public class DoublyIntegerLinkedList {
    private IntegerNode head;
    private IntegerNode tail;
    private int size;

    /**
     * Instantiates a new Doubly integer linked list with size of 0.
     */
    public DoublyIntegerLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /**
     * Is empty boolean.
     *
     * @return the boolean
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully
     *  Post-condition: return true if the size of the list is 0, otherwise return false
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add int at end.
     *
     * @param c the c
     * add a biginteger at the end of the list
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully
     *  Post-condition: a node is added at the end of the node
     */
    public void addIntAtEnd(BigInteger c) {
        IntegerNode node = new IntegerNode(c, null, null);
        if (this.tail != null) {
            //the node is the tail now
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        } else {
            //it's the first node of the list
            this.tail = this.head = node;
        }
        this.size++;
    }

    /**
     * Gets head.
     *
     * @return the head
     * get the head node of the list
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully
     *  Post-condition: the head of the node is returned, if the list is empty, return null
     */
    public IntegerNode getHead() {
        return this.head;
    }

    /**
     * Gets the ith node of the list.
     * By this function we can easily convert the functions used to process
     * linkedlist to process array.
     *
     * @param index the index
     * @return the by index
     * Big Theta(1) for best case
     * Big Theta(n) for worst case
     *  Pre-condition: the list has been initialized successfully, index is in the range [0, list.size - 1]
     *  Post-condition: The Node with the requested index is returned
     */
    public IntegerNode getByIndex(int index) {
        IntegerNode current = this.head;
        //i from 0 to index
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;

    }
}
