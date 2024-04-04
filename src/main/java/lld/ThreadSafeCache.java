package lld;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCache<K, V> {
    private final Map<K, CacheEntry<V>> cache;

    public ThreadSafeCache() {
        cache = new ConcurrentHashMap<>();
    }

    public void put(K key, V value) {
        cache.put(key, new CacheEntry<>(value, -1));
    }

    public void put(K key, V value, long expirationTime) {
        cache.put(key, new CacheEntry<>(value, System.currentTimeMillis() + expirationTime));
    }

    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        if (entry != null && !entry.isExpired()) {
            return entry.getValue();
        } else {
            cache.remove(key);
            return null;
        }
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }
}


class CacheEntry<V> {
    private final V value;
    private final long expirationTime;

    public CacheEntry(V value, long expirationTime) {
        this.value = value;
        this.expirationTime = expirationTime;
    }

    public V getValue() {
        return value;
    }

    public boolean isExpired() {
        return expirationTime > 0 && System.currentTimeMillis() > expirationTime;
    }
}

