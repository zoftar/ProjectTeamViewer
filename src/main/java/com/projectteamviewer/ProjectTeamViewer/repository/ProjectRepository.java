package com.projectteamviewer.ProjectTeamViewer.repository;

import com.projectteamviewer.ProjectTeamViewer.model.Employee;
import com.projectteamviewer.ProjectTeamViewer.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
