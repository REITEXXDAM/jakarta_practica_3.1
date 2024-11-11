import dao.CourseDaoImpl;
import dao.CourseMaterialDaoImpl;
import dao.StudentDaoImpl;
import dao.TeacherDaoImpl;
import models.Course;
import models.CourseMaterial;
import models.Student;
import models.Teacher;

public class App {
    // Reutilizamos las instancias de los DAOs
    private static TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    private static CourseDaoImpl courseDao = new CourseDaoImpl();
    private static CourseMaterialDaoImpl materialDao = new CourseMaterialDaoImpl();
    private static StudentDaoImpl studentDao = new StudentDaoImpl();

    public static void main(String[] args) {

        // Crear un profesor y persistirlo
        Teacher teacher = new Teacher();
        teacher.setFirstName("Ana");
        teacher.setLastName("Gomez");
        teacherDao.create(teacher);

        // Crear un curso y persistirlo
        Course course = new Course();
        course.setTitle("Historia del Arte");
        course.setTeacher(teacher);
        courseDao.create(course);

        // Crear material
        CourseMaterial material = new CourseMaterial();
        material.setUrl("https://es.wikipedia.org/wiki/Historia");
        material.setCourse(course);
        materialDao.create(material);

        // Obtener material
        CourseMaterial retrievedMaterial = materialDao.find(material.getId());
        System.out.println("Material URL: " + retrievedMaterial.getUrl());
        System.out.println("Curso asociado: " + retrievedMaterial.getCourse().getTitle());

        // Obtener el curso
        Course retrievedCourse = courseDao.find(course.getId());
        System.out.println("Curso: " + retrievedCourse.getTitle());
        System.out.println("Material asociado: " + (retrievedCourse.getMaterial() != null ? retrievedCourse.getMaterial().getUrl() : "No hay material asociado"));

        // Crear estudiantes
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setFirstName("Juan" + i);
            student.setLastName("Perez" + i);
            studentDao.create(student);
        }


        // Crear más cursos y persistirlos
        for (int i = 0; i < 5; i++) {
            Course newCourse = new Course();
            newCourse.setTitle("Curso " + (i + 1));
            newCourse.setTeacher(teacher); // Asociamos el profesor al curso
            courseDao.create(newCourse);
        }


        Student student = studentDao.find(1);

        for (int i = 1; i <= 5; i++) {
            Course courseToAssign = courseDao.find(i);
            if (courseToAssign != null) {
                student.addCourse(courseToAssign);
            } else {
                System.out.println("Curso con ID " + i + " no encontrado");
            }
        }

        studentDao.update(student);

        Student updatedStudent = studentDao.find(student.getId());
        System.out.println("Estudiante: " + updatedStudent.getFirstName() + " " + updatedStudent.getLastName());
        for (Course c : updatedStudent.getCourses()) {
            System.out.println("Curso: " + c.getTitle());
        }
    }
}
