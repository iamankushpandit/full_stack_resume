package com.example.resume.education.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.education.models.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Long>
{
    @Query("FROM certification WHERE candidate_id = ?1")
    List<Certification> findByCandidateId(final Long candidate_id);
}
