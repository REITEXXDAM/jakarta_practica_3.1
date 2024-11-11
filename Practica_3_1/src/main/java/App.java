import dao.CourseDaoImpl;
import dao.TeacherDaoImpl;
import models.Course;
import models.Teacher;

public class App {

    public static void main(String[] args) {

        Teacher t1 = new Teacher();
        t1.setFirstName("Pepe");
        t1.setLastName("Fernandez");

        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.create(t1);
        Teacher teacher = teacherDao.find(1);

        // Crear una asignatura
        Course c1 = new Course();
        c1.setTitle("Matemáticas");
        c1.setTeacher(t1); // Asociar el Teacher al Course

        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.create(c1);

        Course retrievedCourse = courseDao.find(c1.getId());

        System.out.println("Course: " + retrievedCourse.getTitle());
        System.out.println("Teacher: " + retrievedCourse.getTeacher().getFirstName() + " " + retrievedCourse.getTeacher().getLastName());

        // MODIFICAR
        retrievedCourse.setTitle("Matemáticas MODIFIY");
        Course updatedCourse = courseDao.update(retrievedCourse);

        System.out.println("Curso actualizado: " + updatedCourse.getTitle());

        // ELiminado
        courseDao.delete(updatedCourse);
        System.out.println("El curso" + updatedCourse.getTitle() + " se ha eliminado.");

        // Probar error persistido
        try {
            Course newCourseWithDetachedTeacher = new Course();
            newCourseWithDetachedTeacher.setTitle("Historia");
            Teacher profesor = new Teacher();
            profesor.setId(212);
            profesor.setFirstName("Juan");
            profesor.setLastName("Perez");


            newCourseWithDetachedTeacher.setTeacher(profesor);

            courseDao.create(newCourseWithDetachedTeacher);
        } catch (Exception e) {
            System.out.println("Error al persistir el Course con Teacher detached: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

