/**
 * The type Crime.
 */
public class Crime {
    private double X;
    private double Y;
    private int index;
    private String info;

    /**
     * Instantiates a new Crime.
     *
     * @param x     the x
     * @param y     the y
     * @param index the index
     * @param info  the info
     */
    public Crime(double x, double y, int index, String info) {
        X = x;
        Y = y;
        this.index = index;
        this.info = info;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return X;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(double x) {
        X = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return Y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) {
        Y = y;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets index.
     *
     * @param index the index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets info.
     *
     * @param info the info
     */
    public void setInfo(String info) {
        this.info = info;
    }
}
