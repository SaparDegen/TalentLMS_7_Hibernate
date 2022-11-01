package peaksoft;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.configurations.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.TaskRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main( String[] args ){

        /*Lesson lesson1 = new Lesson("Lesson1-JDBC", "aa1.com");
        Lesson lesson2 = new Lesson("Lesson2-Hibernate", "aa2.com");

        Instructor instructor1 = new Instructor("Bill", "Gates", "gates@gmail.com", "555121212");
        Instructor instructor2 = new Instructor("Elon", "Mask", "mask@gmail.com", "555101010");
        Instructor instructor3 = new Instructor("Jassie", "Jay", "jay@gmail.com", "555111111");

        Course course1 = new Course("Java", 9, LocalDate.of(2022, 07, 01), "aa.gif", "ss1");
        Course course2 = new Course("JS", 10, LocalDate.of(2022, 03, 01), "bb.gif", "ss2");
        Course course3 = new Course("Python", 12, LocalDate.of(2022, 01, 01), "cc.gif", "ss3");
        course1.addLessonToList(lesson1);
        course1.addLessonToList(lesson2);
        course1.addInstructorToList(instructor1);
        course1.addInstructorToList(instructor2);
        course2.addInstructorToList(instructor3);

        lesson1.setCourse(course1);
        lesson2.setCourse(course1);

        CourseRepository.saveCourse(course1);
        CourseRepository.saveCourse(course2);
        CourseRepository.saveCourse(course3);*/

        /*Course course = CourseRepository.getCourseById(2L);
        System.out.println(course);*/

        //CourseRepository.getAllCourses().forEach(System.out::println);

        /*Course course11 = new Course("C++", 18, LocalDate.of(2022, 10, 1), "cc.gif", "ss4");
        CourseRepository.updateCourse(1L, course11);*/

        //CourseRepository.deleteCourseById(1L);

        //CourseRepository.getCourseByName("Python").forEach(System.out::println);

        /*Instructor instructor11 = new Instructor("Stiven", "Hocking", "hock@gmail.com", "555141414");
        InstructorRepository.saveInstructor(instructor11);*/

        /*Instructor newInstruc = new Instructor("Poul", "Allen", "allen@gmail.com", "555151515");
        InstructorRepository.updateInstructor(2L, newInstruc);*/

        //System.out.println(InstructorRepository.getInstructorById(1L));

        //InstructorRepository.getInstructorByCourseId(1L).forEach(System.out::println);

        //InstructorRepository.deleteInstructorById(1L);

        /*Instructor newInstruc = new Instructor("Leonardo", "DaVinci", "leo@gmail.com", "555252525");
        InstructorRepository.assignInstructorToCourse(newInstruc, 2L);*/

        /*Lesson lesson11 = new Lesson("Lesson3-GitHub", "ee.com");
        LessonRepository.saveLesson(lesson11, 2L);*/

        /*Lesson lesson12 = new Lesson("Lesson4-HashMap", "hh.com");
        LessonRepository.updateLesson(2L, lesson12);*/

        //System.out.println(LessonRepository.getLessonById(2L));

        //LessonRepository.getLessonsByCourseId(1L).forEach(System.out::println);

        /*Task task11 = new Task("Task5", "11", "aa5");
        TaskRepository.saveTask(task11, 5L);*/

        /*Task task12 = new Task("Task11", "23", "aa22");
        TaskRepository.updateTask(2L, task12);*/

        //TaskRepository.getAllTasksByLessonId(5L).forEach(System.out::println);

        //TaskRepository.deleteTaskById(1L);

        HibernateConfig.shutDown();
    }
}
