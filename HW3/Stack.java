import java.util.EmptyStackException;

/**
 * The type Stack new.
 */
public class Stack {

    /**
     * The Header. Top pointer of the stack
     */
    private int head;//stack top
    private Object[] array;
    /**
     * The size
     * Capacity of the stack
     */
    int size;

    /**
     * Instantiates a new Stack new.
     */
    public Stack(){
        array = new Object[12];
        head = -1;
        size = 12;
    }
    /**
     * Instantiates a new Stack new.
     * pre-condition: The number of elements in the stack has reached size
     * post-condition: The size of the stack is doubled
     * Big Theta(N) for all cases, N is the orginal capacity
     */
    private void expand() {
        int newSize = size * 2 + 1;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = newSize;
    }

    /**
     * Is empty boolean.
     * pre-condition: The stack has been constructed
     * post-condition: A true returned if the size of the stakc is 0 otherwise return false
     * Big Theta(1) for all cases
     * @return the boolean
     */
    public boolean isEmpty(){
        return head == -1;
    }

    /**
     * Push.
     * pre-condition: The stack has been constructed and node is valid
     * post-condition: A node is pushed into the top of the stack, it becomes the new header
     * Big Theta(1) for all cases
     * @param object the value
     */
    public void push(Object object) {
        if (head == size - 1) {
            expand();
        }
        array[++head] = object;
    }

    /**
     * Pop node.
     * pre-condition: The stack has been constructed
     * post-condition: Return the node in the top of the stack, and the node is deleted from the stack
     * Big Theta(1) for all cases
     * @return the node
     */
    public Object pop() {
        if(head == -1){
            throw new EmptyStackException();
        }
        return array[head--];
    }

    /**
     * Peek object.
     * pre-condition: The stack has been constructed
     * post-condition: Return the node in the top of the stack, not deleting from the stack
     * Big Theta(1) for all cases
     * @return the object
     */
    public Object peek(){
        if(head == -1){
            throw new EmptyStackException();
        }
        return array[head];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Stack s = new Stack();
        for (int i = 0; i < 30; i++) {
            s.push(i);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
