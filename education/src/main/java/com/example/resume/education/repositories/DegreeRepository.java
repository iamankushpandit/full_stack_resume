package com.example.resume.education.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.education.models.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Long>
{
    @Query("FROM degree WHERE candidate_id = ?1")
    List<com.example.resume.education.models.Degree> findByCandidateId(final Long candidate_id);
}
