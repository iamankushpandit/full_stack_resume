package com.example.resume.education.controllers;

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

import com.example.resume.education.models.Degree;
import com.example.resume.education.repositories.DegreeRepository;

/**
 * Rest controller for Degree.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/education")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://ec2-54-212-37-29.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class DegreeController
{
    @Autowired
    private DegreeRepository degreeRepository;

    /**
     * @return a list of all the {@link Degree}s.
     */
    @GetMapping
    public List<Degree> list()
    {
        return degreeRepository.findAll();
    }

    /**
     * Get an {@link Degree} based on the given award_id.
     *
     * @param degree_id The id of the {@link Degree} that needs to be fetched.
     * @return the {@link Degree}.
     */
    @GetMapping
    @RequestMapping("{degree_id}")
    public Degree get(@PathVariable final String degree_id)
    {
        return degreeRepository.getById(Long.parseLong(degree_id));
    }

    /**
     * Return all the {@link Degree} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link Degree}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Degree> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return degreeRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    /**
     * Create a new {@link Degree}.
     *
     * @param degree the {@link Degree} that needs to be created.
     * @return the created {@link Degree}.
     */
    @PostMapping
    public Degree create(@RequestBody final Degree degree)
    {
        return degreeRepository.saveAndFlush(degree);
    }

    /**
     * Delete the {@link Degree}.
     *
     * @param degree_id the degree_id of the {@link Degree} to be deleted.
     */
    @DeleteMapping(value = "{degree_id}")
    public void delete(@PathVariable final String degree_id)
    {
        degreeRepository.deleteById(Long.parseLong(degree_id));
    }

    /**
     * Update an existing {@link Degree}.
     *
     * @param degree_id The id of the {@link Degree} to be updated.
     * @param degree the new {@link Degree} object.
     * @return the updated {@link Degree} object.
     */
    @PutMapping(value = "{degree_id}")
    public Degree update(@PathVariable final String degree_id, @RequestBody final Degree degree)
    {
        final Degree existingDegree = degreeRepository.getById(Long.parseLong(degree_id));
        BeanUtils.copyProperties(degree, existingDegree, "degree_id");
        return degreeRepository.saveAndFlush(existingDegree);
    }
}
