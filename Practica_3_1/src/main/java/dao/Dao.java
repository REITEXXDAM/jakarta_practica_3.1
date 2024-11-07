package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class Dao<T, K> {
    protected EntityManager em = Persistence
            .createEntityManagerFactory("default")
            .createEntityManager();

    public T create(T t) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(t);
        transaction.commit();
        return t;
    }

    public T find(Class<T> clazz, K id) {
        return em.find(clazz, id);
    }

    public T update(T t) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(t);
        transaction.commit();
        return t;
    }

    public void delete(T t) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(t);
        transaction.commit();
    }
}
