class Entry<K, V> {
    K key;
    V value;
    Entry<K,V> next; // pointer of the next entry

    public Entry(K key, V value, Entry<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public void setValue(V new_value) {
        this.value = new_value;
    }
}
