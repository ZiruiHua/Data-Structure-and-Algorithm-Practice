import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TwoDTreeDriver {
    public static void main(String[] args) throws FileNotFoundException {
        Node root = initialTree();
        boolean flag = true;
        while(flag) {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What would you like to do:");
            System.out.println("1:");
            System.out.println("2:");
            System.out.println("6: search for points within rectangle");

            String input = null;
                try {
                    input = b.readLine();
                    if (input.equals("1")) {
                        System.out.println("choose 1");
                    }
                    else if (input.equals("2")) {
                        System.out.println("choose 1");
                    }
                    else {
                        flag = false;
                        System.out.println("Thank you for exploring Pittsburgh crimes in the 1990's");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
    public static Node initialTree() {
        TwoDTree tree = new TwoDTree();
        Path questionPath = Paths.get("CrimeLatLonXY.csv");
        File questionFile = questionPath.toFile();
        FileReader reader;
        BufferedReader br;
        String columns[] = null;
        try {
            reader = new FileReader(questionFile);
            br = new BufferedReader(reader);
            String str = null;
            try {
                while ((str = br.readLine()) != null) {
                    columns = str.split("\\,");
                    try {
                        double x = Double.parseDouble(columns[0].trim());
                        double y = Double.parseDouble(columns[1].trim());
                        String value = columns[2] + "," + columns[3] + "," + columns[4] + "," + columns[5]
                                + "," + columns[6] + "," + columns[7] + "," + columns[8];
                        double[] d = {x, y};
                        //add value latter
                        tree.insert(d);
                        System.out.println("value is: " + value);
                    } catch (NumberFormatException e) {
                        System.out.println("first line");
                        continue;
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return tree.root;
    }
}
