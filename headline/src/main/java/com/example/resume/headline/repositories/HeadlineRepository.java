package com.example.resume.headline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.headline.models.Headline;

/**
 * A {@link JpaRepository} for {@link Headline} object.
 *
 * @author Ankush Pandit
 */
public interface HeadlineRepository extends JpaRepository<Headline, Long>
{
    /**
     * Added a method over the already provided {@link JpaRepository} based on a query
     * that provides information specific to a given candidate. This is done as this
     * method can not be anticipated and provided by spring framework.
     *
     * @param candidate_id the id of the candidate from which info needs to be extracted.
     * @return a list of {@link Headline} for the candidate whose id is provided.
     */
    @Query("FROM headline WHERE candidate_id = ?1")
    List<Headline> findByCandidateId(final Long candidate_id);
}
