package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.dto.OperationResponse;
import com.tms.db.Database_Api.models.Operation;
import com.tms.db.Database_Api.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/operation")
public class OperationController {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationController(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<OperationResponse> getAll(){
        List<Operation> operations=operationRepository.findAll();
        OperationResponse operationResponse=new OperationResponse();
        operationResponse.setOperations(operations);
        return new ResponseEntity<>(operationResponse,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Operation> getOperationById(@PathVariable UUID id) {
        Operation operation = operationRepository.findById(id).orElse(null);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Operation> createOperation(@RequestBody Operation operation) {
        operationRepository.save(operation);
        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Operation> updateOperation(@RequestBody Operation operation) {
        operationRepository.save(operation);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable UUID id) {
        operationRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
