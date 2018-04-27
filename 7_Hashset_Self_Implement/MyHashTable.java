
public class MyHashTable implements MyHTInterface {
    /**
     * The Array.
     */
    private DataItem[] array;
    /**
     * The Load factor.
     */
    private double loadFactor = 0.5;
    /**
     * Collsion Count.
     */
    private int collsionCount = 0;
    /**
     * Number of data.
     */
    private int count = 0;
    /**
     * Number of factor when calculating hashvalue.
     */
    private static final int FACTOR = 27;

    /**
     * Instantiates a new My hash table.
     */
    public MyHashTable() {
        array = new DataItem[10];
    }

    /**
     * Instantiates a new My hash table.
     *
     * @param size the size
     */
    public MyHashTable(int size) {
        if (size <= 0) {
            throw new RuntimeException("size error");
        }
        array = new DataItem[size];
    }
    /**
     * Inserts a new String value (word).
     * Frequency of each word to be stored too.
     * @param value String value to add
     */
    public void insert(String value) {
        if (!isWord(value)) {
            return;
        }
        // if collision happens, flag will be set to true
        boolean flag = false;
        int hashValue = hashFunc(value);
        int index = hashValue;
        while (array[index] != null && !array[index].isDelete) {
            if (array[index].value.equals(value)) {
                // if we meet the same value more than once, add frequency and quit
                array[index].frequency++;
                return;
            }
            // collision happens rather than meeting the probe of other elements
            if (hashFunc(array[index].value) == hashValue) {
                flag = true;
            }
            index += 1;
            index = index % this.array.length;
        }
        if (flag) {
            this.collsionCount++;
        }
        array[index] = new DataItem(value);
        this.count += 1;
        // rehash
        if ((double) this.count / this.array.length > this.loadFactor) {
            rehash();
        }
    }

    /**
     * Returns the number of collisions in relation to insert and rehash.
     * @return number of collisions
     */
    public int numOfCollisions() {
        return this.collsionCount;
    }
    /**
     * Returns the frequency of a key String.
     * @param key string value to find its frequency
     * @return frequency value if found. If not found, return 0
     */
    public int showFrequency(String key) {
        int code = hashFunc(key);

        while (array[code] != null) {
            if (array[code].value.equals(key)) {
                // when meeting deleted key, return 0
                if (array[code].isDelete) {
                    return 0;
                }
                return array[code].frequency;
            }
            code += 1;
            code = code % array.length;
        }
        return 0;
    }
    /**
     * Removes and returns removed value.
     * @param key String to remove
     * @return value that is removed. If not found, return null
     */
    public String remove(String key) {
        // if not found
        if (this.showFrequency(key) == 0) {
            return null;
        }
        int code = hashFunc(key);
        // prevent delete items have been deleted
        while (array[code] != null && !array[code].isDelete) {
            if (array[code].value.equals(key)) {
                if (array[code].isDelete) {
                    return null;
                }
                String res = array[code].value;
                // remove
                array[code].isDelete = true;
                this.count--;
                return res;
            }
            code += 1;
            code = code % array.length;
        }
        return null;
    }
    /**
     * Returns true if value is contained in the table.
     * @param key String key value to search
     * @return true if found, false if not found.
     */
    public boolean contains(String key) {
        // if not found
        if (this.showFrequency(key) == 0) {
            return false;
        }
        return true;
    }
    /**
     * Returns the size, number of items, of the table.
     * @return the number of items in the table
     */
    public int size() {
        return this.count;
    }
    /**
     * Displays the values of the table.
     * If an index is empty, it shows **
     * If previously existed data item got deleted, then it should show #DEL#
     */
    public void display() {
        for (DataItem d : this.array) {
            if (d == null) {
                System.out.print("** ");
            } else if (d.isDelete) {
                System.out.print("#DEL# ");
            } else {
                System.out.print("[" + d.value + ", " + d.frequency + "] ");
            }
        }
        System.out.println("");
    }

    /**
     * Returns the hash value of a String.
     * Assume that String value is going to be a word with all lowercase letters.
     * @param input value for which the hash value should be calculated
     * @return int hash value of a String
     */
    private int hashFunc(String input) {
        char[] p = input.toCharArray();
        int result = 0;
        for (int i = 0; i < p.length; i++) {
            // lower case
            if (p[i] >= 'a' && p[i] <= 'z') {
                result = ((p[i] - 96) + (FACTOR * result)) % this.array.length;
            } else {
                // upper case
                result = ((p[i] - 64) + (FACTOR * result)) % this.array.length;
            }
        }
        return result;
    }

    /**
     * A public hash function.
     * @param input input string for which the hash value needs to be calculated
     * @return int hash value of the input string
     */
    public int hashValue(String input) {
        return hashFunc(input);
    }

    /**
     * doubles array length and rehash items whenever the load factor is reached.
     */
    private void rehash() {
//        System.out.println("before rehash");
//        this.display();

        int rehashCount = 0;
        this.collsionCount = 0;
        int newSize = nextPrime(this.array.length * 2);
        DataItem[] temp = this.array;
        this.array = new DataItem[newSize];
        for (int i = 0; i < temp.length; i++) {
            DataItem cur = temp[i];
            if (cur == null || cur.isDelete) {
                continue;
            }
            boolean flag = false;
            int hashValue = hashFunc(cur.value);
            int index = hashValue;
            while (this.array[index] != null) {
                if (hashValue == hashFunc(this.array[index].value)) {
                    flag = true;
                }
                index += 1;
                index = index % this.array.length;
            }
            if (flag) {
                this.collsionCount++;
            }

            this.array[index] = cur;
            if (index != i) {
                rehashCount++;
            }
        }

        System.out.println("Rehash " + rehashCount + " times, new length is " + this.array.length);

    }
    /**
     * Check is a string is a valid word.
     * @param str target string
     * @return true if str is a valid word
     */
    private boolean isWord(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find the next prime number larger than input.
     *
     * @param input : target integer
     * @return the int
     */

    public int nextPrime(int input) {
        int counter;
        input++;
        while (true) {
            counter = 0;
            for (int i = 2; i <= Math.sqrt(input); i++) {
                if (input % i == 0) {
                    counter++;
                }
            }
            if (counter == 0) {
                return input;
            } else {
                input++;
                continue;
            }
        }
    }


    /**
     * private static data item nested class.
     */
    private static class DataItem {
        /**
         * String value.
         */
        private String value;
        /**
         * String value's frequency.
         */
        private int frequency;
        /**
         * If this instance is deleted.
         */
        private boolean isDelete;

        /**
         * Instantiates a new Data item.
         *
         * @param str the str
         */
        public DataItem(String str) {
            this.value = str;
            this.frequency = 1;
            this.isDelete = false;
        }

    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        MyHashTable table = new MyHashTable(37);
        System.out.println(table.hashValue("Learned"));
        System.out.println(table.hashValue("learned"));

//        table.insert("increase");
//        table.insert("creeping");
//        table.insert("everything");
//        table.insert("ourselves");
//        table.insert("himself");
//        table.insert("finished");
//        table.insert("seventh");
//        table.insert("learned");
//        table.insert("learned");
//        table.insert("creeping");
//        table.insert("receive");
//        table.display();
//        String testValue = new String("Learned");
//
//        if (table.contains(testValue)) {
//            System.out.println("Found: 'finished'");
//        } else {
//            System.out.println("Cannot find: 'finished'");
//        }

    }
}
