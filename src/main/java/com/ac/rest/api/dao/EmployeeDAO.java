package com.ac.rest.api.dao;

import com.ac.rest.api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

}
