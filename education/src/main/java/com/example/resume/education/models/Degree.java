package com.example.resume.education.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing a Degree for a Candidate.
 *
 * @author Ankush Pandit
 */
@Entity(name = "degree")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Degree
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long degree_id;
    private Long candidate_id;
    private String degree_name;
    private String degree_complete_date;
    private String degree_college_name;
    private String degree_college_address;
    private String degree_specialization;

    /**
     * Constructor.
     */
    public Degree()
    {
    }

    /**
     * @return the degree_id
     */
    public Long getDegree_id()
    {
        return degree_id;
    }

    /**
     * @param degree_id the degree_id to set
     */
    public void setDegree_id(final Long degree_id)
    {
        this.degree_id = degree_id;
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
     * @return the degree_name
     */
    public String getDegree_name()
    {
        return degree_name;
    }

    /**
     * @param degree_name the degree_name to set
     */
    public void setDegree_name(final String degree_name)
    {
        this.degree_name = degree_name;
    }

    /**
     * @return the degree_complete_date
     */
    public String getDegree_complete_date()
    {
        return degree_complete_date;
    }

    /**
     * @param degree_complete_date the degree_complete_date to set
     */
    public void setDegree_complete_date(final String degree_complete_date)
    {
        this.degree_complete_date = degree_complete_date;
    }

    /**
     * @return the degree_college_name
     */
    public String getDegree_college_name()
    {
        return degree_college_name;
    }

    /**
     * @param degree_college_name the degree_college_name to set
     */
    public void setDegree_college_name(final String degree_college_name)
    {
        this.degree_college_name = degree_college_name;
    }

    /**
     * @return the degree_college_address
     */
    public String getDegree_college_address()
    {
        return degree_college_address;
    }

    /**
     * @param degree_college_address the degree_college_address to set
     */
    public void setDegree_college_address(final String degree_college_address)
    {
        this.degree_college_address = degree_college_address;
    }

    /**
     * @return the degree_specialization
     */
    public String getDegree_specialization()
    {
        return degree_specialization;
    }

    /**
     * @param degree_specialization the degree_specialization to set
     */
    public void setDegree_specialization(final String degree_specialization)
    {
        this.degree_specialization = degree_specialization;
    }
}