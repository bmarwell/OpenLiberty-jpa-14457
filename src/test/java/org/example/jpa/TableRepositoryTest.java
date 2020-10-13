package org.example.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TableRepositoryTest extends AbstractTableRepositoryTest {

    @Test
    public void testRepo() {
        final Boolean hasFieldValue = this.getTableRepository().hasFieldValue("hello");

        assertFalse(hasFieldValue);
    }
}
