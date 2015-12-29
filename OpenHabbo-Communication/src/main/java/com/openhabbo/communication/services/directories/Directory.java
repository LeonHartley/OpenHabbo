package com.openhabbo.communication.services.directories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Directory<K, V> {

    private final Map<K, V> directory;

    public Directory() {
        this.directory = new ConcurrentHashMap<>();
    }

    public V get(K key) {
        return this.directory.get(key);
    }

    public void put(K key, V value) {
        this.directory.put(key, value);
    }

    public void remove(K key) {
        this.directory.remove(key);
    }

    public void update(Map<K, V> directory) {
        this.directory.clear();
        this.directory.putAll(directory);
    }
}
