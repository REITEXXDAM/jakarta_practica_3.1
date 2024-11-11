package idao;

import models.CourseMaterial;

public interface ICourseMaterialDao {
    CourseMaterial find(Integer id);
}