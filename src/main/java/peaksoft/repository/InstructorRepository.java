package peaksoft.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.configurations.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;

import java.util.Comparator;
import java.util.List;

public class InstructorRepository {

    public static void saveInstructor(Instructor instructor) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(instructor);
            session.getTransaction().commit();
            System.out.println("Instructor with name: " + instructor.getFirstName() + " was successfully created!");
        }
    }

    public static void updateInstructor(Long instructorId, Instructor instructor) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Instructor instructor1 = session.get(Instructor.class, instructorId);
            instructor1.setFirstName(instructor.getFirstName());
            instructor1.setLastName(instructor.getLastName());
            instructor1.setEmail(instructor.getEmail());
            instructor1.setPhoneNumber(instructor.getPhoneNumber());
            session.getTransaction().commit();
            System.out.println("Instructor with id: " + instructorId + " was successfully updated");
        }
    }

    public static Instructor getInstructorById(Long instructorId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, instructorId);
            session.getTransaction().commit();
            if (instructor != null) {
                System.out.println("Instructor with id: " + instructorId + " successfully found");
            } else {
                System.out.println("We couldn't find Instructor with id " + instructorId);
            }
            return instructor;
        }
    }

    public static List<Instructor> getInstructorsByCourseId(Long courseId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            List<Instructor> instructors = course.getInstructors();
            session.getTransaction().commit();
            System.out.println("Found " + instructors.size() + " instructors");
            return instructors;
        }
    }

    public static void deleteInstructorById(Long instructorId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, instructorId);
            session.remove(instructor);
            session.getTransaction().commit();
            System.out.println("Instructor id: " + instructorId + " was successfully deleted");
        }
    }

    public static void assignInstructorToCourse(Instructor instructor, Long courseId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            session.persist(instructor);
            Course course = session.get(Course.class, courseId);
            course.addInstructorToList(instructor);
            session.getTransaction().commit();
            System.out.println("A new Instructor with name: " + instructor.getFirstName() + " was successfully assigned to Course id " + courseId);
        }
    }
}
