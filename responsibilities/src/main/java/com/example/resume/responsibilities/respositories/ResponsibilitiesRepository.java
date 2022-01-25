package com.example.resume.responsibilities.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.responsibilities.models.Responsibilities;

public interface ResponsibilitiesRepository extends JpaRepository<Responsibilities, Long>
{
    @Query("FROM responsibilities WHERE candidate_id = ?1")
    List<Responsibilities> findByCandidateId(final Long candidate_id);
}
