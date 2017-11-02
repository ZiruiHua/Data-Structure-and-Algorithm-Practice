/**
 * The type Heap.
 */
public class Heap {
    private int size; // current size of the heap
    private double[][] pairs;

    /**
     * Instantiates a new Heap.
     *
     * @param length the length
     */
    public Heap(int length) {
        pairs = new double[length][2];
        size = 0;
    }


    private void siftup(int k) {
        while (k != 0) {
            // find the father of the current pair
            int father = (k - 1) / 2;
            if (pairs[k][1] > pairs[father][1]) {
                break;
            }
            // swap
            double[] temp = pairs[k];
            pairs[k] = pairs[father];
            pairs[father] = temp;
            k = father;
        }
    }

    /**
     * Heapify.
     */
    public void heapify() {
        // check every value in the array
        for (int i = 0; i < size; i++) {
            siftup(i);
        }
    }

    /**
     * Poll double [ ].
     *
     * @return the double [ ]
     */
    public double[] poll() {
        if (isEmpty()) {
            return null;
        }
        double[] min = pairs[0];
        for (int i = 0 ; i < size - 1; i++) {
            pairs[i] = pairs[i + 1];
        }
        size--;
        heapify();
        return min;
    }

    /**
     * Peek double [ ].
     *
     * @return the double top of the heap without deleting
     */
    public double[] peek() {
        if(isEmpty()) {
            return null;
        }
        double[] min = pairs[0];
        return min;
    }

    /**
     * Push. add a pair into heep
     *
     * @param index the index
     * @param value the value
     */
    public void push(int index, double value) {

        // if index is already in the queue, replace
        if (find(index) != Double.MAX_VALUE) {
            changeValue(index, value);
        } else {
            double[] newPair = {index, value};
            pairs[size++] = newPair;
            heapify();
        }
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        if (size > 0)
            return false;
        else
            return true;
    }

    /**
     * Find double.
     *
     * @param target the target
     * @return the double
     */
    public double find(int target) {
        for (int i = 0; i < pairs.length; i++) {
            int index = (int) pairs[i][0];
            double value = pairs[i][1];
            if (target == index) {
                return value;
            }
        }
        return Double.MAX_VALUE;
    }

    /**
     * Change value.
     *
     * @param target   the target
     * @param newValue the new value
     */
    public void changeValue(int target, double newValue) {
        for (int i = 0; i < pairs.length; i++) {
            int index = (int)pairs[i][0];
            if (target == index) {
                pairs[i][1] = newValue;
            }
        }
        heapify();
    }



    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Heap h = new Heap(10);
        for (double i = 1; i < 6; i++) {
            h.push((int)i, i);
            System.out.println("size: " + h.size);
        }
        while (!h.isEmpty()) {
            double[] test = h.poll();
            System.out.println(test[0] + " " + test[1]);
        }
    }
}
