package org.migatotech.dal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryDbContext {
    private final Map<String, String> persistentStorage = new HashMap<>();

    public void put(String key, String value) {
        persistentStorage.put(key, value);
    }

    public void replace(String key, String value) {
        persistentStorage.replace(key, value);
    }

    public void remove(String key) {
        persistentStorage.remove(key);
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return persistentStorage.entrySet();
    }

}
