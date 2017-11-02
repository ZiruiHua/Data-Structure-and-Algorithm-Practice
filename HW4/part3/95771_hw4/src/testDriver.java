import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class testDriver {
    public static void main(String[] args) throws IOException {
        // get input
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Start date");
        String start = b.readLine();
        System.out.println("Enter end date");
        String end = b.readLine();
        System.out.println("Crime Records between " + start + " and " + end);
        Graph g = new Graph(start, end);

        //Graph g = new Graph("1/14/90", "1/15/90");
        // print information in CSV
        for (Crime c : g.array) {
            System.out.println(c.getInfo());
        }
        MST mst = new MST(g);
        BruteForce bf = new BruteForce(g);
        // run MST and brute force
        LinkedList<Integer> MST_result = MST.entryPoint(mst);
        LinkedList<Integer> Brute_result = BruteForce.entryPoint(bf);
        // change array into linkedlist
        LinkedList<Crime> crimes = new LinkedList<>();
        for (Crime c : g.array) {
            crimes.add(c);
        }
        // write into kml file
        KMLFile.toKML(MST_result, Brute_result, crimes);
    }
}
