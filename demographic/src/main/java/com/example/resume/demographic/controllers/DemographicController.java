package com.example.resume.demographic.controllers;

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

import com.example.resume.demographic.models.Candidate;
import com.example.resume.demographic.repositories.CandidateRepository;

@RestController
@RequestMapping("/api/v1/demographic")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class DemographicController
{
    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping
    public List<Candidate> list()
    {
        return candidateRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{Id}")
    public List<Candidate> get(@PathVariable final String id)
    {
        return candidateRepository.findByCandidateId(Long.parseLong(id));
    }

    @PostMapping
    public Candidate create(@RequestBody final Candidate candidate)
    {
        return candidateRepository.saveAndFlush(candidate);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable final Long id)
    {
        candidateRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Candidate update(@PathVariable final Long id, @RequestBody final Candidate candidate)
    {
        final Candidate existingCandidate = candidateRepository.getById(id);
        BeanUtils.copyProperties(candidate, existingCandidate, "candidate_id");
        return candidateRepository.saveAndFlush(existingCandidate);
    }
}
