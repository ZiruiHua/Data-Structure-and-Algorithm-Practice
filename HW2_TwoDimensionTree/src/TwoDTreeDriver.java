import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TwoDTreeDriver {
    public static void main(String[] args) throws FileNotFoundException {
        //initial the tree by crime data
        TwoDTree tree = initialTree();
        Node root = tree.root;
        boolean flag = true;
        System.out.println("Crime file loaded into 2d tree with " + tree.rangeSearchCount + " records.");
        while(flag) {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What would you like to do:");
            System.out.println("1: inorder");
            System.out.println("1: preorder");
            System.out.println("1: postorder");
            System.out.println("4: levelorder");
            System.out.println("5: reverseLevelOrder");
            System.out.println("6: search for points within rectangle");
            System.out.println("7: search for nearest point");
            System.out.println("8: quit");
            String input = null;
                try {
                    input = b.readLine();
                    if (input.equals("1")) {
                        tree.inOrderPrint();
                    }
                    else if (input.equals("2")) {
                        tree.preOrderPrint();
                    }
                    else if (input.equals("3")) {
                        tree.postOrderPrint();
                    }
                    else if (input.equals("4")) {
                        tree.levelorderPrint();
                    }
                    else if (input.equals("5")) {
                        tree.reverseLevelOrderPrint();
                    }
                    else if (input.equals("6")) {
                        BufferedReader b1= new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Enter a rectangle bottom left (X1,Y1) and top right (X2, Y2) as four doubles each separated by a space.\n");
                        String input2 = b1.readLine();
                        String[] coor = input2.split(",");
                        ListOfCrimes list = tree.findPointsInRange(Double.parseDouble(coor[0]), Double.parseDouble(coor[1]), Double.parseDouble(coor[2]), Double.parseDouble(coor[3]));
                        //ListOfCrimes list = tree.findPointsInRange(1357605.688, 411838.5393, 1358805.688, 413038.5393);
                        System.out.println("Searching for points within (" + Double.parseDouble(coor[0]) +" ," + Double.parseDouble(coor[1]) + ") and ("+
                                        Double.parseDouble(coor[2]) +" ," + Double.parseDouble(coor[3]) + ")");
                        System.out.println("Examined " + tree.rangeSearchCount + " nodes during search");
                        System.out.println("Found " + list.size() + " crimes");

                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("found: " + list.get(i).toString());
                        }
                        list.toKML();
                    }
                    else if (input.equals("7")) {
                        tree.preOrderPrint();
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
    public static TwoDTree initialTree() {
        TwoDTree tree = new TwoDTree();
        //read data from crime csv
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
                        //0,1 are the coordinates x, y, 2-8 are other information according to the data
                        double x = Double.parseDouble(columns[0].trim());
                        double y = Double.parseDouble(columns[1].trim());
                        String value = columns[2] + "," + columns[3] + "," + columns[4] + "," + columns[5]
                                + "," + columns[6] + "," + columns[7] + "," + columns[8];
                        double[] d = {x, y};
                        //add value into the tree
                        tree.insert(d, value);
                        //System.out.println("value is: " + value);
                    } catch (NumberFormatException e) {
                        //skip the first line
                        continue;
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return tree;
    }
}
