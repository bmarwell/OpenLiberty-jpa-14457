package org.example.jpa;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.config.TargetServer;
import org.eclipse.persistence.logging.SessionLog;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JpaHelper {

    public static EntityManagerFactory createUnit() {
        final Map<String, Object> props = new ConcurrentHashMap<>();
        props.put(PersistenceUnitProperties.TARGET_DATABASE, "org.eclipse.persistence.platform.database.H2Platform");
        props.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINE");
        props.put(PersistenceUnitProperties.CATEGORY_LOGGING_LEVEL_ + SessionLog.SQL, "FINER");
        props.put(PersistenceUnitProperties.CATEGORY_LOGGING_LEVEL_ + SessionLog.QUERY, "FINER");
        props.put(PersistenceUnitProperties.CATEGORY_LOGGING_LEVEL_ + SessionLog.JPA, "FINER");
        props.put(PersistenceUnitProperties.LOGGING_LOGGER, "JavaLogger");
        props.put(PersistenceUnitProperties.LOGGING_PARAMETERS, "true");
        props.put(PersistenceUnitProperties.TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

        props.put(PersistenceUnitProperties.JDBC_DRIVER, "org.h2.Driver");
        final String jdbcUrl = "jdbc:h2:mem:test;";
        props.put(PersistenceUnitProperties.JDBC_URL, jdbcUrl);
        props.put(PersistenceUnitProperties.JDBC_USER, "sa");
        props.put(PersistenceUnitProperties.JDBC_PASSWORD, "");
        props.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.NONE);
        props.put(PersistenceUnitProperties.CONNECTION_POOL_MIN, 1);
        props.put(PersistenceUnitProperties.CONNECTION_POOL_MAX, 2);
        props.put(PersistenceUnitProperties.TARGET_SERVER, TargetServer.None);

        props.put("eclipselink.logging.level", "FINE");
        props.put("eclipselink.logging.level.sql", "fine");
        props.put("eclipselink.logging.parameters", "true");

        props.remove(PersistenceUnitProperties.JTA_DATASOURCE);
        return Persistence.createEntityManagerFactory("test", props);
    }
}
