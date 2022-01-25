package com.example.resume.experience.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.experience.models.Award;

public interface AwardRepository extends JpaRepository<Award, Long>
{
    @Query("FROM awards WHERE candidate_id = ?1")
    List<Award> findByCandidateId(final Long candidate_id);
}
