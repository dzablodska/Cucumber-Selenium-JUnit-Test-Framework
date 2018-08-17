package com.nat.facebook.qa.utils;

import com.nat.facebook.qa.annotation.QAComponent;

import java.util.HashMap;
import java.util.Map;

@QAComponent
public class DataStore {
    private static Map<String, Object> map;

    /**
     * Resets the storage
     */
    public void clear() {
        getMap().clear();
    }

    /**
     * Adds an object to the map.
     *
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        getMap().put(key, value);
    }

    /**
     * Returns the object matching the specified key.
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key) {
        return (T) getMap().get(key);
    }

    /**
     * Internal method used to access the thread-local map and initialize it (if not yet initialized).
     *
     * @return
     */
    private Map<String, Object> getMap() {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }
}
