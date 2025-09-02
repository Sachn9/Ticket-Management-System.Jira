package com.tms.db.Database_Api.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.event.ListDataEvent;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table (name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Employee employee;

    private String context;

    private String commentTxt;

   // @OneToMany
    private List<String> mediaLink;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Employee createdBy;

    @ManyToOne
    private Employee updateBy;

}
