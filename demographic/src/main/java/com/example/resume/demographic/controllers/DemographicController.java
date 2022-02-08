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

/**
 * Rest controller for Demographic.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/demographic")
@CrossOrigin(origins = "http://ec2-34-217-3-90.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class DemographicController
{
    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * @return a list of all the {@link Candidate}s.
     */
    @GetMapping
    public List<Candidate> list()
    {
        return candidateRepository.findAll();
    }

    /**
     * Get an {@link Candidate} based on the given id.
     *
     * @param id The id of the {@link Candidate} that needs to be fetched.
     * @return the {@link Candidate}.
     */
    @GetMapping
    @RequestMapping("{Id}")
    public List<Candidate> get(@PathVariable final String id)
    {
        return candidateRepository.findByCandidateId(Long.parseLong(id));
    }

    /**
     * Create a new {@link Candidate}.
     *
     * @param candidate the {@link Candidate} that needs to be created.
     * @return the created {@link Candidate}.
     */
    @PostMapping
    public Candidate create(@RequestBody final Candidate candidate)
    {
        return candidateRepository.saveAndFlush(candidate);
    }

    /**
     * Delete the {@link Candidate}.
     *
     * @param id the id of the {@link Candidate} to be deleted.
     */
    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable final Long id)
    {
        candidateRepository.deleteById(id);
    }

    /**
     * Update an existing {@link Candidate}.
     *
     * @param id The id of the {@link Candidate} to be updated.
     * @param candidate the new {@link Candidate} object.
     * @return the updated {@link Candidate} object.
     */
    @PutMapping(value = "{id}")
    public Candidate update(@PathVariable final Long id, @RequestBody final Candidate candidate)
    {
        final Candidate existingCandidate = candidateRepository.getById(id);
        BeanUtils.copyProperties(candidate, existingCandidate, "candidate_id");
        return candidateRepository.saveAndFlush(existingCandidate);
    }
}
