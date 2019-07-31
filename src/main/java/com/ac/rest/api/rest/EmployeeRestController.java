package com.ac.rest.api.rest;

import com.ac.rest.api.dao.EmployeeDAO;
import com.ac.rest.api.dao.EmployeeDAOHibernateImpl;
import com.ac.rest.api.entity.Employee;
import com.ac.rest.api.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

    @RequestMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}
