package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testSingle {
    public static void main(String[] args) {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first string please");
        String input1 = null;
            try {
                input1 = b.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("Enter the second string please");
        String input2 = null;
        try {
            input2 = b.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        singleList l1 = helperClass.toLinkedList(input1);
        singleList l2 = helperClass.toLinkedList(input2);

        System.out.println("Concatenation: ");
        System.out.println(helperClass.concat(l1, l2));
    }
}
