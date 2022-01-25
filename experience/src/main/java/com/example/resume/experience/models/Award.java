package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing an Award for a Candidate.
 *
 * @author Ankush Pandit
 */
@Entity(name = "awards")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Award
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long awards_id;
    private Long candidate_id;
    private String project_name;
    private String awards_name;
    private String awards_year;
    private String awards_institution_name;

    /**
     * Constructor.
     */
    public Award()
    {
        super();
    }

    /**
     * @return the awards_id
     */
    public Long getAwards_id()
    {
        return awards_id;
    }

    /**
     * @param awards_id the awards_id to set
     */
    public void setAwards_id(final Long awards_id)
    {
        this.awards_id = awards_id;
    }

    /**
     * @return the candidate_id
     */
    public Long getCandidate_id()
    {
        return candidate_id;
    }

    /**
     * @param candidate_id the candidate_id to set
     */
    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    /**
     * @return the project_name
     */
    public String getProject_name()
    {
        return project_name;
    }

    /**
     * @param project_name the project_name to set
     */
    public void setProject_name(final String project_name)
    {
        this.project_name = project_name;
    }

    /**
     * @return the awards_name
     */
    public String getAwards_name()
    {
        return awards_name;
    }

    /**
     * @param awards_name the awards_name to set
     */
    public void setAwards_name(final String awards_name)
    {
        this.awards_name = awards_name;
    }

    /**
     * @return the awards_year
     */
    public String getAwards_year()
    {
        return awards_year;
    }

    /**
     * @param awards_year the awards_year to set
     */
    public void setAwards_year(final String awards_year)
    {
        this.awards_year = awards_year;
    }

    /**
     * @return the awards_institution_name
     */
    public String getAwards_institution_name()
    {
        return awards_institution_name;
    }

    /**
     * @param awards_institution_name the awards_institution_name to set
     */
    public void setAwards_institution_name(final String awards_institution_name)
    {
        this.awards_institution_name = awards_institution_name;
    }
}
