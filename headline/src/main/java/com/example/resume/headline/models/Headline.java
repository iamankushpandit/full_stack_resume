package com.example.resume.headline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing an Headline for a Candidate.
 *
 * @author Ankush Pandit
 */
@Entity(name = "headline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Headline
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headline_id;
    private Long candidate_id;
    private String headline;

    /**
     * Constructor.
     */
    public Headline()
    {
    }

    /**
     * @return the headline_id
     */
    public Long getHeadline_id()
    {
        return headline_id;
    }

    /**
     * @param headline_id the headline_id to set
     */
    public void setHeadline_id(final Long headline_id)
    {
        this.headline_id = headline_id;
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
     * @return the headline
     */
    public String getHeadline()
    {
        return headline;
    }

    /**
     * @param headline the headline to set
     */
    public void setHeadline(final String headline)
    {
        this.headline = headline;
    }
}
