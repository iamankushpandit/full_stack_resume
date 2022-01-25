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

import com.example.resume.experience.models.OpenSourceContribution;
import com.example.resume.experience.repositories.OpenSourceContributionRepository;

@RestController
@RequestMapping("/api/v1/open_source_contribution")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class OpenSourceContributionController
{
    @Autowired
    private OpenSourceContributionRepository openSourceContributionRepository;

    @GetMapping
    public List<OpenSourceContribution> list()
    {
        return openSourceContributionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{open_source_contribution_id}")
    public OpenSourceContribution get(@PathVariable final String open_source_contribution_id)
    {
        return openSourceContributionRepository.getById(Long.parseLong(open_source_contribution_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<OpenSourceContribution> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        final List<OpenSourceContribution> confs = openSourceContributionRepository.findByCandidateId(Long.parseLong(candidate_id));
        Collections.sort(confs, new Comparator<OpenSourceContribution>()
        {
            @Override
            public int compare(final OpenSourceContribution z1, final OpenSourceContribution z2)
            {
                if (z1.getOpen_source_contribution_id() > z2.getOpen_source_contribution_id())
                {
                    return 1;
                }
                if (z1.getOpen_source_contribution_id() < z2.getOpen_source_contribution_id())
                {
                    return -1;
                }
                return 0;
            }
        });

        return confs;
    }

    @PostMapping
    public OpenSourceContribution create(@RequestBody final OpenSourceContribution openSourceContribution)
    {
        return openSourceContributionRepository.saveAndFlush(openSourceContribution);
    }

    @DeleteMapping(value = "{open_source_contribution_id}")
    public void delete(@PathVariable final String open_source_contribution_id)
    {
        openSourceContributionRepository.deleteById(Long.parseLong(open_source_contribution_id));
    }

    @PutMapping(value = "{open_source_contribution_id}")
    public OpenSourceContribution update(@PathVariable final String open_source_contribution_id, @RequestBody final OpenSourceContribution openSourceContribution)
    {
        final OpenSourceContribution existingOpenSourceContribution = openSourceContributionRepository.getById(Long.parseLong(open_source_contribution_id));
        BeanUtils.copyProperties(openSourceContribution, existingOpenSourceContribution, "open_source_contribution_id");
        return openSourceContributionRepository.saveAndFlush(existingOpenSourceContribution);
    }
}
