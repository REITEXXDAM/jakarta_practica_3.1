package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import models.Course;

import java.util.List;

public class CourseDaoImpl extends Dao<Course, Integer> {
    @Override
    public Course find(Integer id) {
        Course course = em.find(Course.class, id);
        return course;
    }


    public List<Course> listCoursesByLastName(String lastName) {
        EntityManager entityManager = getEntityManager();

        // JPQL Query que busca cursos de profesores con el apellido dado
        String queryStr = "SELECT c FROM Course c WHERE c.teacher.lastName = :lastName";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("lastName", lastName);

        // Ejecutamos la consulta y devolvemos la lista de cursos
        return query.getResultList();
    }
}
