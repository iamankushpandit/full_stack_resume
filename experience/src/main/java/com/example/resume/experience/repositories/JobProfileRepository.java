package com.example.resume.experience.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.experience.models.JobProfile;

public interface JobProfileRepository extends JpaRepository<JobProfile, Long>
{
    @Query("FROM job_profile WHERE candidate_id = ?1")
    List<JobProfile> findByCandidateId(final Long candidate_id);
}
