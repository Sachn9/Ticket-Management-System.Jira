package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.models.ProjectState;
import com.tms.db.Database_Api.repository.ProjectStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/project-state")
public class ProjectStateController {

    private final ProjectStateRepository projectStateRepository;

    @Autowired
    public ProjectStateController(ProjectStateRepository projectStateRepository) {
        this.projectStateRepository = projectStateRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectState> getProjectStateById(@PathVariable UUID id) {
        ProjectState projectState = projectStateRepository.findById(id).orElse(null);
        return new ResponseEntity<>(projectState, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectState> createProjectState(@RequestBody ProjectState projectState) {
        projectStateRepository.save(projectState);
        return new ResponseEntity<>(projectState, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectState> updateProjectState(@RequestBody ProjectState projectState) {
        projectStateRepository.save(projectState);
        return new ResponseEntity<>(projectState, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProjectState(@PathVariable UUID id) {
        projectStateRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
