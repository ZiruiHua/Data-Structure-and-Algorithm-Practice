import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MHTestDriver {
    public static void main(String[] args) {
        MHCrptonsystem mh = new MHCrptonsystem();
//        BigInteger b = mh.encrypt("this is a course of data structure and algorithms");
//        System.out.println(mh.decrypt(b));
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string and I will encrypt it in a single number:");
        String input = null;
        boolean ifVaild = false;
        while (!ifVaild) {
            try {
                input = b.readLine();
                if (input.length() <= 80) {
                    ifVaild = true;
                } else {
                    System.out.println("Enter a string smaller than 80 characters");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Clear text is: " + input);
        System.out.println("Number of clear text bytes = " + input.length());

        BigInteger encryptResult = mh.encrypt(input);
        System.out.println(input + " is encryped as ");
        System.out.println(encryptResult);

        String decryptResult = mh.decrypt(encryptResult);
        System.out.println("Result of decryption: " + decryptResult);

    }
}

