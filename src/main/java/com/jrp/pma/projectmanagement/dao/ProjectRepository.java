package com.jrp.pma.projectmanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();
}
