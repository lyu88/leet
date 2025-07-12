class LRUCache {
    int maxSize;
    HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > maxSize;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// 仅仅remove the size overflow是不够的
// 这里缺少access order
class LRUCache {
    int maxSize;
    HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        map = new LinkedHashMap<>(capacity) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                return size() > maxSize;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */