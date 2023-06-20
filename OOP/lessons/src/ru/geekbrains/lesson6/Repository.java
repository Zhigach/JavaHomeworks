package ru.geekbrains.lesson6;

import java.util.List;

public interface Repository<T,TId>{

    int add(T item);

    int update(T item);

    int remove(TId id);

    List<T> getAll();

    T getById(TId id);

}
