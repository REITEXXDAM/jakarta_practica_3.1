package dao;

import models.Course;

public class CourseDaoImpl extends Dao<Course, Integer> {
    @Override
    public Course find(Integer id) {
        Course course = em.find(Course.class, id);
        return course;
    }
}
