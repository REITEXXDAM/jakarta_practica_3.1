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

        //Asignatura

        Course c1 = new Course();
        c1.setTitle("Matemáticas");
        c1.setTeacher(t1); // Asociar el Teacher al Course

        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.create(c1);

        Course retrievedCourse = courseDao.find(c1.getId());

        System.out.println("Course: " + retrievedCourse.getTitle());
        System.out.println("Teacher: " + retrievedCourse.getTeacher().getFirstName() + " " + retrievedCourse.getTeacher().getLastName());
    }
}
