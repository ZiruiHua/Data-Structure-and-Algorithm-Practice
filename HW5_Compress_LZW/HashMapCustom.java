public class HashMapCustom<K, V> {
    private Entry<K, V>[] buckets;
    private int capacity;
    public HashMapCustom(int capacity){
        this.capacity = capacity;
        buckets = new Entry[capacity];
    }

    public void put(K newKey, V data){
        // create a new entry and get its hash value
        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
        int hashValue=hash(newKey);
        if (buckets[hashValue] == null) {
            // the first element
            buckets[hashValue] = newEntry;
        }
        else {
            // collision detected
            Entry<K,V> pointer = buckets[hashValue];
            // deal with puting multiple the same key into map
            if (pointer.key.equals(newKey)) {
                pointer.setValue(data);
                return;
            }
            // let the pointer point to the last entry stored in that bucket
            while (pointer.next != null) {
                // deal with puting multiple the same key into map
                if (pointer.key.equals(newKey)) {
                    pointer.setValue(data);
                    return;
                }
                pointer = pointer.next;
            }
            pointer.next = newEntry;
        }
    }

    public V get(K key) {
        int hashValue=hash(key);
        //not found
        if (buckets[hashValue] == null) {
            return null;
        }
        // walk through the linkedlist to find entry with that key
        Entry<K,V> pointer = buckets[hashValue];
        while (pointer != null) {
            if (pointer.key.equals(key)) {
                return pointer.value;
            } else {
                pointer = pointer.next;
            }
        }
        return null;
    }
    public int hash(K newKey) {
        return Math.abs(newKey.hashCode()) % capacity;
    }
    public void display(){

        for(int i=0;i<capacity;i++){
            if(buckets[i]!=null){
                Entry<K, V> entry=buckets[i];
                while(entry!=null){
                    System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry=entry.next;
                }
            }
        }
    }
    public boolean containsKey(K key) {
        if (get(key) != null) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>(57);
        hashMapCustom.put(21, 12);
        hashMapCustom.put(21, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("value corresponding to key 21="
                + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.print("Displaying : ");
        hashMapCustom.display();

    }

}
