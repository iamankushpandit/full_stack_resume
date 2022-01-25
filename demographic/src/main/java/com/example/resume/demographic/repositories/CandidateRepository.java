package com.example.resume.demographic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.demographic.models.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>
{
    @Query("FROM candidate WHERE candidate_id = ?1")
    List<Candidate> findByCandidateId(final Long candidate_id);
}
