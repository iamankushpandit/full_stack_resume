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

/**
 * Rest controller for Certification.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/certification")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://ec2-34-217-3-90.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class CertificationController
{
    @Autowired
    private CertificationRepository certificationRepository;

    /**
     * @return a list of all the {@link Certification}s.
     */
    @GetMapping
    public List<Certification> list()
    {
        return certificationRepository.findAll();
    }

    /**
     * Get an {@link Certification} based on the given award_id.
     *
     * @param certification_id The id of the {@link Certification} that needs to be fetched.
     * @return the {@link Certification}.
     */
    @GetMapping
    @RequestMapping("/{certification_id}")
    public Certification get(@PathVariable final String certification_id)
    {
        return certificationRepository.getById(Long.parseLong(certification_id));
    }

    /**
     * Return all the {@link Certification} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link Certification}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Certification> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return certificationRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    /**
     * Create a new {@link Certification}.
     *
     * @param certification the {@link Certification} that needs to be created.
     * @return the created {@link Certification}.
     */
    @PostMapping
    public Certification create(@RequestBody final Certification certification)
    {
        return certificationRepository.saveAndFlush(certification);
    }

    /**
     * Delete the {@link Certification}.
     *
     * @param certification_id the award_id of the {@link Certification} to be deleted.
     */
    @DeleteMapping(value = "{certification_id}")
    public void delete(@PathVariable final String certification_id)
    {
        certificationRepository.deleteById(Long.parseLong(certification_id));
    }

    /**
     * Update an existing {@link Certification}.
     *
     * @param certification_id The id of the {@link Certification} to be updated.
     * @param certification the new {@link Certification} object.
     * @return the updated {@link Certification} object.
     */
    @PutMapping(value = "{certification_id}")
    public Certification update(@PathVariable final String certification_id, @RequestBody final Certification certification)
    {
        final Certification existingCertification = certificationRepository.getById(Long.parseLong(certification_id));
        BeanUtils.copyProperties(certification, existingCertification, "certification_id");
        return certificationRepository.saveAndFlush(existingCertification);
    }
}
