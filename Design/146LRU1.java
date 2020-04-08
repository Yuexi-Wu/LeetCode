class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    //LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
    //Constructs an empty LinkedHashMap instance with the specified initial capacity, load factor and ordering mode.
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    //public V getOrDefault(Object key, V defaultValue)
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    /**
    *protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
Returns true if this map should remove its eldest entry. This method is invoked by put and putAll after inserting a new entry into the map. It provides the implementor with the opportunity to remove the eldest entry each time a new one is added. This is useful if the map represents a cache: it allows the map to reduce memory consumption by deleting stale entries.
Example:
protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
     }
     
     Returns:
true if the eldest entry should be removed from the map; false if it should be retained.
    */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
