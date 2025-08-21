package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.models.Project;
import com.tms.db.Database_Api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/project")
public class ProjectController {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable UUID id) {
        Project project = projectRepository.findById(id).orElse(null);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        projectRepository.save(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        projectRepository.save(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable UUID id) {
        projectRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
