package lld;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Map<K, Long> accessMap;

    public LRUEvictionPolicy() {
        accessMap = new LinkedHashMap<>(16, 0.75f, true);
    }

    @Override
    public void notifyPut(K key) {
        accessMap.put(key, System.nanoTime());
    }

    @Override
    public void notifyGet(K key) {
        // No need to update access time for get operation in LinkedHashMap
    }

    @Override
    public K evict() {
        if (!accessMap.isEmpty()) {
            return accessMap.entrySet().iterator().next().getKey();
        }
        return null;
    }
}

