
import java.util.LinkedList;

/**
 * The type Mst.
 */
// ref: http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
public class MST {

    /**
     * The Nodes.number of crimes in the list
     */
    int nodes;
    /**
     * The Graph. 2-d array recording distance between two records
     */
    double[][] graph;
    /**
     * Instantiates a new Mst.
     *
     * @param g the graph
     */
    public MST(Graph g) {
        // Construct a Graph instance by user input, graph object contains all the required graph info
        // a 2-d array represent distances between two records,
        // a list represents all records within the time range
        graph = g.graph;
        nodes = g.nodes;
    }

    /**
     * Prime int [ ].Find MST using Prim's algorithm
     *
     * @return the int [ ] is the MST by Prim's algorithm, root is the record of index 0
     */
    public int[] prime() {
        //store the index of parent of the current index
        // ex parent[1] = 2 means 2 is 1'parent
        int[] parent = new int[nodes];
        parent[0] = -1; //set 0 as the root
        // index is node value is distance
        double[] distance = new double[nodes];
        // if the index node is unvisited, its value is true
        boolean[] unvisited = new boolean[nodes];
        // set all distance max, and all nodes are unvisited
        for (int i = 0; i < nodes; i++) {
            distance[i] = Double.MAX_VALUE;
            unvisited[i] = true;
        }
        distance[0] = 0; // we can start from 0, 0 will be picked up at first
        //execute the snippet n-1 times
        for (int i = 0; i < nodes - 1; i++) {
            int start = minDistance(distance, unvisited); // find minimal distance from all unvisited nodes
            unvisited[start] = false; // mark it as visited
            //find any unvisited node can be reached from node,
            for (int end = 0; end < nodes; end++) {
                // not the node itself & unvisited & distance
                if (graph[start][end] != 0 && unvisited[end] == true && graph[start][end] < distance[end]) {
                    // mark parent of these picked up nodes
                    parent[end] = start;
                    // update distance
                    distance[end] = graph[start][end];
                }
            }
        }
        return parent;
    }

    /**
     * Min distance int.
     *
     * @param distance the distance
     * @param unvisited  the unvisited nodes
     * @return the int
     */
    public int minDistance(double distance[], boolean unvisited[]) {
        // Initialize min value
        double min = Double.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < nodes; i++)
            if (unvisited[i] == true && distance[i] < min) {
                min = distance[i];
                min_index = i;
            }
        return min_index;
    }


    /**
     * Print.
     *
     * @param list   the list
     * @param index  the index
     * @param result the result
     */
    //from node 0 to print tree using depth-first-search
    public void print(LinkedList[] list, int index, LinkedList result) {
        result.add(index);
        //if index doesn't have child, the index doesn't have a linked list
        //base case
        if (list[index] == null) {
            return;
        }
        for (int i = 0; i < list[index].size(); i++) {
            int next = (int) list[index].get(i);
            print(list, next, result);
        }
    }

    /**
     * Calculate length double.
     *
     * @param list the list
     * @return the double
     */
    public double calculateLength(LinkedList list) {
        double sum = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            sum += Math.sqrt(graph[(int) list.get(i)][(int) list.get(i + 1)]);
        }
        double f = 0.00018939;
        return sum * f;
    }

    /**
     * The entry point of application.
     *
     * @param mst the input arguments
     */
    public static LinkedList<Integer> entryPoint(MST mst) {

        System.out.println(" ");
        // result of Prim
        int[] parentArray = mst.prime();
        //index is parent, its children are stored in a linked list
        LinkedList[] res = new LinkedList[parentArray.length];
        for (int child = 1; child < parentArray.length; child++) {
            int parent = parentArray[child];
            //add child into its parent's linked list
            if (res[parent] != null) {
                //if list has already existed, add directly
                res[parent].add(child);
            } else {
                //if not, create one then add
                res[parent] = new LinkedList();
                res[parent].add(child);
            }
        }
        LinkedList<Integer> result = new LinkedList(); // pre-order result
        // get pre-order traversal of the MST
        mst.print(res, 0, result);
        // add 0 as start and end point
        result.add(result.size(), 0);
        result.add(0, 0);
        System.out.print("Hamiltonian Cycle (not necessarily optimum): ");
        for (int child = 1; child < result.size(); child++) {
            System.out.print(result.get(child) + " ");
        }
        System.out.println(" ");
        System.out.println("length of cycle: " + mst.calculateLength(result) + " miles");
        return result;
    }
}
