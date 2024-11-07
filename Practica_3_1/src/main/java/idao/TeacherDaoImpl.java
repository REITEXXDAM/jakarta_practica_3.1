package idao;

import dao.Dao;
import models.Teacher;


public class TeacherDaoImpl extends Dao<Teacher,Integer> implements ITeacherDao {
    @Override
    public Teacher find(Integer id) {
        Teacher teacher = (Teacher) em.find(Teacher.class, id);
        return teacher;
    }
}



