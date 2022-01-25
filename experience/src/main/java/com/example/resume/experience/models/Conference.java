package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "conference")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Conference
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conference_id;
    private Long candidate_id;
    private String role;
    private String conference_year;
    private String topic;
    private String conference_institution_name;

    public Conference()
    {
        super();
    }

    public Long getConference_id()
    {
        return conference_id;
    }

    public void setConference_id(final Long conference_id)
    {
        this.conference_id = conference_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(final String role)
    {
        this.role = role;
    }

    public String getConference_year()
    {
        return conference_year;
    }

    public void setConference_year(final String conference_year)
    {
        this.conference_year = conference_year;
    }

    public String getTopic()
    {
        return topic;
    }

    public void setTopic(final String topic)
    {
        this.topic = topic;
    }

    public String getConference_institution_name()
    {
        return conference_institution_name;
    }

    public void setConference_institution_name(final String conference_institution_name)
    {
        this.conference_institution_name = conference_institution_name;
    }

}
