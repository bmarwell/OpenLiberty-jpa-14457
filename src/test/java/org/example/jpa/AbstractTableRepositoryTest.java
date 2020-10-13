package org.example.jpa;

import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

abstract class AbstractTableRepositoryTest {

    private final EntityManagerFactory emf = JpaHelper.createUnit();

    private final TableRepository tableRepository = new TableRepository(this.emf.createEntityManager());

    @BeforeEach
    public void setUpTable() {
        final EntityManager entityManager = this.emf.createEntityManager();
        final EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        final Query createTableMytable = entityManager.createNativeQuery(
                "CREATE TABLE mytable (" +
                        " id IDENTITY PRIMARY KEY, " +
                        " field varchar(1023) " +
                        "); ");
        createTableMytable.executeUpdate();
        tx.commit();
    }

    public TableRepository getTableRepository() {
        return this.tableRepository;
    }
}
