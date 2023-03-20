public class Association<K, V> {
    private K key;
    private V value;

    // Constructor
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter methods
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Setter methods
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}