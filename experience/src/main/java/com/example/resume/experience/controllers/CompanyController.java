package com.example.resume.experience.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume.experience.models.Company;
import com.example.resume.experience.repositories.CompanyRepository;

/**
 * The controller for the Company model.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/company")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://ec2-34-217-3-90.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class CompanyController
{
    @Autowired
    private CompanyRepository companyRepository;

    /**
     * @return a list of all the {@link Company}s.
     */
    @GetMapping
    public List<Company> list()
    {
        return companyRepository.findAll();
    }

    /**
     * Get an {@link Company} based on the given company_id.
     *
     * @param company_id The id of the {@link Company} that needs to be fetched.
     * @return the {@link Company}.
     */
    @GetMapping
    @RequestMapping("{company_id}")
    public Company get(@PathVariable final String company_id)
    {
        return companyRepository.getById(Long.parseLong(company_id));
    }

    /**
     * Create a new {@link Company}.
     *
     * @param company the {@link Company} that needs to be created.
     * @return the created {@link Company}.
     */
    @PostMapping
    public Company create(@RequestBody final Company company)
    {
        return companyRepository.saveAndFlush(company);
    }

    /**
     * Delete the {@link Company}.
     *
     * @param company_id the company_id of the {@link Company} to be deleted.
     */
    @DeleteMapping(value = "{company_id}")
    public void delete(@PathVariable final String company_id)
    {
        companyRepository.deleteById(Long.parseLong(company_id));
    }

    /**
     * Update an existing {@link Company}.
     *
     * @param company_id The id of the {@link Company} to be updated.
     * @param company the new {@link Company} object.
     * @return the updated {@link Company} object.
     */
    @PutMapping(value = "{company_id}")
    public Company update(@PathVariable final String company_id, @RequestBody final Company company)
    {
        final Company existingCompany = companyRepository.getById(Long.parseLong(company_id));
        BeanUtils.copyProperties(company, existingCompany, "company_id");
        return companyRepository.saveAndFlush(existingCompany);
    }
}
