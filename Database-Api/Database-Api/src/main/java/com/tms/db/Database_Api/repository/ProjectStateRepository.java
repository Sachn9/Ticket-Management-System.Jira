package com.tms.db.Database_Api.repository;

import com.tms.db.Database_Api.models.ProjectState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectStateRepository extends JpaRepository<ProjectState, UUID> {
}
