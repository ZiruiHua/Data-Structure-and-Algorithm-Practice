/**
 * The type Doubly linked list.
 */
public class DoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    /**
     * Instantiates a new Doubly linked list with the size of 0.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /**
     * Is empty boolean.
     *
     * @return the boolean
     * Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add char at end.
     * add a char at the end of the node
     * @param c the c
     * Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void addCharAtEnd(Node c) {
        DoubleNode node = new DoubleNode(c, null, null);
        if (this.tail != null) {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        } else {
            this.tail = this.head = node;
        }
        this.size++;
    }


    /**
     * Add char at front.
     *
     * @param c the c
     * Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void addCharAtFront(Node c) {
        DoubleNode node = new DoubleNode(c, null, null);
        if (this.head != null) {
            this.head.setPrev(node);
            node.setNext(this.head);
            this.head = node;
        } else {
            this.tail = this.head = node;
        }
        this.size++;
    }


    /**
     * Remove char from front char.
     *
     * @return the char
     * Big Theta(1) for all cases
     *  Pre-condition: there should be at least one node in the list.
     *  Post-condition: none
     */
    public Node removeCharFromFront() {
        if (this.head != null) {
            this.size--;
            Node oldHead = this.head.getC();
            if (this.head.getNext() != null) {
                DoubleNode newHead = this.head.getNext();
                newHead.setPrev(null);
                this.head = newHead;
            } else {
                this.head = this.tail = null;
            }
            return oldHead;
        } else {
            return null;
        }

    }

    /**
     * Remove char at end char.
     *
     * @return the char
     * Big Theta(1) for all cases
     *  Pre-condition: there should be at least one node in the list.
     *  Post-condition: none
     */
    public Node removeCharAtEnd() {
        if (this.tail != null) {
            this.size--;
            Node oldTail = this.tail.getC();
            if (this.tail.getPrev() != null) {
                DoubleNode newTail = this.tail.getPrev();
                newTail.setNext(null);
                this.tail = newTail;
            } else {
                this.head = this.tail = null;
            }
            return oldTail;
        } else {
            return null;
        }
    }


    /**
     * Count nodes int.
     *
     * @return the int
     * Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public int countNodes() {
        return this.size;
    }

    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode current = this.head;
        while (current != null) {
            sb.append(current.getC());
            current = current.getNext();
        }
        return sb.toString();
    }

    public DoubleNode getHead() {
        return this.head;
    }
    public DoubleNode getTail() {
        return this.tail;
    }

}
