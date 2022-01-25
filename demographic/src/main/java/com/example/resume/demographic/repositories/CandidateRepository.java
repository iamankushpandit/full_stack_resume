package com.example.resume.demographic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.demographic.models.Candidate;

/**
 * A {@link JpaRepository} for {@link Candidate} object.
 *
 * @author Ankush Pandit
 */
public interface CandidateRepository extends JpaRepository<Candidate, Long>
{
    /**
     * Added a method over the already provided {@link JpaRepository} based on a query
     * that provides information specific to a given candidate. This is done as this
     * method can not be anticipated and provided by spring framework.
     *
     * @param candidate_id the id of the candidate from which info needs to be extracted.
     * @return a list of {@link Candidate} for the candidate whose id is provided.
     */
    @Query("FROM candidate WHERE candidate_id = ?1")
    List<Candidate> findByCandidateId(final Long candidate_id);
}
