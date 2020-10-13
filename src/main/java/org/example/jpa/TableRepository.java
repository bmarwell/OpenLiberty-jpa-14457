package org.example.jpa;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@RequestScoped
public class TableRepository {

    @PersistenceContext(unitName = "test")
    private /* non-final */ EntityManager entityManager;

    public TableRepository() {
        this(null);
    }

    public TableRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Boolean hasFieldValue(final String content) {
        final EntityManager em = this.getEntityManager();
        final TypedQuery<Boolean> query = em.createQuery("select case when (count(pdo.field) > 0) then true else false end "
                        + "from MyTableEntity pdo "
                        + "where pdo.field = :content",
                Boolean.class);
        query.setParameter("content", content);

        return query.getSingleResult();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
