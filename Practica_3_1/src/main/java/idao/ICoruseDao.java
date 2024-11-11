package idao;

import models.Course;

import java.util.List;

public interface ICoruseDao {
    Course find(Integer id);

    List<Course> listCoursesByLastName(String lastName);
}
