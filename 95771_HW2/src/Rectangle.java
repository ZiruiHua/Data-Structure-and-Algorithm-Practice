public class Rectangle {
    double xmin;
    double xmax;
    double ymin;
    double ymax;
    public Rectangle(double xmin, double xmax, double ymin, double ymax) {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
    }

    public boolean ifContains(Node node) {
        if (node.key[0] > xmin && node.key[0] < xmax
                && node.key[1] > ymin && node.key[1] < ymax) {
            return true;
        }
        return false;
    }
}
