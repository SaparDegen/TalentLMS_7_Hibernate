package peaksoft.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.configurations.HibernateConfig;
import peaksoft.entity.Course;

import java.util.Comparator;
import java.util.List;

public class CourseRepository {

    public static void saveCourse(Course course) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
            System.out.println("Course with name: " + course.getCourseName() + " was successfully created!");
        }
    }

    public static Course getCourseById(Long courseId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            session.getTransaction().commit();
            if (course != null) {
                System.out.println("Course with id: " + courseId + " successfully found");
            } else {
                System.out.println("We couldn't find course with id " + courseId);
            }
            return course;
        }
    }

    public static List<Course> getAllCourses() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c").getResultList();
            session.getTransaction().commit();
            System.out.println("Found " + courses.size() + " courses");
            return courses.stream().sorted(Comparator.comparing(Course::getCreateAt)).toList();
        }
    }

    public static void updateCourse(Long courseId, Course course) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Course course1 = session.get(Course.class, courseId);
            course1.setCourseName(course.getCourseName());
            course1.setDuration(course.getDuration());
            course1.setCreateAt(course.getCreateAt());
            session.getTransaction().commit();
            System.out.println("Course id: " + courseId + " was successfully updated");
        }
    }

    public static void deleteCourseById(Long courseId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            session.remove(course);
            session.getTransaction().commit();
            System.out.println("Course id: " + courseId + " was successfully deleted");
        }
    }

    public static List<Course> getCourseByName(String courseName) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Query query = session.createQuery("select c from Course c where c.courseName = :paramName");
            query.setParameter("paramName", courseName);
            List<Course> courses = query.getResultList();
            session.getTransaction().commit();
            return courses;
        }
    }
}
