package com.example.resume.headline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.headline.models.Headline;

public interface HeadlineRepository extends JpaRepository<Headline, Long>
{
    @Query("FROM headline WHERE candidate_id = ?1")
    List<Headline> findByCandidateId(final Long candidate_id);
}
