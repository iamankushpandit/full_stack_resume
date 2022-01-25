package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public String getAwards_institution_name()
    {
        return awards_institution_name;
    }

    public void setAwards_institution_name(final String awards_institution_name)
    {
        this.awards_institution_name = awards_institution_name;
    }

    public Award()
    {
        super();
    }

    public Long getAwards_id()
    {
        return awards_id;
    }

    public void setAwards_id(final Long awards_id)
    {
        this.awards_id = awards_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getProject_name()
    {
        return project_name;
    }

    public void setProject_name(final String project_name)
    {
        this.project_name = project_name;
    }

    public String getAwards_name()
    {
        return awards_name;
    }

    public void setAwards_name(final String awards_name)
    {
        this.awards_name = awards_name;
    }

    public String getAwards_year()
    {
        return awards_year;
    }

    public void setAwards_year(final String awards_year)
    {
        this.awards_year = awards_year;
    }

}
