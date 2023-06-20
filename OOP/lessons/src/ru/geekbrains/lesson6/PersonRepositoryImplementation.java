package ru.geekbrains.lesson6;

import java.util.List;

public class PersonRepositoryImplementation implements PersonRepository {
    @Override
    public List<Person> getByAge(int age) {
        return null;
    }

    @Override
    public int add(Person item) {
        return 0;
    }

    @Override
    public int update(Person item) {
        return 0;
    }

    @Override
    public int remove(Integer integer) {
        return 0;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public Person getById(Integer integer) {
        return null;
    }
}
