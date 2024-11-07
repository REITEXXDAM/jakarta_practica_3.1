import dao.TeacherDaoImpl;
import models.Teacher;

public class App {

    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setId(1);
        t1.setFirstName("Pepe");
        t1.setLastName("Fernandez");

        TeacherDaoImpl teacherDao = new TeacherDaoImpl();

        teacherDao.create(t1);
        Teacher teacher = teacherDao.find(1);
        System.out.println(teacher);
    }
}
