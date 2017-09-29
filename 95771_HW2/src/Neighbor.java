public class Neighbor {
    private Node pointer;
    private double distance;
    public Neighbor() {
        pointer = null;
        distance = Double.MAX_VALUE;
    }
    public void setPointer(Node node) {
        pointer = node;
    }


}
