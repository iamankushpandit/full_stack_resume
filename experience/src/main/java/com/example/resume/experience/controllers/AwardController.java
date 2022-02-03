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

import com.example.resume.experience.models.Award;
import com.example.resume.experience.repositories.AwardRepository;

/**
 * Rest controller for Awards.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/award")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://ec2-54-212-37-29.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class AwardController
{
    @Autowired
    private AwardRepository awardRepository;

    /**
     * @return a list of all the {@link Award}s.
     */
    @GetMapping
    public List<Award> list()
    {
        return awardRepository.findAll();
    }

    /**
     * Get an {@link Award} based on the given award_id.
     *
     * @param award_id The id of the {@link Award} that needs to be fetched.
     * @return the {@link Award}.
     */
    @GetMapping
    @RequestMapping("{award_id}")
    public Award get(@PathVariable final String award_id)
    {
        return awardRepository.getById(Long.parseLong(award_id));
    }

    /**
     * Return all the {@link Awards} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link Award}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Award> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return awardRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    /**
     * Create a new {@link Award}.
     *
     * @param award the {@link Award} that needs to be created.
     * @return the created {@link Award}.
     */
    @PostMapping
    public Award create(@RequestBody final Award award)
    {
        return awardRepository.saveAndFlush(award);
    }

    /**
     * Delete the {@link Award}.
     *
     * @param award_id the award_id of the {@link Award} to be deleted.
     */
    @DeleteMapping(value = "{award_id}")
    public void delete(@PathVariable final String award_id)
    {
        awardRepository.deleteById(Long.parseLong(award_id));
    }

    /**
     * Update an existing {@link Award}.
     *
     * @param award_id The id of the {@link Award} to be updated.
     * @param award the new {@link Award} object.
     * @return the updated {@link Award} object.
     */
    @PutMapping(value = "{award_id}")
    public Award update(@PathVariable final String award_id, @RequestBody final Award award)
    {
        final Award existingAward = awardRepository.getById(Long.parseLong(award_id));
        BeanUtils.copyProperties(award, existingAward, "award_id");
        return awardRepository.saveAndFlush(existingAward);
    }
}
