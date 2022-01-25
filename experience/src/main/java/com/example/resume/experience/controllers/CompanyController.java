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

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class CompanyController
{
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> list()
    {
        return companyRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{company_id}")
    public Company get(@PathVariable final String company_id)
    {
        return companyRepository.getById(Long.parseLong(company_id));
    }

    @PostMapping
    public Company create(@RequestBody final Company company)
    {
        return companyRepository.saveAndFlush(company);
    }

    @DeleteMapping(value = "{company_id}")
    public void delete(@PathVariable final String company_id)
    {
        companyRepository.deleteById(Long.parseLong(company_id));
    }

    @PutMapping(value = "{company_id}")
    public Company update(@PathVariable final String company_id, @RequestBody final Company company)
    {
        final Company existingCompany = companyRepository.getById(Long.parseLong(company_id));
        BeanUtils.copyProperties(company, existingCompany, "company_id");
        return companyRepository.saveAndFlush(existingCompany);
    }
}
