package com.example.resume.experience.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity(name = "job_profile")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class JobProfile
{
    public JobProfile()
    {
        // Added for the ease of serialization.
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_profile_id;
    private Long candidate_id;
    private String job_title;
    private Long company_id;
    private Date job_start_date;
    private Date job_end_date;
    @Type(type = "com.vladmihalcea.hibernate.type.array.ListArrayType", parameters = { @Parameter(name = ListArrayType.SQL_ARRAY_TYPE, value = "job_duties")
    })
    @Column(name = "job_duties", columnDefinition = "job_duties[]")
    private List<String> job_duties;
    @Type(type = "com.vladmihalcea.hibernate.type.array.ListArrayType", parameters = { @Parameter(name = ListArrayType.SQL_ARRAY_TYPE, value = "job_highlights")
    })
    @Column(name = "job_highlights", columnDefinition = "job_highlights[]")
    private List<String> job_highlights;
    private boolean current_job;

    public Long getJob_profile_id()
    {
        return job_profile_id;
    }

    public void setJob_profile_id(final Long job_profile_id)
    {
        this.job_profile_id = job_profile_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getJob_title()
    {
        return job_title;
    }

    public void setJob_title(final String job_title)
    {
        this.job_title = job_title;
    }

    public Long getCompany_id()
    {
        return company_id;
    }

    public void setCompany_id(final Long company_id)
    {
        this.company_id = company_id;
    }

    public Date getJob_start_date()
    {
        return job_start_date;
    }

    public void setJob_start_date(final Date job_start_date)
    {
        this.job_start_date = job_start_date;
    }

    public Date getJob_end_date()
    {
        return job_end_date;
    }

    public void setJob_end_date(final Date job_end_date)
    {
        this.job_end_date = job_end_date;
    }

    public List<String> getJob_duties()
    {
        return job_duties;
    }

    public void setJob_duties(final List<String> job_duties)
    {
        this.job_duties = job_duties;
    }

    public List<String> getJob_highlights()
    {
        return job_highlights;
    }

    public void setJob_highlights(final List<String> job_highlights)
    {
        this.job_highlights = job_highlights;
    }

    public boolean isCurrent_job()
    {
        return current_job;
    }

    public void setCurrent_job(final boolean current_job)
    {
        this.current_job = current_job;
    }
}
