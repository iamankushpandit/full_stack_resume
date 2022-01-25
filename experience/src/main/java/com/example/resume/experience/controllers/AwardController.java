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

@RestController
@RequestMapping("/api/v1/award")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class AwardController
{
    @Autowired
    private AwardRepository awardRepository;

    @GetMapping
    public List<Award> list()
    {
        return awardRepository.findAll();
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Award> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return awardRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    @GetMapping
    @RequestMapping("{award_id}")
    public Award get(@PathVariable final String award_id)
    {
        return awardRepository.getById(Long.parseLong(award_id));
    }

    @PostMapping
    public Award create(@RequestBody final Award award)
    {
        return awardRepository.saveAndFlush(award);
    }

    @DeleteMapping(value = "{award_id}")
    public void delete(@PathVariable final String award_id)
    {
        awardRepository.deleteById(Long.parseLong(award_id));
    }

    @PutMapping(value = "{award_id}")
    public Award update(@PathVariable final String award_id, @RequestBody final Award award)
    {
        final Award existingAward = awardRepository.getById(Long.parseLong(award_id));
        BeanUtils.copyProperties(award, existingAward, "award_id");
        return awardRepository.saveAndFlush(existingAward);
    }
}
