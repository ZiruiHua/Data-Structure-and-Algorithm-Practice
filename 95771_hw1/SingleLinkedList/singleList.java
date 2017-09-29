package part4;

/**
 * The type Single list.
 */
public class singleList {
    private singleNode head;

    /**
     * Instantiates a new Single list.
     */
    public singleList() {
        this.head = null;
    }

    /**
     * Add.
     *
     * @param c the c
     *  Big Theta(1) for all cases
     *  Pre-condition: none
     *  Post-condition: none
     */
    public void add(char c) {
        singleNode node = new singleNode(c);
        if (this.head != null) {
            singleNode cur = this.head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(node);
        } else {
            this.head = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        singleNode current = this.head;
        while (current != null) {
            sb.append(current.getC());
            current = current.getNext();
        }
        return sb.toString();
    }
}
