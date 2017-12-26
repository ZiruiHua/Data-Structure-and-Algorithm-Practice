import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * The type Reverse polish notation.
 */
public class ReversePolishNotation {
    /**
     * The Stack.
     */
    Stack stack;
    /**
     * The Tree.
     */
    RedBlackTree tree;

    /**
     * Instantiates a new Reverse polish notation.
     */
    public ReversePolishNotation() {
        stack = new Stack();
        tree = new RedBlackTree();
    }

    /**
     * Process.
     * this method takes in a operand, a operator or a variable as parameter
     * process it according to the its type
     * @param str the str
     * @throws IOException the io exception
     */
    public void process(String str) throws IOException {
        try {
            if (isNum(str)) {
                //if a big integer
                BigInteger bi = new BigInteger(str);
                stack.push(bi);
            }
            //the popped element could be a number or a variable
            else if (str.equals("+")) {
                Object o1 = stack.pop();
                Object o2 = stack.pop();
                BigInteger operand1;
                BigInteger operand2;

                if (o1 instanceof String) {
                    //is variable, looking its value from tree
                    operand1 = tree.lookup(o1.toString());
                } else {
                    //is number
                    operand1 = (BigInteger) o1;
                }
                if (o2 instanceof String) {
                    operand2 = tree.lookup(o2.toString());
                } else {
                    operand2 = (BigInteger) o2;
                }
                System.out.println(operand2.add(operand1));
                stack.push(operand2.add(operand1));
            } else if (str.equals("-")) {
                Object o1 = stack.pop();
                Object o2 = stack.pop();
                BigInteger operand1;
                BigInteger operand2;

                if (o1 instanceof String) {
                    //is variable
                    operand1 = tree.lookup(o1.toString());
                } else {
                    //is number
                    operand1 = (BigInteger) o1;
                }
                if (o2 instanceof String) {
                    operand2 = tree.lookup(o2.toString());
                } else {
                    operand2 = (BigInteger) o2;
                }
                System.out.println(operand2.subtract(operand1));
                stack.push(operand2.subtract(operand1));
            } else if (str.equals("*")) {
                Object o1 = stack.pop();
                Object o2 = stack.pop();
                BigInteger operand1;
                BigInteger operand2;

                if (o1 instanceof String) {
                    //is variable
                    operand1 = tree.lookup(o1.toString());
                } else {
                    //is number
                    operand1 = (BigInteger) o1;
                }
                if (o2 instanceof String) {
                    operand2 = tree.lookup(o2.toString());
                } else {
                    operand2 = (BigInteger) o2;
                }
                System.out.println(operand2.multiply(operand1));

                stack.push(operand2.multiply(operand1));
            } else if (str.equals("/")) {
                Object o1 = stack.pop();
                Object o2 = stack.pop();
                BigInteger operand1;
                BigInteger operand2;

                if (o1 instanceof String) {
                    //is variable
                    operand1 = tree.lookup(o1.toString());
                } else {
                    //is number
                    operand1 = (BigInteger) o1;
                }
                if (o2 instanceof String) {
                    operand2 = tree.lookup(o2.toString());
                } else {
                    operand2 = (BigInteger) o2;
                }
                System.out.println(operand2.divide(operand1));
                stack.push(operand2.divide(operand1));
            } else if (str.equals("%")) {
                Object o1 = stack.pop();
                Object o2 = stack.pop();
                BigInteger operand1;
                BigInteger operand2;

                if (o1 instanceof String) {
                    //is variable
                    operand1 = tree.lookup(o1.toString());
                } else {
                    //is number
                    operand1 = (BigInteger) o1;
                }
                if (o2 instanceof String) {
                    operand2 = tree.lookup(o2.toString());
                } else {
                    operand2 = (BigInteger) o2;
                }
                System.out.println(operand2.mod(operand1));

                stack.push(operand2.mod(operand1));
            } else if (str.equals("~")) {
                Object o1 = stack.pop();
                BigInteger operand1;
                if (o1 instanceof String) {
                    //is variable
                    operand1 = tree.lookup(o1.toString());
                } else {
                    //is number
                    operand1 = (BigInteger) o1;
                }
                BigInteger temp = new BigInteger("0");
                BigInteger res = temp.subtract(operand1);
                System.out.println(res);

                stack.push(res);
            } else if (str.equals("#")) {
                try {
                    Object o1 = stack.pop();
                    Object o2 = stack.pop();
                    Object o3 = stack.pop();
                    BigInteger operand1;
                    BigInteger operand2;
                    BigInteger operand3;

                    if (o1 instanceof String) {
                        //is variable
                        operand1 = tree.lookup(o1.toString());
                    } else {
                        //is number
                        operand1 = (BigInteger) o1;
                    }
                    if (o2 instanceof String) {
                        operand2 = tree.lookup(o2.toString());
                    } else {
                        operand2 = (BigInteger) o2;
                    }
                    if (o3 instanceof String) {
                        operand3 = tree.lookup(o3.toString());
                    } else {
                        operand3 = (BigInteger) o3;
                    }
                    System.out.println(operand3.modPow(operand2, operand1));

                    stack.push(operand3.modPow(operand2, operand1));
                } catch (Exception e) {
                    System.out.println("Exception in thread \"main\" java.lang.Exception: error: stack underflow exception");
                    System.exit(-1);
                }
            } else if (str.equals("=")) {
                BigInteger num1 = (BigInteger) stack.pop();
                try {
                    String var = (String) stack.peek();
                } catch (Exception e) {
                    System.out.println("Exception in thread \"main\" java.lang.Exception: error: " + stack.peek() + " is not an variable");
                    System.exit(-1);
                }
                String var = (String) stack.pop();
                tree.insert(new ResultType(var, num1));
                System.out.println(var);
                System.out.println(num1);
                stack.push(var);
            }
            // input String is a variable
            else {
                stack.push(str);
            }
       } catch (Exception e) {
            //the tree doesn't contains that variable
           //or the variable is not associated with a big integer value
            System.out.println("Exception in thread \"main\" java.lang.Exception");
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        ReversePolishNotation rpn = new ReversePolishNotation();
        while (true) {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter");
            //input must be allowed operator, number, and a-z
            String[] strArray = b.readLine().split(" ");
            for (String str : strArray) {
                rpn.process(str);
            }
        }
    }
    /**
     * Check if a string is a big integer
     *
     * @param str
     *
     */
    private boolean isNum(String str) {
        try {
            BigInteger b = new BigInteger(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
