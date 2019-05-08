package com.projectteamviewer.ProjectTeamViewer.api;

import com.projectteamviewer.ProjectTeamViewer.model.Employee;
import com.projectteamviewer.ProjectTeamViewer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path="/employee")
@RestController
public class EmployeeController {

    private  EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository er) {
        employeeRepository = er;
    }

    @ResponseBody
    @PostMapping(path="/new")
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee temp = new Employee(employee.getName());
        employeeRepository.save(temp);
        return temp;
    }

    @GetMapping(path="/all")
    public List<Employee> getAllEmployees() {
        return (List) employeeRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public Employee getEmployeeById(@PathVariable(value="id") int id) {
        return employeeRepository.findById(id).orElse(null);
    }



}
