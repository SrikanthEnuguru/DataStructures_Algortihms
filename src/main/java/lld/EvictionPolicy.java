package lld;

public interface EvictionPolicy<K> {
    void notifyPut(K key);
    void notifyGet(K key);
    K evict();
}

