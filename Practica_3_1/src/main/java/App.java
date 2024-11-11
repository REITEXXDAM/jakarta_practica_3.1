import dao.CourseDaoImpl;
import dao.CourseMaterialDaoImpl;
import dao.TeacherDaoImpl;
import models.Course;
import models.CourseMaterial;
import models.Teacher;

public class App {
    public static void main(String[] args) {
        // Crear un profesor y persistirlo
        Teacher teacher = new Teacher();
        teacher.setFirstName("Ana");
        teacher.setLastName("Gomez");
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.create(teacher);

        // Crear un curso y persistirlo
        Course course = new Course();
        course.setTitle("Historia del Arte");
        course.setTeacher(teacher);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.create(course);

        // Crear material
        CourseMaterial material = new CourseMaterial();
        material.setUrl("https://es.wikipedia.org/wiki/Historia");
        material.setCourse(course);
        CourseMaterialDaoImpl materialDao = new CourseMaterialDaoImpl();
        materialDao.create(material);

        // Obtener
        CourseMaterial retrievedMaterial = materialDao.find(material.getId());
        System.out.println("Material URL: " + retrievedMaterial.getUrl());
        System.out.println("Curso asociado: " + retrievedMaterial.getCourse().getTitle());

        Course retrievedCourse = courseDao.find(course.getId());
        System.out.println("Curso: " + retrievedCourse.getTitle());
        System.out.println("Material asociado: " + (retrievedCourse.getMaterial() != null ? retrievedCourse.getMaterial().getUrl() : "No hay material asociado"));
    }
}
