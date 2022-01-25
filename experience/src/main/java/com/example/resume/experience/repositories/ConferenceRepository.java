package com.example.resume.experience.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.experience.models.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long>
{
    @Query("FROM conference WHERE candidate_id = ?1")
    List<Conference> findByCandidateId(final Long candidate_id);
}
