package com.jrp.pma.projectmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;
    private String name;
    private String stage; //
    private String description;
    @OneToMany(mappedBy = "theProject")
    private java.util.List<Employee> employees;

    public Project() {
    }

    public Project(String name, String stage, String description) {

        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public java.util.List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(java.util.List<Employee> employees) {
        this.employees = employees;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
