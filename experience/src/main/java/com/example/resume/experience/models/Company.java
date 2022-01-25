package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing an Company.
 *
 * @author Ankush Pandit
 */
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

    /**
     * Constructor.
     */
    public Company()
    {
    }

    /**
     * @return the company_id
     */
    public Long getCompany_id()
    {
        return company_id;
    }

    /**
     * @param company_id the company_id to set
     */
    public void setCompany_id(final Long company_id)
    {
        this.company_id = company_id;
    }

    /**
     * @return the company_name
     */
    public String getCompany_name()
    {
        return company_name;
    }

    /**
     * @param company_name the company_name to set
     */
    public void setCompany_name(final String company_name)
    {
        this.company_name = company_name;
    }

    /**
     * @return the company_first_address
     */
    public String getCompany_first_address()
    {
        return company_first_address;
    }

    /**
     * @param company_first_address the company_first_address to set
     */
    public void setCompany_first_address(final String company_first_address)
    {
        this.company_first_address = company_first_address;
    }

    /**
     * @return the company_second_address
     */
    public String getCompany_second_address()
    {
        return company_second_address;
    }

    /**
     * @param company_second_address the company_second_address to set
     */
    public void setCompany_second_address(final String company_second_address)
    {
        this.company_second_address = company_second_address;
    }

    /**
     * @return the company_city
     */
    public String getCompany_city()
    {
        return company_city;
    }

    /**
     * @param company_city the company_city to set
     */
    public void setCompany_city(final String company_city)
    {
        this.company_city = company_city;
    }

    /**
     * @return the company_state
     */
    public String getCompany_state()
    {
        return company_state;
    }

    /**
     * @param company_state the company_state to set
     */
    public void setCompany_state(final String company_state)
    {
        this.company_state = company_state;
    }

    /**
     * @return the company_contry
     */
    public String getCompany_contry()
    {
        return company_contry;
    }

    /**
     * @param company_contry the company_contry to set
     */
    public void setCompany_contry(final String company_contry)
    {
        this.company_contry = company_contry;
    }

    /**
     * @return the company_zip
     */
    public String getCompany_zip()
    {
        return company_zip;
    }

    /**
     * @param company_zip the company_zip to set
     */
    public void setCompany_zip(final String company_zip)
    {
        this.company_zip = company_zip;
    }

    /**
     * @return the company_email
     */
    public String getCompany_email()
    {
        return company_email;
    }

    /**
     * @param company_email the company_email to set
     */
    public void setCompany_email(final String company_email)
    {
        this.company_email = company_email;
    }

    /**
     * @return the company_phone_number
     */
    public String getCompany_phone_number()
    {
        return company_phone_number;
    }

    /**
     * @param company_phone_number the company_phone_number to set
     */
    public void setCompany_phone_number(final String company_phone_number)
    {
        this.company_phone_number = company_phone_number;
    }

}
