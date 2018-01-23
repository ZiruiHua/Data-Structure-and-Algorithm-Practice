import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * The type Mh crptonsystem.
 */
public class MHCrptonsystem {
    /**
     * The W.
     * w is the private key list
     */
    DoublyIntegerLinkedList w; //private key
    /**
     * The B.
     * b is the public key list
     */
    DoublyIntegerLinkedList b; //public key
    /**
     * The Bitsize.
     * the size of the private and public key list
     */
    final int BITSIZE = 640;
    /**
     * The Q.
     * q is a random number larger than
     */
    BigInteger q; //q is a random number larger than
    /**
     * The R.
     * r is in[1,q], coprime to q
     */
    BigInteger r; //r is in[1,q], coprime to q
    /**
     * The Used node.
     * how many nodes that used to encrypt the input string
     */
    int usedNode = 0;

    /**
     * Instantiates a new Mh crptonsystem.
     */
    public MHCrptonsystem() {
        keyGeneration();
    }

    /**
     * Encrypt big integer.
     *
     * @param str the str
     * @return the big integer
     *  Big Theta(n*n) for all cases
     *  the for loop is n, and getByIndex is the other n
     *  Pre-condition: public key list, q, r are initialized successfully, length of the str is less or equal than 80
     *  Post-condition: the return value is a bigInteger, which is the encrypted integer of the input string, encrypted by public key
     */
    public BigInteger encrypt(String str) {
        String bitstr = strToBit(str);
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < bitstr.length(); i++) {
            char c = bitstr.charAt(i);
            if (Character.toString(c).equals("1")) {
                sum = sum.add(b.getByIndex(i).getValue());
            }
            usedNode++;
        }
        return sum;
    }

    /**
     * Decrypt string.
     *
     * @param bi the bi
     * @return the string
     *  Big Theta(n*n) for all cases
     *  the for loop is n, and getByIndex is the other n
     *  Pre-condition: Pre-condition: private key list, q, r are initialized successfully,
     *  and use the same pair of private key to decrypt every digit of the input big integer
     *  Post-condition: return the original input, decrypted by private key
     */
    public String decrypt(BigInteger bi) {

        BigInteger target = r.modInverse(q).multiply(bi).mod(q);

        //find the maximum value that is smaller than val, and calculate the difference
        int[] result = new int[usedNode];
        BigInteger zero = BigInteger.valueOf(0);
        for (int i = usedNode - 1; target.compareTo(zero) != 0; i--) {
            BigInteger current = w.getByIndex(i).getValue();
            if (target.compareTo(current) >= 0) {
                target = target.subtract(current);
                //1 means this vaule is used when substracting
                result[i] = 1;
            }
        }
        //get rid of non-numeric symbol
        String str1 = Arrays.toString(result).replaceAll(", ", "");
        String str2 = str1.substring(1, str1.length());
        return bitToStr(str2);
    }

    /**
     * Str to bit string.
     *
     * @param str the str
     * @return the string
     *  Big Theta(n) for all cases
     *  Pre-condition: String is not null and not empty
     *  Post-condition: input String is converted into binary 01
     */
    public String strToBit(String str) {
        //char[] strChar=str.toCharArray();
        StringBuilder result= new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            StringBuilder temp = new StringBuilder(Integer.toBinaryString(str.charAt(j)));
            //if number of digit is less than 8, adding 0 in the front
            if (temp.length() < 8) {
                int count = 8 - temp.length();
                for (int i = 0; i < count; i++) {
                    temp.insert(0, "0");
                }
                result.append(temp);
            } else {
                result.append(temp);
            }
        }
        return result.toString();
    }

    /**
     * Bit to str string.
     *
     * @param str the str
     * @return the string
     *  Big Theta(n) for all cases
     *  Pre-condition: input is a binary string. not null, not empty
     *  Post-condition: binary representation of a string is converted into original string
     */
    public String bitToStr(String str) {
        String output = "";
        for(int i = 0; i <= str.length() - 8; i+=8)
        {
            int k = Integer.parseInt(str.substring(i, i+8), 2);
            output += (char) k;
        }
        return output;
    }


    /**
     * Key generation.
     *  Big Theta(n) for all cases
     *  Pre-condition: BITSIZE is valid
     *  Post-condition: public key, private key, q, r are generated for encrypt and decrypt
     */
    public void keyGeneration() {
        BigInteger current;
        BigInteger sum = BigInteger.valueOf(0);
        w = new DoublyIntegerLinkedList();
        b = new DoublyIntegerLinkedList();
        //generate private key (w)
        for (int i = 0; i < BITSIZE; i++) {
            current = sum.add(BigInteger.valueOf(1));
            sum = sum.add(current);
            w.addIntAtEnd(current);
        }
        //bigger than sum
        q = sum.add(BigInteger.valueOf(1));
        //co-prime to q
        r = findCoprime(q);
        //generate public key
        IntegerNode cur = w.getHead();
        while (cur != null) {
            BigInteger value = cur.getValue();
            BigInteger newNode = value.multiply(r).mod(q);
            b.addIntAtEnd(newNode);
            cur = cur.getNext();
        }
    }

    /**
     * Find coprime big integer.
     *
     * @param q the q
     * @return the big integer
     *  Big Theta(1) for all cases
     *  Pre-condition: q is valid and is larger enough
     *  Post-condition: a co-prime biginteger to the input is returned
     */
    public BigInteger findCoprime(BigInteger q) {
        BigInteger one = BigInteger.valueOf(1);
        Random random = new Random();
        BigInteger coprime;
        while (q.compareTo(one) > 0) {
            int num = random.nextInt(500); // change value to debug!!!!!
            BigInteger diff = BigInteger.valueOf(num);
            coprime = q.subtract(diff);
            if (q.gcd(coprime).compareTo(one) == 0) {
                return coprime;
            }
            q = coprime;
        }
        return null;
    }
}
