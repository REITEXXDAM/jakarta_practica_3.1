package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public abstract class Dao<T, K> {
    protected EntityManager em = Persistence
            .createEntityManagerFactory("default")
            .createEntityManager();

    public EntityManager getEntityManager() {
        return this.em;
    }

    public abstract T find(K id);

    public T create(T t) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(t);
        transaction.commit();
        return t;
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
