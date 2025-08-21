package com.tms.db.Database_Api.controllers;

import com.tms.db.Database_Api.models.Comment;
import com.tms.db.Database_Api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/comment")
public class CommentController {

    CommentRepository commentRepository;

    @Autowired
    public  CommentController(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCommentById(@PathVariable UUID id){
        Comment comment=commentRepository.findById(id).orElse(null);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createComment(@RequestBody Comment comment){
        commentRepository.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateComment(@RequestBody  Comment comment){
        commentRepository.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable UUID id){
        commentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
