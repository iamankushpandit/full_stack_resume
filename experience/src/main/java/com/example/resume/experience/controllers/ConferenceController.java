package com.example.resume.experience.controllers;

import java.util.Collections;
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

import com.example.resume.experience.models.Conference;
import com.example.resume.experience.repositories.ConferenceRepository;

/**
 * Rest controller for Conference object.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/conference")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class ConferenceController
{
    @Autowired
    private ConferenceRepository conferenceRepository;

    /**
     * @return a list of all the {@link Conference}s.
     */
    @GetMapping
    public List<Conference> list()
    {
        return conferenceRepository.findAll();
    }

    /**
     * Get an {@link Conference} based on the given conference_id.
     *
     * @param conference_id The id of the {@link Conference} that needs to be fetched.
     * @return the {@link Conference}.
     */
    @GetMapping
    @RequestMapping("{conference_id}")
    public Conference get(@PathVariable final String conference_id)
    {
        return conferenceRepository.getById(Long.parseLong(conference_id));
    }

    /**
     * Return all the {@link Conference} for a given candidate
     * sorted based on their addition starting from first added to last.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link Conference}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Conference> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        final List<Conference> confs = conferenceRepository.findByCandidateId(Long.parseLong(candidate_id));
        Collections.sort(confs, (z1, z2) -> {
            if (z1.getConference_id() > z2.getConference_id())
            {
                return 1;
            }
            if (z1.getConference_id() < z2.getConference_id())
            {
                return -1;
            }
            return 0;
        });

        return confs;
    }

    /**
     * Create a new {@link Conference}.
     *
     * @param conference the {@link Conference} that needs to be created.
     * @return the created {@link Conference}.
     */
    @PostMapping
    public Conference create(@RequestBody final Conference conference)
    {
        return conferenceRepository.saveAndFlush(conference);
    }

    /**
     * Delete the {@link Conference}.
     *
     * @param conference_id the conference_id of the {@link Conference} to be deleted.
     */
    @DeleteMapping(value = "{conference_id}")
    public void delete(@PathVariable final String conference_id)
    {
        conferenceRepository.deleteById(Long.parseLong(conference_id));
    }

    /**
     * Update an existing {@link Conference}.
     *
     * @param conference_id The id of the {@link Conference} to be updated.
     * @param conference the new {@link Conference} object.
     * @return the updated {@link Conference} object.
     */
    @PutMapping(value = "{conference_id}")
    public Conference update(@PathVariable final String conference_id, @RequestBody final Conference conference)
    {
        final Conference existingConference = conferenceRepository.getById(Long.parseLong(conference_id));
        BeanUtils.copyProperties(conference, existingConference, "conference_id");
        return conferenceRepository.saveAndFlush(existingConference);
    }
}
