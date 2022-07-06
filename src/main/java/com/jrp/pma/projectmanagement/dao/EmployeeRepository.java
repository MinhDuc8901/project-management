package com.jrp.pma.projectmanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.projectmanagement.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
