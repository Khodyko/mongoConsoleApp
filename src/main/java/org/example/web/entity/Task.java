package org.example.web.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "taskEntity")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dateOfCreation;
    private Date deadline;
    @Id
    private String name;
    private String description;
    private List<SubTask> subTaskList;

    public Task() {
    }

    public Task(Date dateOfCreation, Date deadline, String name,
                String description, List<SubTask> subTaskList) {
        this.dateOfCreation = dateOfCreation;
        this.deadline = deadline;
        this.name = name;
        this.description = description;
        this.subTaskList = subTaskList;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubTask> getSubTaskList() {
        return subTaskList;
    }

    public void setSubTaskList(List<SubTask> subTaskList) {
        this.subTaskList = subTaskList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(dateOfCreation, task.dateOfCreation)
                    && Objects.equals(deadline, task.deadline)
                    && Objects.equals(name, task.name)
                    && Objects.equals(description, task.description)
                    && Objects.equals(subTaskList, task.subTaskList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfCreation, deadline,
                            name, description, subTaskList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("dateOfCreation=").append(dateOfCreation);
        sb.append(", deadline=").append(deadline);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", subTaskList=").append(subTaskList);
        sb.append('}');
        return sb.toString();
    }
}
