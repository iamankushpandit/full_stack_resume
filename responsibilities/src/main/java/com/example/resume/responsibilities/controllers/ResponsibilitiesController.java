package com.example.resume.responsibilities.controllers;

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

import com.example.resume.responsibilities.models.Responsibilities;
import com.example.resume.responsibilities.respositories.ResponsibilitiesRepository;

@RestController
@RequestMapping("/api/v1/responsibilities")
@CrossOrigin(origins = "http://ec2-34-217-3-90.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class ResponsibilitiesController
{
    @Autowired
    private ResponsibilitiesRepository responsibilitiesRepository;

    @GetMapping
    public List<Responsibilities> list()
    {
        return responsibilitiesRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/responsibilities_id/{responsibilities_id}")
    public Responsibilities get(@PathVariable final String responsibilities_id)
    {
        return responsibilitiesRepository.getById(Long.parseLong(responsibilities_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Responsibilities> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return responsibilitiesRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    @PostMapping
    public Responsibilities create(@RequestBody final Responsibilities responsibilities)
    {
        return responsibilitiesRepository.saveAndFlush(responsibilities);
    }

    @DeleteMapping(value = "{responsibilities_id}")
    public void delete(@PathVariable final String responsibilities_id)
    {
        responsibilitiesRepository.deleteById(Long.parseLong(responsibilities_id));
    }

    @PutMapping(value = "{responsibilities_id}")
    public Responsibilities update(@PathVariable final String responsibilities_id, @RequestBody final Responsibilities responsibilities)
    {
        final Responsibilities existingResponsibilities = responsibilitiesRepository.getById(Long.parseLong(responsibilities_id));
        BeanUtils.copyProperties(responsibilities, existingResponsibilities, "responsibilities_id");
        return responsibilitiesRepository.saveAndFlush(existingResponsibilities);

        // TODO : think if all the controllers are pretty much doing the same thing can they use a
        // util with T,R..etc
        // Put models in one maven proj that all depend upon. Will that work well with SpringBoot?
    }
}
