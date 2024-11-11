package dao;

import idao.ICourseMaterialDao;
import models.CourseMaterial;

public class CourseMaterialDaoImpl extends Dao<CourseMaterial, Integer> implements ICourseMaterialDao {

    @Override
    public CourseMaterial find(Integer id) {
        return em.find(CourseMaterial.class, id);
    }

    // Puedes añadir otros métodos específicos si lo necesitas, como búsquedas avanzadas.
}

