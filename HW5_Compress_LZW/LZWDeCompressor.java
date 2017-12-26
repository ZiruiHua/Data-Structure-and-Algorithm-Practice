import java.io.*;

public class LZWDeCompressor {

    public String LZW_Decompress(String input) throws IOException {

        HashMapCustom<Integer, String> dictionary = new HashMapCustom<>(57);
        int dictSize = 256;
        int codeword;
        int priorCodeWord;
        byte[] buffer = new byte[3];
        boolean flag = true;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 256; i++) {
            dictionary.put(i, Character.toString((char) i));
        }

        DataInputStream in =
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(input)));
        try {
            // Gets the first word in code and outputs its corresponding char
            buffer[0] = in.readByte();
            buffer[1] = in.readByte();
            priorCodeWord = getvalue(buffer[0], buffer[1], flag);
            flag = !flag;
            res.append(dictionary.get(priorCodeWord));
            while (true) {
                // read current codeword
                if (flag) {
                    buffer[0] = in.readByte();
                    buffer[1] = in.readByte();
                    codeword = getvalue(buffer[0], buffer[1], flag);
                } else {
                    buffer[2] = in.readByte();
                    codeword = getvalue(buffer[1], buffer[2], flag);
                }
                flag = !flag;
                if (!dictionary.containsKey(codeword)) {
                    // not in the table
                    String temp = "";
                    if (dictSize < 4096) {
                        temp = dictionary.get(priorCodeWord)
                                + dictionary.get(priorCodeWord).charAt(0);
                        dictionary.put(dictSize, temp);
                    }
                    dictSize++;
                    res.append(dictionary.get(priorCodeWord) + temp);
                } else {
                    // in the table
                    if (dictSize < 4096) {
                        dictionary.put(dictSize, dictionary.get(priorCodeWord)
                                + dictionary.get(codeword).charAt(0));
                    }
                    dictSize++;
                    res.append(dictionary.get(codeword));
                }
                priorCodeWord = codeword;
            }
        } catch (EOFException e) {
            in.close();
        }
        return res.toString();
    }

    public int getvalue(byte b1, byte b2, boolean flag) {
        String temp1 = Integer.toBinaryString(b1);
        String temp2 = Integer.toBinaryString(b2);

        while (temp1.length() < 8) {
            temp1 = "0" + temp1;
        }
        if (temp1.length() == 32) {
            temp1 = temp1.substring(24, 32);
        }
        while (temp2.length() < 8) {
            temp2 = "0" + temp2;
        }
        if (temp2.length() == 32) {
            temp2 = temp2.substring(24, 32);
        }

        if (flag) {
            return Integer.parseInt(temp1 + temp2.substring(0, 4), 2);
        } else {
            return Integer.parseInt(temp1.substring(4, 8) + temp2, 2);
        }
    }

//    public static void main(String[] args) throws IOException {
//        try {
//            LZWDeCompressor lzw = new LZWDeCompressor();
//            PrintWriter outPrinter = new PrintWriter("123.mp4");
//            outPrinter.println(lzw.LZW_Decompress("zipped.txt"));
//            outPrinter.close();
//            System.out.println("Decompression of your file is complete!");
//        } catch (FileNotFoundException e) {
//        }
//    }
}