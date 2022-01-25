package com.example.resume.demographic.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing a Candidate.
 *
 * @author Ankush Pandit
 */
@Entity(name = "candidate")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Candidate
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidate_id;
    private String candidate_first_name;
    private String candidate_middle_name;
    private String candidate_last_name;
    private String candidate_first_address;
    private String candidate_second_address;
    private String candidate_city;
    private String candidate_state;
    private String candidate_contry;
    private String candidate_zip;
    private String candidate_email;
    private String candidate_phone_number;
    private String candidate_github_url;

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
     * @return the candidate_first_name
     */
    public String getCandidate_first_name()
    {
        return candidate_first_name;
    }

    /**
     * @param candidate_first_name the candidate_first_name to set
     */
    public void setCandidate_first_name(final String candidate_first_name)
    {
        this.candidate_first_name = candidate_first_name;
    }

    /**
     * @return the candidate_middle_name
     */
    public String getCandidate_middle_name()
    {
        return candidate_middle_name;
    }

    /**
     * @param candidate_middle_name the candidate_middle_name to set
     */
    public void setCandidate_middle_name(final String candidate_middle_name)
    {
        this.candidate_middle_name = candidate_middle_name;
    }

    /**
     * @return the candidate_last_name
     */
    public String getCandidate_last_name()
    {
        return candidate_last_name;
    }

    /**
     * @param candidate_last_name the candidate_last_name to set
     */
    public void setCandidate_last_name(final String candidate_last_name)
    {
        this.candidate_last_name = candidate_last_name;
    }

    /**
     * @return the candidate_first_address
     */
    public String getCandidate_first_address()
    {
        return candidate_first_address;
    }

    /**
     * @param candidate_first_address the candidate_first_address to set
     */
    public void setCandidate_first_address(final String candidate_first_address)
    {
        this.candidate_first_address = candidate_first_address;
    }

    /**
     * @return the candidate_second_address
     */
    public String getCandidate_second_address()
    {
        return candidate_second_address;
    }

    /**
     * @param candidate_second_address the candidate_second_address to set
     */
    public void setCandidate_second_address(final String candidate_second_address)
    {
        this.candidate_second_address = candidate_second_address;
    }

    /**
     * @return the candidate_city
     */
    public String getCandidate_city()
    {
        return candidate_city;
    }

    /**
     * @param candidate_city the candidate_city to set
     */
    public void setCandidate_city(final String candidate_city)
    {
        this.candidate_city = candidate_city;
    }

    /**
     * @return the candidate_state
     */
    public String getCandidate_state()
    {
        return candidate_state;
    }

    /**
     * @param candidate_state the candidate_state to set
     */
    public void setCandidate_state(final String candidate_state)
    {
        this.candidate_state = candidate_state;
    }

    /**
     * @return the candidate_contry
     */
    public String getCandidate_contry()
    {
        return candidate_contry;
    }

    /**
     * @param candidate_contry the candidate_contry to set
     */
    public void setCandidate_contry(final String candidate_contry)
    {
        this.candidate_contry = candidate_contry;
    }

    /**
     * @return the candidate_zip
     */
    public String getCandidate_zip()
    {
        return candidate_zip;
    }

    /**
     * @param candidate_zip the candidate_zip to set
     */
    public void setCandidate_zip(final String candidate_zip)
    {
        this.candidate_zip = candidate_zip;
    }

    /**
     * @return the candidate_email
     */
    public String getCandidate_email()
    {
        return candidate_email;
    }

    /**
     * @param candidate_email the candidate_email to set
     */
    public void setCandidate_email(final String candidate_email)
    {
        this.candidate_email = candidate_email;
    }

    /**
     * @return the candidate_phone_number
     */
    public String getCandidate_phone_number()
    {
        return candidate_phone_number;
    }

    /**
     * @param candidate_phone_number the candidate_phone_number to set
     */
    public void setCandidate_phone_number(final String candidate_phone_number)
    {
        this.candidate_phone_number = candidate_phone_number;
    }

    /**
     * @return the candidate_github_url
     */
    public String getCandidate_github_url()
    {
        return candidate_github_url;
    }

    /**
     * @param candidate_github_url the candidate_github_url to set
     */
    public void setCandidate_github_url(final String candidate_github_url)
    {
        this.candidate_github_url = candidate_github_url;
    }
}
