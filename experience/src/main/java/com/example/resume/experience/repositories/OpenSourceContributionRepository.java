package com.example.resume.experience.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.experience.models.OpenSourceContribution;

public interface OpenSourceContributionRepository extends JpaRepository<OpenSourceContribution, Long>
{
    @Query("FROM open_source_contribution WHERE candidate_id = ?1")
    List<OpenSourceContribution> findByCandidateId(final Long candidate_id);
}
