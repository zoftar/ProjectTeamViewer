package com.projectteamviewer.ProjectTeamViewer.api;

import com.projectteamviewer.ProjectTeamViewer.model.Employee;
import com.projectteamviewer.ProjectTeamViewer.model.Project;
import com.projectteamviewer.ProjectTeamViewer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(path="/project")
@RestController
public class ProjectController {

    private ProjectRepository projectRepository;
    @Autowired
    public ProjectController(ProjectRepository pr) {
        projectRepository = pr;
    }

    @ResponseBody
    @PostMapping(path="/new")
    public Project addProject(@RequestBody Project project) {
        projectRepository.save(project);
        return project;
    }

    @GetMapping(path="/all")
    public List<Project> getAllProjects() {
        return (List) projectRepository.findAll();
    }

    @ResponseBody
    @GetMapping(path="/{id}")
    public Project getProjectById(@PathVariable(value="id") int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @PostMapping(path="/add")
    public List<Employee> addEmployeeToProject(int project_id, Employee employee) {
        Project project = projectRepository.findById(project_id).orElse(null);
        if (project == null || employee == null) return null;
        project.addTeamMember(employee);
        projectRepository.save(project);
        return project.getTeamMembers();
    }

}
