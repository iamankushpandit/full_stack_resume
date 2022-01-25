package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing an Conference attendance for a Candidate.
 *
 * @author Ankush Pandit
 */
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

    /**
     * @return the conference_id
     */
    public Long getConference_id()
    {
        return conference_id;
    }

    /**
     * @param conference_id the conference_id to set
     */
    public void setConference_id(final Long conference_id)
    {
        this.conference_id = conference_id;
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
     * @return the role
     */
    public String getRole()
    {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(final String role)
    {
        this.role = role;
    }

    /**
     * @return the conference_year
     */
    public String getConference_year()
    {
        return conference_year;
    }

    /**
     * @param conference_year the conference_year to set
     */
    public void setConference_year(final String conference_year)
    {
        this.conference_year = conference_year;
    }

    /**
     * @return the topic
     */
    public String getTopic()
    {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(final String topic)
    {
        this.topic = topic;
    }

    /**
     * @return the conference_institution_name
     */
    public String getConference_institution_name()
    {
        return conference_institution_name;
    }

    /**
     * @param conference_institution_name the conference_institution_name to set
     */
    public void setConference_institution_name(final String conference_institution_name)
    {
        this.conference_institution_name = conference_institution_name;
    }

}
