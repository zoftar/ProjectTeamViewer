package com.projectteamviewer.ProjectTeamViewer.api;

import com.projectteamviewer.ProjectTeamViewer.model.Employee;
import com.projectteamviewer.ProjectTeamViewer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @PostMapping(path="/new",
    headers = {
        "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee addEmployee(@RequestBody Employee employee) {
        Employee temp = new Employee(employee.getName());
        employeeRepository.save(temp);
        return temp;
    }

    @GetMapping(path="/all")
    public List<Employee> getAllEmployees() {
        return (List) employeeRepository.findAll();
    }



}
