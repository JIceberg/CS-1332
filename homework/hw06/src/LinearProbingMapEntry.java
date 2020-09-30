/**
 * Map entry class used for implementing the LinearProbingHashMap.
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class LinearProbingMapEntry<K, V> {

    private K key;
    private V value;
    private boolean removed;

    /**
     * Constructs a new LinearProbingMapEntry with the given key and value.
     * The removed flag is default set to false.
     *
     * @param key   the key for this entry
     * @param value the value for this entry
     */
    LinearProbingMapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    K getKey() {
        return key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    V getValue() {
        return value;
    }

    /**
     * Gets the removed status.
     *
     * @return true if the entry is marked as removed, false otherwise
     */
    boolean isRemoved() {
        return removed;
    }

    /**
     * Sets the key.
     *
     * @param key the new key
     */
    void setKey(K key) {
        this.key = key;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    void setValue(V value) {
        this.value = value;
    }

    /**
     * Sets the removed status.
     *
     * @param removed the new removed status
     */
    void setRemoved(boolean removed) {
        this.removed = removed;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", key.toString(), value.toString());
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        // DO NOT USE THIS METHOD IN YOUR CODE!  This is for testing ONLY!
        if (!(o instanceof LinearProbingMapEntry)) {
            return false;
        } else {
            LinearProbingMapEntry<K, V> that = (LinearProbingMapEntry<K, V>) o;
            return that.getKey().equals(key)
                    && that.getValue().equals(value)
                    && that.isRemoved() == removed;
        }
    }
}