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

@RestController
@RequestMapping("/api/v1/headline")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class HeadlineController
{
    @Autowired
    private HeadlineRepository headlineRepository;

    @GetMapping
    public List<Headline> list()
    {
        return headlineRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/headline_id/{headline_id}")
    public Headline get(@PathVariable final String headline_id)
    {
        return headlineRepository.getById(Long.parseLong(headline_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Headline> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return headlineRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    @PostMapping
    public Headline create(@RequestBody final Headline headline)
    {
        return headlineRepository.saveAndFlush(headline);
    }

    @DeleteMapping(value = "{headline_id}")
    public void delete(@PathVariable final String headline_id)
    {
        headlineRepository.deleteById(Long.parseLong(headline_id));
    }

    @PutMapping(value = "{headline_id}")
    public Headline update(@PathVariable final String headline_id, @RequestBody final Headline headline)
    {
        final Headline existingHeadline = headlineRepository.getById(Long.parseLong(headline_id));
        BeanUtils.copyProperties(headline, existingHeadline, "headline_id");
        return headlineRepository.saveAndFlush(existingHeadline);
    }
}
