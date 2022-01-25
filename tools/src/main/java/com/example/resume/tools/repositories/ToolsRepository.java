package com.example.resume.tools.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.resume.tools.models.Tools;

/**
 * A {@link JpaRepository} for {@link Tools} object.
 *
 * @author Ankush Pandit
 */
public interface ToolsRepository extends JpaRepository<Tools, Long>
{
    /**
     * Added a method over the already provided {@link JpaRepository} based on a query
     * that provides information specific to a given candidate. This is done as this
     * method can not be anticipated and provided by spring framework.
     *
     * @param candidate_id the id of the candidate from which info needs to be extracted.
     * @return a list of {@link Tools} for the candidate whose id is provided.
     */
    @Query("FROM tools WHERE candidate_id = ?1")
    List<Tools> findByCandidateId(final Long candidate_id);
}
