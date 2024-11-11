package dao;

import jakarta.persistence.TypedQuery;
import models.CourseMaterial;
import models.Student;

import java.util.List;

public class StudentDaoImpl extends Dao<Student, Integer> {
    public Student find(Integer id) {
        Student student = (Student) em.find(Student.class, id);
        return student;
    }

    public List<Student> listStudentsByCourseId(Integer courseId) {
        TypedQuery<Student> query = em.createQuery(
                "SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId",
                Student.class
        );

        // Establece el parámetro `courseId` en la consulta
        query.setParameter("courseId", courseId);

        // Ejecuta la consulta y devuelve el resultado como una lista de estudiantes
        return query.getResultList();
    }
}
