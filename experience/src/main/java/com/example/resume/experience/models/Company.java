package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "company")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_id;
    private String company_name;
    private String company_first_address;
    private String company_second_address;
    private String company_city;
    private String company_state;
    private String company_contry;
    private String company_zip;
    private String company_email;
    private String company_phone_number;

    public Long getCompany_id()
    {
        return company_id;
    }

    public Company()
    {
        // Added for the ease of serialization.
        super();
    }

    public void setCompany_id(final Long company_id)
    {
        this.company_id = company_id;
    }

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

    public String getCompany_city()
    {
        return company_city;
    }

    public void setCompany_city(final String company_city)
    {
        this.company_city = company_city;
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
}
