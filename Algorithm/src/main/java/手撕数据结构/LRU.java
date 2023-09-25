package 手撕数据结构;

import java.util.LinkedHashMap;

class LRUCache extends LinkedHashMap<Integer,Integer> {
    private static final long serialVersionUID = -5732805054182707877L;

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        // getOrDefault()方法的作用是：当Map集合中有这个key时，就使用这个key值；
        // 如果没有就使用默认值defaultValue。
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }
}
public class LRU {
}
