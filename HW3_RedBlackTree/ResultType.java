import java.math.BigInteger;

/**
 * The type Result type.
 */
public class ResultType implements Comparable {
    /**
     * The Key.
     */
    String key;
    /**
     * The Value.
     */
    BigInteger value;

    /**
     * Instantiates a new Result type.
     *
     * @param key   the key
     * @param value the value
     */
    public ResultType(String key, BigInteger value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        ResultType other = (ResultType) o;
        if (this.key.compareTo(other.key) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return key + '\'' + value ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultType that = (ResultType) o;
        if (!key.equals(that.key)) return false;
        else return true;
        //return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
