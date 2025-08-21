package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.models.Role;
import com.tms.db.Database_Api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/role")
public class RoleController {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable UUID id) {
        Role role = roleRepository.findById(id).orElse(null);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        roleRepository.save(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        roleRepository.save(role);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
        roleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
