package com.example.resume.headline.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "headline")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Headline
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headline_id;
    private Long candidate_id;
    private String headline;

    public Headline()
    {
        // Added for the ease of serialization.
        super();
    }

    public Long getHeadline_id()
    {
        return headline_id;
    }

    public void setHeadline_id(final Long headline_id)
    {
        this.headline_id = headline_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getHeadline()
    {
        return headline;
    }

    public void setHeadline(final String headline)
    {
        this.headline = headline;
    }
}
