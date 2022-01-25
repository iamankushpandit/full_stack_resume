package com.example.resume.experience.models;

import java.sql.Date;
import java.util.List;

public class JobProfileWithCompanyInfo
{
    public JobProfileWithCompanyInfo()
    {
        // Added for the ease of serialization.
        super();
    }

    private Long job_profile_id;
    private Long candidate_id;
    private String job_title;
    private Long company_id;
    private Date job_start_date;
    private Date job_end_date;
    private List<String> job_duties;
    private List<String> job_highlights;
    private boolean current_job;

    public String getCompany_name()
    {
        return company_name;
    }

    public void setCompany_name(final String company_name)
    {
        this.company_name = company_name;
    }

    public String getCompany_first_address()
    {
        return company_first_address;
    }

    public void setCompany_first_address(final String company_first_address)
    {
        this.company_first_address = company_first_address;
    }

    public String getCompany_second_address()
    {
        return company_second_address;
    }

    public void setCompany_second_address(final String company_second_address)
    {
        this.company_second_address = company_second_address;
    }

    public String getCompany_state()
    {
        return company_state;
    }

    public void setCompany_state(final String company_state)
    {
        this.company_state = company_state;
    }

    public String getCompany_contry()
    {
        return company_contry;
    }

    public void setCompany_contry(final String company_contry)
    {
        this.company_contry = company_contry;
    }

    public String getCompany_zip()
    {
        return company_zip;
    }

    public void setCompany_zip(final String company_zip)
    {
        this.company_zip = company_zip;
    }

    public String getCompany_email()
    {
        return company_email;
    }

    public void setCompany_email(final String company_email)
    {
        this.company_email = company_email;
    }

    public String getCompany_phone_number()
    {
        return company_phone_number;
    }

    public void setCompany_phone_number(final String company_phone_number)
    {
        this.company_phone_number = company_phone_number;
    }

    private String company_name;
    private String company_first_address;
    private String company_second_address;
    private String company_city;
    private String company_state;
    private String company_contry;
    private String company_zip;
    private String company_email;
    private String company_phone_number;

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

    public String getCompany_city()
    {
        return company_city;
    }

    public void setCompany_city(final String company_city)
    {
        this.company_city = company_city;
    }
}