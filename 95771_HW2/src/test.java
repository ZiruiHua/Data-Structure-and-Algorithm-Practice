
public class test {
    public static void main(String[] args) {
        ListOfCrimes list = new ListOfCrimes();
        double points[][] = {{3, 6}, {17, 15}, {13, 15}, {6, 12},
                {9, 1}, {2, 7}, {10, 19}};
        for (double[] cur : points) {
            list.add(new Node(cur, 0));
        }
        System.out.println("size: " +list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(": " + list.get(i).toString());

        }
    }
}
