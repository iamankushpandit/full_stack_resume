package com.example.resume.headline.controllers;

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

import com.example.resume.headline.models.Headline;
import com.example.resume.headline.repositories.HeadlineRepository;

/**
 * Rest controller for Headline.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/headline")
@CrossOrigin(origins = "http://ec2-34-217-3-90.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class HeadlineController
{
    @Autowired
    private HeadlineRepository headlineRepository;

    /**
     * @return a list of all the {@link Headline}s.
     */
    @GetMapping
    public List<Headline> list()
    {
        return headlineRepository.findAll();
    }

    /**
     * Get an {@link Headline} based on the given headline_id.
     *
     * @param headline_id The headline_id of the {@link Headline} that needs to be fetched.
     * @return the {@link Headline}.
     */
    @GetMapping
    @RequestMapping("{headline_id}")
    public Headline get(@PathVariable final String headline_id)
    {
        return headlineRepository.getById(Long.parseLong(headline_id));
    }

    /**
     * Return all the {@link Headline} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link Headline}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Headline> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return headlineRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    /**
     * Create a new {@link Headline}.
     *
     * @param headline the {@link Headline} that needs to be created.
     * @return the created {@link Headline}.
     */
    @PostMapping
    public Headline create(@RequestBody final Headline headline)
    {
        return headlineRepository.saveAndFlush(headline);
    }

    /**
     * Delete the {@link Headline}.
     *
     * @param headline_id the headline_id of the {@link Headline} to be deleted.
     */
    @DeleteMapping(value = "{headline_id}")
    public void delete(@PathVariable final String headline_id)
    {
        headlineRepository.deleteById(Long.parseLong(headline_id));
    }

    /**
     * Update an existing {@link Headline}.
     *
     * @param headline_id The id of the {@link Headline} to be updated.
     * @param headline the new {@link Headline} object.
     * @return the updated {@link Headline} object.
     */
    @PutMapping(value = "{headline_id}")
    public Headline update(@PathVariable final String headline_id, @RequestBody final Headline headline)
    {
        final Headline existingHeadline = headlineRepository.getById(Long.parseLong(headline_id));
        BeanUtils.copyProperties(headline, existingHeadline, "headline_id");
        return headlineRepository.saveAndFlush(existingHeadline);
    }
}
