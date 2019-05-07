package com.projectteamviewer.ProjectTeamViewer.repository;

import com.projectteamviewer.ProjectTeamViewer.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
