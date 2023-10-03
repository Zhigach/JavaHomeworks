package SoftwareArchitecture.Lesson2.Factory;

import java.util.*;

public class Store {
    int capacity;
    List<StoreItem> storage;
    List<ItemFactory> factories;

    private boolean isFull(){
        return storage.size() >= capacity;
    }

    public void addFactory (ItemFactory newFactory) {
        factories.add(newFactory);
    }

    public void restoreRandom(){
        Random random = new Random();
        while (!isFull()) {
            ItemFactory randomFactory = factories.get(random.nextInt(factories.size()));
            storage.add(randomFactory.createItem());
        }
    }

    public Store(int capacity) {
        this.capacity = capacity;
        this.factories= new ArrayList<>();
        this.storage = new ArrayList<>();
    }

    public void showStorage() {
        for (StoreItem storeItem : storage) {
            System.out.println(storeItem);
        }
    }
}
