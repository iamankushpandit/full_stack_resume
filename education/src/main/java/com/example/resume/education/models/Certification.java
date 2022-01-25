package com.example.resume.education.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "certification")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Certification
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certification_id;
    private Long candidate_id;
    private String certification_name;
    private String certification_complete_date;
    private String certification_institution_name;

    public Certification()
    {
        super();
    }

    public Long getCertification_id()
    {
        return certification_id;
    }

    public void setCertification_id(final Long certification_id)
    {
        this.certification_id = certification_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getCertification_name()
    {
        return certification_name;
    }

    public void setCertification_name(final String certification_name)
    {
        this.certification_name = certification_name;
    }

    public String getCertification_complete_date()
    {
        return certification_complete_date;
    }

    public void setCertification_complete_date(final String certification_complete_date)
    {
        this.certification_complete_date = certification_complete_date;
    }

    public String getCertification_institution_name()
    {
        return certification_institution_name;
    }

    public void setCertification_institution_name(final String certification_institution_name)
    {
        this.certification_institution_name = certification_institution_name;
    }
}
