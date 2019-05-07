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
    @PostMapping(path="/new",
            headers = {
                    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addProject(@RequestBody Project project) {
        projectRepository.save(project);
        return "added " + project.getName();
    }

    @GetMapping(path="/all")
    public List<Project> getAllProjects() {
        return (List) projectRepository.findAll();
    }

}
