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
     * Add char at end.
     * add a char at the end of the node
     * @param c the c
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully
     *  Post-condition: a node is added at the end of the node
     */
    public void addCharAtEnd(char c) {
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
     *  Pre-condition: the list has been initialized successfully
     *  Post-condition: a node is added at the front of the node
     */
    public void addCharAtFront(char c) {
        DoubleNode node = new DoubleNode(c, null, null);
        if (this.head != null) {
            //node is head
            this.head.setPrev(node);
            node.setNext(this.head);
            this.head = node;
        } else {
            //node is the first node of the list
            this.tail = this.head = node;
        }
        this.size++;
    }


    /**
     * Remove char from front char.
     *
     * @return the char
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully, there should be at least one node in the list.
     *  Post-condition: the head is deleted from the list and its value is returned
     */
    public char removeCharFromFront() {
        if (this.head != null) {
            this.size--;
            char oldHead = this.head.getC();
            if (this.head.getNext() != null) {
                DoubleNode newHead = this.head.getNext();
                newHead.setPrev(null);
                this.head = newHead;
            } else {
                //delete the only node
                this.head = this.tail = null;
            }
            return oldHead;
        } else {
            char c = '!';
            return c;
        }

    }

    /**
     * Remove char at end char.
     *
     * @return the char
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully, there should be at least one node in the list.
     *  Post-condition: the tail is deleted from the list and its value is returned
     */
    public char removeCharAtEnd() {
        if (this.tail != null) {
            this.size--;
            char oldTail = this.tail.getC();
            if (this.tail.getPrev() != null) {
                DoubleNode newTail = this.tail.getPrev();
                newTail.setNext(null);
                this.tail = newTail;
            } else {
                //delete the only node
                this.head = this.tail = null;
            }
            return oldTail;
        } else {
            char c = '!';
            return c;
        }
    }


    /**
     * Count nodes int.
     *
     * @return the int
     * Big Theta(1) for all cases
     *  Pre-condition: the list has been initialized successfully,
     *  Post-condition: return the number of nodes in the list
     */
    public int countNodes() {
        return this.size;
    }


    /**
     * Delete char the first c in the list and return true.
     * if there is none c in the list return false.
     *
     * @param c the c
     * @return the boolean
     * Best case:  Big Theta(1), when the target is the head of the list
     * Worst case:  Big Theta(n), when the target is the tail of the list
     *  Pre-condition: the list has been initialized successfully, and one list in the list,
     *  Post-condition: if found return true and delete the first node with the value of c, otherwise return false
     *
     */
    public boolean deleteChar(char c) {
        if (this.size == 0) {
            return false;
        }
        if (this.size == 1) {
            this.head = this.tail = null;
            this.size--;
            return true;
        }
        DoubleNode current = this.head;
        while (current != null) {
            //when find, delete it
            if (current.getC() == c) {
                this.size--;

                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    //it's tail
                    current.getPrev().setNext(null);
                    this.tail = current.getPrev();
                }
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    //it's head
                    current.getNext().setPrev(null);
                    this.head = current.getNext();
                }

                return true;
            }
            current = current.getNext();
        }
        //c is not in the list
        return false;
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

    /**
     * Reverse the list.
     * Big Theta(n) for all cases
     *  Pre-condition: the list has been initialized successfully, at least two nodes in the list
     *  Post-condition: the list is reversed

     */
    public void reverse() {
        if (this.size == 0 || this.size == 1) {
            return;
        }
        DoubleNode current = this.head;
        DoubleNode prev = null;
        this.tail = current;
        while (current != null) {
            prev = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(prev);
            current = current.getPrev();
        }
        if (prev != null) {
            this.head = prev.getPrev();
        }
    }
}
