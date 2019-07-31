package com.ac.rest.api.rest;

import com.ac.rest.api.dao.EmployeeDAO;
import com.ac.rest.api.dao.EmployeeDAOHibernateImpl;
import com.ac.rest.api.entity.Employee;
import com.ac.rest.api.service.EmployeeService;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee with specified ID doesn't exists!");
        }
        return theEmployee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

        employeeService.save(theEmployee);

        System.out.println("the user"+theEmployee);

        return theEmployee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

            Employee employee = employeeService.findById(employeeId);

            if (employee == null){
                throw new RuntimeException("The Specified user doesn't exists!");
            }

           employeeService.deleteById(employeeId);

            return "The user with the id: " + employeeId + " deleted";
    }
}
