package part4;

import java.math.BigInteger;

public class test {
    public static void main(String[] args) {
//        o decrypt, Bob multiplies 1129 by r −1 mod q
//        1129 * 442 mod 881 = 372
        BigInteger r = new BigInteger(588+"");
        BigInteger q = new BigInteger(881+"");
        BigInteger bi = new BigInteger(1129+"");
        System.out.println(r.modInverse(q).multiply(bi).mod(q));
    }
}
