import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class testDriver {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Start date");
        String start = b.readLine();
        System.out.println("Enter end date");
        String end = b.readLine();
        System.out.println("Crime Records between " + start + " and " + end);
        Graph g = new Graph(start, end);

        //Graph g = new Graph("1/14/90", "1/15/90");

        for (Crime c : g.array) {
            System.out.println(c.getInfo());
        }
        MST mst = new MST(g);
        BruteForce bf = new BruteForce(g);

        LinkedList<Integer> MST_result = MST.entryPoint(mst);
        //LinkedList<Integer> Brute_result = BruteForce.entryPoint(bf);
        //LinkedList<Crime> crimes = mst.list;
        //KMLFile.toKML(MST_result, Brute_result, crimes);
    }
}
