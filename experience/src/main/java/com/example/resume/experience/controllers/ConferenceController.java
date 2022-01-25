package com.example.resume.experience.controllers;

import java.util.Collections;
import java.util.Comparator;
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

@RestController
@RequestMapping("/api/v1/conference")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class ConferenceController
{
    @Autowired
    private ConferenceRepository conferenceRepository;

    @GetMapping
    public List<Conference> list()
    {
        return conferenceRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{conference_id}")
    public Conference get(@PathVariable final String conference_id)
    {
        return conferenceRepository.getById(Long.parseLong(conference_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Conference> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        final List<Conference> confs = conferenceRepository.findByCandidateId(Long.parseLong(candidate_id));
        Collections.sort(confs, new Comparator<Conference>()
        {
            @Override
            public int compare(final Conference z1, final Conference z2)
            {
                if (z1.getConference_id() > z2.getConference_id())
                {
                    return 1;
                }
                if (z1.getConference_id() < z2.getConference_id())
                {
                    return -1;
                }
                return 0;
            }
        });

        return confs;
    }

    @PostMapping
    public Conference create(@RequestBody final Conference conference)
    {
        return conferenceRepository.saveAndFlush(conference);
    }

    @DeleteMapping(value = "{conference_id}")
    public void delete(@PathVariable final String conference_id)
    {
        conferenceRepository.deleteById(Long.parseLong(conference_id));
    }

    @PutMapping(value = "{conference_id}")
    public Conference update(@PathVariable final String conference_id, @RequestBody final Conference conference)
    {
        final Conference existingConference = conferenceRepository.getById(Long.parseLong(conference_id));
        BeanUtils.copyProperties(conference, existingConference, "conference_id");
        return conferenceRepository.saveAndFlush(existingConference);
    }
}
