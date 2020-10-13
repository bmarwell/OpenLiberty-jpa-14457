package org.example.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "mytable")
public class MyTableEntity {

    @Id
    private int id;

    @Column
    private String field;

    public MyTableEntity() {
        // jpa needed
    }

    public MyTableEntity(int id, String field) {
        this.id = id;
        this.field = field;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof MyTableEntity)) return false;
        MyTableEntity that = (MyTableEntity) other;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyTableEntity.class.getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("field='" + getField() + "'")
                .toString();
    }
}
