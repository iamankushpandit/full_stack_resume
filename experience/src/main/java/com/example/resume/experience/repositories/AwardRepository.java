package com.example.resume.experience.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.experience.models.Award;

/**
 * A {@link JpaRepository} for {@link Award} object.
 *
 * @author Ankush Pandit
 */
public interface AwardRepository extends JpaRepository<Award, Long>
{
    /**
     * Added a method over the already provided {@link JpaRepository} based on a query
     * that provides information specific to a given candidate. This is done as this
     * method can not be anticipated and provided by spring framework.
     *
     * @param candidate_id the id of the candidate from which info needs to be extracted.
     * @return a list of {@link Award} for the candidate whose id is provided.
     */
    @Query("FROM awards WHERE candidate_id = ?1")
    List<Award> findByCandidateId(final Long candidate_id);
}
