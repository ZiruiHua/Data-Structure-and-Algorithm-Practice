import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * The type List of crimes.
 */
public class ListOfCrimes {
    /**
     * The Result is the array storing selected Node
     */
    Node[] result;
    private int size;
    private int currentCapacity;

    /**
     * Instantiates a new List of crimes with the size 5
     */
    public ListOfCrimes() {
        this.size = 0;
        this.result = new Node[5];
        this.currentCapacity = 5;
    }

    /**
     * Instantiates a new List of crimes.
     * This constructor allows users to customize initial capacity
     * @param initialCpacity the initial cpacity
     */
    public ListOfCrimes(int initialCpacity) {
        this.size = 0;
        this.result = new Node[initialCpacity];
        this.currentCapacity = initialCpacity;
    }

    /**
     * Get node by index
     * pre-condition: The crime list is successfully constructed
     * post-conditoon: A node in the list is returned by its index
     * @param index the index
     * @return the node
     */
    public Node get(int index) {
        if (index <= result.length - 1) {
            return result[index];
        } else {
            return null;
        }
    }

    /**
     * Add.
     *
     * pre-condition: The crime list is successfully constructed
     * post-conditoon: A node is added into the end of the list. and size of the list plus one
     * @param node the node
     */
    public void add(Node node) {
        //if reach capacity, call expand method to expand the capacity of the list
        if (this.size == this.currentCapacity) {
            this.result = expand();
            result[size] = node;
        } else {
            //add the node into the end of the list
            result[size] = node;
        }
        size++;
    }
    /**
     * expand, double the capacity of the list.
     *
     * pre-condition: The crime list is successfully constructed and the number of nodes reaches capacity
     * post-conditoon: The capacity of the list doubled by the previous one
     * @param node the node
     */
    private Node[] expand() {
        Node[] temp = new Node[currentCapacity*2 + 1];
        //copy nodes from old shorter list to new longer list and dismiss the old one
        for (int i = 0; i < size; i++) {
            temp[i] = result[i];
            this.result[i] = null;
        }
        //update capacity info
        currentCapacity = currentCapacity*2 + 1;
        return temp;
    }

    /**
     * Size int.
     * pre-condition: The crime list is successfully constructed
     * post-conditoon: Return the number of nodes in this list
     * @return the int
     */
    public int size() {
        return this.size;
    }

    /**
     * To kml.
     * pre-condition: The crime list is successfully constructed
     * post-conditoon: Write the node in the list currently into a kml file according to KML syntax
     *                  node info is written into placemark tag
     */
    public void toKML() {
        System.out.println("aaaaa:" + result.length);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("PGHCrimes.kml"));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            bw.write("<kml xmlns=\"http://earth.google.com/kml/2.2\">\n");
            bw.write("<Document>\n");
            bw.write("<Style id=\"style1\">\n");
            bw.write("<IconStyle>\n");
            bw.write("<Icon>\n");
            bw.write("<href>http://maps.gstatic.com/intl/en_ALL/mapfiles/ms/micons/blue-dot.png</href>\n");
            bw.write("</Icon>\n");
            bw.write("</IconStyle>\n");
            bw.write("</Style>\n");
            for (Node node : result) {
                if (node == null) {
                    continue;
                }
                String value = node.value;
                try {
                    String[] val = value.split(",");
                    bw.write("<Placemark>\n");
                    bw.write("<name>" + val[2] + "</name>\n");
                    bw.write("<description>" + val[1] + "</description>\n");
                    bw.write("<styleUrl>#style1</styleUrl>\n");
                    bw.write("<Point>\n");
                    bw.write("<coordinates>" + val[4] + "," + val[5] + "，0.000000" + "</coordinates>\n");
                    bw.write("</Point>\n");
                    bw.write("</Placemark>\n");
                } catch (Exception e) {
                    System.out.println("split error");
                }
            }
            bw.write("</Document>\n");
            bw.write("</kml>\n");

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Writing error.");
        }
    }
    /**
     * toString().
     * pre-condition: The crime list is successfully constructed
     * post-conditoon: Return a string that concate all nodes
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : result) {
            sb.append(node.toString() + "--");
        }
        return sb.toString();
    }


}
