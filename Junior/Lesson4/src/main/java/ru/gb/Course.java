package ru.gb;
/*
    Создайте базу данных (например, SchoolDB).
    В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
    Настройте Hibernate для работы с вашей базой данных.
    Создайте Java-класс ru.gb.Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
    Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
    Убедитесь, что каждая операция выполняется в отдельной транзакции.
*/

import javax.persistence.*;

@Entity
@Table(name = "schooldb.courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "Title")
    String title;
    @Column(name = "Duration")
    int durationHours;

    public Course(String title, int durationHours) {
        this.title = title;
        this.durationHours = durationHours;
    }

    public Course() {/*required by hibernate*/}

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", durationHours=" + durationHours +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }
}
