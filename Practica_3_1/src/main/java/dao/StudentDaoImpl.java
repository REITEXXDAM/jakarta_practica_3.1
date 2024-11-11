package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import models.CourseMaterial;
import models.Student;

import java.util.List;

public class StudentDaoImpl extends Dao<Student, Integer> {
    public Student find(Integer id) {
        Student student = (Student) em.find(Student.class, id);
        return student;
    }

    public List<Student> listStudentsByCourseId(int courseId) {
        EntityManager entityManager = getEntityManager();

        // Consulta JPQL que busca estudiantes asociados a un curso por id
        String queryStr = "SELECT s FROM Student s JOIN s.courses c WHERE c.id = :courseId";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("courseId", courseId);

        // Ejecutamos la consulta y devolvemos la lista de estudiantes
        return query.getResultList();
    }
}
