package part4;

/**
 * The type Helper class.
 */
public class helperClass {
    /**
     * To linked list single list.
     *
     * @param input the input
     * @return the single list
     *  Big Theta(n) for all cases
     *  Pre-condition: input str is not null
     *  Post-condition: return type is a linkedlist
     */
    public static singleList toLinkedList(String input) {
        singleList result = new singleList();
        for (char c : input.toCharArray()) {
            result.add(c);
        }
        return result;
    }

    /**
     * Concat string.
     *
     * @param l1 the l 1
     * @param l2 the l 2
     * @return the string
     *  Big Theta(n) for all cases
     *  Pre-condition: l1, l2 are not null
     *  Post-condition: return type is a string
     */
//concat l1 and l2, l2 is at the end of l1
    public static String concat(singleList l1, singleList l2) {
        StringBuilder sb = new StringBuilder();
        sb.append(l1.toString());
        sb.append(l2.toString());
        return sb.toString();
    }

}
