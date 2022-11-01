package peaksoft.repository;

import org.hibernate.Session;
import peaksoft.configurations.HibernateConfig;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import java.util.List;

public class TaskRepository {

    public static void saveTask(Task task, Long lessonId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(task);
            Lesson lesson = session.get(Lesson.class, lessonId);
            lesson.addTaskToList(task);
            session.getTransaction().commit();
            System.out.println("Task with name: " + task.getName() + " was successfully created!");
        }
    }

    public static void updateTask(Long taskId, Task task) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Task task1 = session.get(Task.class, taskId);
            task1.setName(task.getName());
            task1.setDeadLine(task.getDeadLine());
            task1.setTask(task.getTask());
            session.getTransaction().commit();
            System.out.println("Task with id: " + taskId + " was successfully updated");
        }
    }

    public static List<Task> getAllTasksByLessonId(Long lessonId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class, lessonId);
            List<Task> tasks = lesson.getTasks();
            session.getTransaction().commit();
            System.out.println("Found " + tasks.size() + " tasks");
            return tasks;
        }
    }

    public static void deleteTaskById(Long taskId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            session.beginTransaction();
            Task task = session.get(Task.class, taskId);
            session.remove(task);
            session.getTransaction().commit();
            System.out.println("Task id: " + taskId + " was successfully deleted");
        }
    }
}
