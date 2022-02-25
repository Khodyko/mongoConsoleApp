package org.example.web.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * Collection subTask is not realised
 */
@Document(collection = "subTask")
public class SubTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    private String description;

    public SubTask(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public SubTask() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTask)) return false;
        SubTask subTask = (SubTask) o;
        return Objects.equals(name, subTask.name) && Objects.equals(description, subTask.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubTask{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
