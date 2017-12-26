/**
 * The type Queue new.
 */
public class Queue_New {
    //queue is realized based on a doubly linked list of the HW 1
    private DoublyLinkedList list;
    //size of the queue
    private int size;

    /**
     * Instantiates a new Queue new.
     */
    public Queue_New() {
        list = new DoublyLinkedList();
        size = 0;//initial size is 0
    }

    /**
     * Offer.
     *  pre-condition: The queue has been constructed
     *  post-condition: An node is added into the end of queue and size of the queue plus one
     * @param value the value
     */
    public void offer(Node value) {
        list.addCharAtEnd(value);
        size++;
    }

    /**
     * Poll node.
     *  pre-condition: The queue has been constructed
     *  post-condition: Return the head node of the queue and this is node is deleted from the queue after that
     * @return the node
     */
    public Node poll() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        size--;
        DoubleNode node = list.getHead();
        list.removeCharFromFront();
        return node.getC();
    }

    /**
     * Is empty boolean.
     *  pre-condition: The queue has been constructed
     *  post-condition: Ture is returned if the queue is empty (size is 0) otherwise returning false
     * @return the boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Size int.
     * pre-condition: The queue has been constructed
     *  post-condition: Size of the current queue is returned
     * @return the int
     */
    public int size() {
        return size;
    }
}
