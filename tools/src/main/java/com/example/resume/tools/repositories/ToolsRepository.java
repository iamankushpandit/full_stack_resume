package com.example.resume.tools.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.tools.models.Tools;

public interface ToolsRepository extends JpaRepository<Tools, Long>
{
    @Query("FROM tools WHERE candidate_id = ?1")
    List<Tools> findByCandidateId(final Long candidate_id);
}
