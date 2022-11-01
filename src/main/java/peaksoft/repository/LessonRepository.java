package peaksoft.repository;

import org.hibernate.Session;
import peaksoft.configurations.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import java.util.List;

public class LessonRepository {

    public static void saveLesson(Lesson lesson, Long courseId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(lesson);
            Course course = session.get(Course.class, courseId);
            course.addLessonToList(lesson);
            lesson.setCourse(course);
            session.getTransaction().commit();
            System.out.println("Lesson with name: " + lesson.getName() + " was successfully created in course id " + courseId);
        }
    }

    public static void updateLesson(Long lessonId, Lesson lesson) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Lesson lesson1 = session.get(Lesson.class, lessonId);
            lesson1.setName(lesson.getName());
            lesson1.setVideoLink(lesson.getVideoLink());
            session.getTransaction().commit();
            System.out.println("Lesson with id: " + lessonId + " was successfully updated");
        }
    }

    public static Lesson getLessonById(Long lessonId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, lessonId);
            session.getTransaction().commit();
            if (lesson != null) {
                System.out.println("Lesson with id: " + lessonId + " successfully found");
            } else {
                System.out.println("We couldn't find Lesson with id " + lessonId);
            }
            return lesson;
        }
    }

    public static List<Lesson> getLessonsByCourseId(Long courseId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            System.out.println("Found " + lessons.size() + " lessons");
            return lessons;
        }
    }
}
