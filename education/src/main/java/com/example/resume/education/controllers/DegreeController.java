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

@RestController
@RequestMapping("/api/v1/education")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")

public class DegreeController
{
    @Autowired
    private DegreeRepository degreeRepository;

    @GetMapping
    public List<com.example.resume.education.models.Degree> list()
    {
        return degreeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/degree_id/{degree_id}")
    public Degree get(@PathVariable final String degree_id)
    {
        return degreeRepository.getById(Long.parseLong(degree_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Degree> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return degreeRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    @PostMapping
    public Degree create(@RequestBody final Degree degree)
    {
        return degreeRepository.saveAndFlush(degree);
    }

    @DeleteMapping(value = "{degree_id}")
    public void delete(@PathVariable final String degree_id)
    {
        degreeRepository.deleteById(Long.parseLong(degree_id));
    }

    @PutMapping(value = "{degree_id}")
    public Degree update(@PathVariable final String degree_id, @RequestBody final Degree degree)
    {
        final Degree existingDegree = degreeRepository.getById(Long.parseLong(degree_id));
        BeanUtils.copyProperties(degree, existingDegree, "degree_id");
        return degreeRepository.saveAndFlush(existingDegree);
    }
}
