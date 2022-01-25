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

import com.example.resume.education.models.Certification;
import com.example.resume.education.repositories.CertificationRepository;

@RestController
@RequestMapping("/api/v1/certification")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class CertificationController
{
    @Autowired
    private CertificationRepository certificationRepository;

    @GetMapping
    public List<Certification> list()
    {
        return certificationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/certification_id/{certification_id}")
    public Certification get(@PathVariable final String certification_id)
    {
        return certificationRepository.getById(Long.parseLong(certification_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Certification> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return certificationRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    @PostMapping
    public Certification create(@RequestBody final Certification certification)
    {
        return certificationRepository.saveAndFlush(certification);
    }

    @DeleteMapping(value = "{certification_id}")
    public void delete(@PathVariable final String certification_id)
    {
        certificationRepository.deleteById(Long.parseLong(certification_id));
    }

    @PutMapping(value = "{certification_id}")
    public Certification update(@PathVariable final String certification_id, @RequestBody final Certification certification)
    {
        final Certification existingCertification = certificationRepository.getById(Long.parseLong(certification_id));
        BeanUtils.copyProperties(certification, existingCertification, "certification_id");
        return certificationRepository.saveAndFlush(existingCertification);
    }
}
