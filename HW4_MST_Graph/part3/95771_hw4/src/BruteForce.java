import java.util.LinkedList;

/**
 * The type Brute force.
 */
public class BruteForce {
    /**
     * The Graph.
     */
    double[][] graph;
    /**
     * The Size. Size of the crime record
     */
    int size;

    /**
     * Instantiates a new Brute force.
     *
     * @param g the g
     */
    public BruteForce(Graph g) {
        this.graph = g.graph;
        this.size = g.graph.length;
    }

    /**
     * Permutation. Get all possible paths
     *
     * @param temp   the temp
     * @param result the result
     */
    public void permutation(LinkedList<Integer> temp, LinkedList<LinkedList<Integer>> result) {
        // if temp size equals to number of records
        if (temp.size() == size) {
            // base case, deep copy the temp into result
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < size; i++) {
            // avoid duplicate
            if (temp.contains(i)) {
                continue;
            }
            // backtracking
            temp.add(i);
            permutation(temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Calculate length double.
     * Calculate the path of length
     * @param list the list
     * @return the double
     */
    public double calculateLength(LinkedList<Integer> list) {
        double sum = 0;
        // Calculate the path of length
        for (int i = 0; i < list.size() - 1; i++) {
            sum += Math.sqrt(graph[list.get(i)][list.get(i + 1)]);
        }
        double f = 0.00018939;
        return sum * f;
    }
    /**
     * Entry point linked list.
     *
     * @param bf the bf
     * @return the linked list
     */
    public static LinkedList<Integer> entryPoint(BruteForce bf) {

        // result contains all path by permutation
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        // a temporary list
        LinkedList<Integer> temp = new LinkedList<>();
        // calculate permutation path
        bf.permutation(temp, result);
        // record shortestPath and its length
        LinkedList<Integer> shortestPath = null;
        double shortestDistance = Double.MAX_VALUE;
        // check every path and find the shortest one
        for (LinkedList<Integer> list1 : result) {
            // set start point as the end point
            list1.add(list1.get(0));
            // update shortest length
            if (bf.calculateLength(list1) < shortestDistance) {
                shortestDistance = bf.calculateLength(list1);
                shortestPath = list1;
            }
        }
        System.out.println(" ");
        System.out.println("Looking at every permutation to find the optimal solution");
        System.out.println("The best permutation");
        System.out.println(shortestPath);
        System.out.println("Optimal Cycle length = " + shortestDistance + " miles");
        return shortestPath;
    }
}
