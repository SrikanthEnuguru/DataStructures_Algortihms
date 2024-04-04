package lld;

import java.util.Map;
import java.util.concurrent.*;

public class FlexibleCache<K, V> {
    private final Map<K, V> cache;
    private final EvictionPolicy<K> evictionPolicy;
    private final ExecutorService evictionExecutor;

    public FlexibleCache(EvictionPolicy<K> evictionPolicy) {
        this.cache = new ConcurrentHashMap<>();
        this.evictionPolicy = evictionPolicy;
        this.evictionExecutor = Executors.newSingleThreadExecutor();
    }

    public void put(K key, V value) {
        cache.put(key, value);
        evictionExecutor.execute(() -> {
            evictionPolicy.notifyPut(key);
            evict();
        });
    }

    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            evictionExecutor.execute(() -> evictionPolicy.notifyGet(key));
        }
        return value;
    }

    private void evict() {
        K keyToRemove = evictionPolicy.evict();
        if (keyToRemove != null) {
            cache.remove(keyToRemove);
        }
    }

    public void shutdown() {
        evictionExecutor.shutdown();
    }
}

