package ru.gb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;


public class DBAdapter {
    public static Session connect() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory.openSession();

    }

    public static void addEntity(Course course) {
        try (Session session = connect()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void readRecords() {
        try (Session session = connect()) {
            List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
            System.out.println("Listing records from DB:");
            courses.forEach(System.out::println);
        }
    }

    public static void updateEntity(int id, String newTitle, Integer newDuration) {
        try (Session session = connect()) {
            String hql = "FROM Course WHERE id = :id";
            Query<Course> query = session.createQuery(hql, Course.class);
            query.setParameter("id", id);
            Course course = query.getSingleResult();
            if (newTitle!=null) course.setTitle(newTitle);
            if (newDuration!=null) course.setDurationHours(newDuration);
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        }
    }

    public static void removeAllRecords() {
        try (Session session = connect()) {
            session.beginTransaction();
            List<Course> courses = session.createQuery("FROM Course", Course.class).getResultList();
            courses.forEach(session::delete);
            session.getTransaction().commit();
        }
    }
}
