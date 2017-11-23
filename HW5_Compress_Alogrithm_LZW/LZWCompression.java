
import java.io.*;
import java.util.HashMap;

public class LZWCompression {
    public void LZW_Compress(String infile, String outfile) throws IOException {
        HashMapCustom<String, Integer> dict = new HashMapCustom<>(57);
        //HashMap<String, Integer> dict = new HashMap<>();
        byte[] buffer = new byte[3];
        boolean flag = true;
        int dictSize = 256;
        for (int i = 0; i < dictSize; i++) {
            // char to string, put into dict
            dict.put("" + (char) i, i);
        }
        DataInputStream in =
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(infile)));
        DataOutputStream out =
                new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(outfile)));

        byte byteIn;
        String s_string = "";
        try {
            // initialize s
            byteIn = in.readByte();
            s_string = "" + (char) (byteIn);
            while (true) {
                // c
                byteIn = in.readByte();
                String c_string = "" + (char) (byteIn&0XFF);
                String new_comb = s_string + c_string;
                if (dict.containsKey(new_comb)) {
                    s_string = new_comb;
                } else {
                    int compressed = dict.get(s_string);
                    if (flag) {
                        buffer[0] = (byte) (compressed >> 4);
                        buffer[1] = (byte) (compressed << 4);
                    } else {
                        buffer[1] += (byte) (compressed >> 8);
                        buffer[2] = (byte)compressed;
                        //write and clear buffer
                        for (int i = 0; i < buffer.length; i++) {
                            out.writeByte(buffer[i]);
                            buffer[i] = 0;
                        }
                    }
                    flag = !flag;
                    // 2^12 detect overflow
                    if (dictSize < 4096) {
                        //System.out.println("Enter " + new_comb + " into dict");
                        dict.put(new_comb, dictSize++);
                    } else {
                        // process overflow
                    }
                    s_string = c_string;
                }
            }
        } catch (EOFException e) {
            // hitting EOF
            System.out.println("Reach End " + s_string);
            int compressed = dict.get(s_string);
            if (flag) {
                buffer[0] = (byte) (compressed >> 4);
                buffer[1] = (byte) (compressed << 4);
            } else {
                buffer[1] += (byte) (compressed >> 8);
                buffer[2] = (byte)compressed;
                //write and clear buffer
                for (int i = 0; i < buffer.length; i++) {
                    out.writeByte(buffer[i]);
                    buffer[i] = 0;
                }
                in.close();
                out.close();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        // the program works for binary and ascii files since i read in by bytes
        // words.html 1.3 Mb -> 778 Kb
        // crime.csv 2.6 mb -> 2.2 mb
        // mp4 37.3 mb -> 36.2 mb
        if (args.length == 3) {
            try{
                if (args[0].equals("c")) {
                    LZWCompression lzw = new LZWCompression();
                    lzw.LZW_Compress(args[1], args[2]);
                } else if (args[0].equals("d")) {
                    LZWDeCompressor lzwDeCompressor = new LZWDeCompressor();
                    PrintWriter outPrinter = new PrintWriter(args[2]);
                    outPrinter.println(lzwDeCompressor.LZW_Decompress(args[1]));
                    outPrinter.close();
                } else {
                    System.out.println("Input wrong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
