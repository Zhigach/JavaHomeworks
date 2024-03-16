package ru.gb;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Physics", 500);
        Course course2 = new Course("Lyrics", 555);
        Course course3 = new Course("Scram", 5);

        //add record to database
        DBAdapter.addEntity(course1);
        DBAdapter.addEntity(course2);
        DBAdapter.addEntity(course3);

        //read all records
        DBAdapter.readRecords();

        //update entry
        DBAdapter.updateEntity(3, "Poetry", 1);
        DBAdapter.readRecords();

        //delete all records from database
        DBAdapter.removeAllRecords();
        DBAdapter.readRecords();
    }
}
