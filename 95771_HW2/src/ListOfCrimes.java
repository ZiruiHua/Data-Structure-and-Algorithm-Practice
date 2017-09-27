public class ListOfCrimes {
    Node[] result;
    private int size;
    private int currentCapacity;
    public ListOfCrimes() {
        this.size = 0;
        this.result = new Node[5];
        this.currentCapacity = 5;
    }
    public ListOfCrimes(int initialCpacity) {
        this.size = 0;
        this.result = new Node[initialCpacity];
        this.currentCapacity = initialCpacity;
    }
    public Node get(int index) {
        if (index <= result.length - 1) {
            return result[index];
        } else {
            return null;
        }
    }

    public void add(Node node) {
        if (this.size == this.currentCapacity) {
            this.result = expand();
            result[size] = node;
        } else {
            result[size] = node;
        }
        size++;
    }
    private Node[] expand() {
        Node[] temp = new Node[currentCapacity*2 + 1];
        for (int i = 0; i < size; i++) {
            temp[i] = result[i];
            this.result[i] = null;
        }
        currentCapacity = currentCapacity*2 + 1;
        return temp;
    }

    public int size() {
        return this.size;
    }
}
