package org.migatotech.dal;

import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ARepository<T> implements IRepository<T> {

    private final Map<CommandActions, List<T>> temporalStorage = new ConcurrentHashMap<>();
    protected final DSLContext dbContext;

    public List<T> getAddStorageItems() {
        return new ArrayList<>(temporalStorage.get(CommandActions.ADD));
    }

    public List<T> getUpdateStorageItems() {
        return new ArrayList<>(temporalStorage.get(CommandActions.MODIFY));
    }

    public List<T> getDeleteStorageItems() {
        return new ArrayList<>(temporalStorage.get(CommandActions.DELETE));
    }

    protected ARepository(DSLContext context) {
        temporalStorage.put(CommandActions.ADD, new ArrayList<>());
        temporalStorage.put(CommandActions.MODIFY, new ArrayList<>());
        temporalStorage.put(CommandActions.DELETE, new ArrayList<>());
        dbContext = context;
    }

    public void add(T entity) {
        var addList = temporalStorage.get(CommandActions.ADD);
        addList.add(entity);
        temporalStorage.put(CommandActions.ADD, addList);
    }

    public void modify(T entity) {
        var modifyList = temporalStorage.get(CommandActions.MODIFY);
        modifyList.add(entity);
        temporalStorage.put(CommandActions.MODIFY, modifyList);
    }

    public void remove(T entity) {
        var deleteList = temporalStorage.get(CommandActions.DELETE);
        deleteList.add(entity);
        temporalStorage.put(CommandActions.DELETE, deleteList);
    }

    public void clear() {
        temporalStorage.replace(CommandActions.ADD, new ArrayList<>());
        temporalStorage.replace(CommandActions.MODIFY, new ArrayList<>());
        temporalStorage.replace(CommandActions.DELETE, new ArrayList<>());
    }
}

