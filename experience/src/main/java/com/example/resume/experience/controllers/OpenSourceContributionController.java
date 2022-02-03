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

import com.example.resume.experience.models.Award;
import com.example.resume.experience.models.OpenSourceContribution;
import com.example.resume.experience.repositories.OpenSourceContributionRepository;

/**
 * Rest controller for OpenSourceContributions.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/open_source_contribution")
@CrossOrigin(origins = "http://ec2-54-212-37-29.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class OpenSourceContributionController
{
    @Autowired
    private OpenSourceContributionRepository openSourceContributionRepository;

    /**
     * @return a list of all the {@link OpenSourceContribution}s.
     */
    @GetMapping
    public List<OpenSourceContribution> list()
    {
        return openSourceContributionRepository.findAll();
    }

    /**
     * Get an {@link OpenSourceContribution} based on the open_source_contribution_id.
     *
     * @param open_source_contribution_id The id of the {@link OpenSourceContribution} that needs to
     *            be fetched.
     * @return the {@link OpenSourceContribution}.
     */
    @GetMapping
    @RequestMapping("{open_source_contribution_id}")
    public OpenSourceContribution get(@PathVariable final String open_source_contribution_id)
    {
        return openSourceContributionRepository.getById(Long.parseLong(open_source_contribution_id));
    }

    /**
     * Return all the {@link OpenSourceContribution} for a given candidate
     * sorted by candidate_id.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link OpenSourceContribution}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<OpenSourceContribution> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        final List<OpenSourceContribution> confs = openSourceContributionRepository.findByCandidateId(Long.parseLong(candidate_id));
        Collections.sort(confs, (z1, z2) -> {
            if (z1.getOpen_source_contribution_id() > z2.getOpen_source_contribution_id())
            {
                return 1;
            }
            if (z1.getOpen_source_contribution_id() < z2.getOpen_source_contribution_id())
            {
                return -1;
            }
            return 0;
        });

        return confs;
    }

    /**
     * Create a new {@link OpenSourceContribution}.
     *
     * @param openSourceContribution the {@link OpenSourceContribution} that needs to be created.
     * @return the created {@link OpenSourceContribution}.
     */
    @PostMapping
    public OpenSourceContribution create(@RequestBody final OpenSourceContribution openSourceContribution)
    {
        return openSourceContributionRepository.saveAndFlush(openSourceContribution);
    }

    /**
     * Delete the {@link OpenSourceContribution}.
     *
     * @param open_source_contribution_id the open_source_contribution_id of the
     *            {@link OpenSourceContribution} to be deleted.
     */
    @DeleteMapping(value = "{open_source_contribution_id}")
    public void delete(@PathVariable final String open_source_contribution_id)
    {
        openSourceContributionRepository.deleteById(Long.parseLong(open_source_contribution_id));
    }

    /**
     * Update an existing {@link Award}.
     *
     * @param open_source_contribution_id The id of the {@link OpenSourceContribution} to be
     *            updated.
     * @param openSourceContribution the new {@link OpenSourceContribution} object.
     * @return the updated {@link OpenSourceContribution} object.
     */
    @PutMapping(value = "{open_source_contribution_id}")
    public OpenSourceContribution update(@PathVariable final String open_source_contribution_id,
            @RequestBody final OpenSourceContribution openSourceContribution)
    {
        final OpenSourceContribution existingOpenSourceContribution = openSourceContributionRepository.getById(Long.parseLong(open_source_contribution_id));
        BeanUtils.copyProperties(openSourceContribution, existingOpenSourceContribution, "open_source_contribution_id");
        return openSourceContributionRepository.saveAndFlush(existingOpenSourceContribution);
    }
}
