package dao;

import idao.ITeacherDao;
import models.Teacher;

public class TeacherDaoImpl extends Dao<Teacher, Integer> implements ITeacherDao {
    @Override
    public Teacher find(Integer id) {
        return em.find(Teacher.class, id);
    }
}
