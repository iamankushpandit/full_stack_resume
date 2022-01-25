package com.example.resume.experience.controllers;

import java.util.ArrayList;
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

import com.example.resume.experience.models.Company;
import com.example.resume.experience.models.JobProfile;
import com.example.resume.experience.models.JobProfileWithCompanyInfo;
import com.example.resume.experience.repositories.CompanyRepository;
import com.example.resume.experience.repositories.JobProfileRepository;

/**
 * Rest controller for Job Profiles.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/job_profile")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class JobProfileController
{
    @Autowired
    private JobProfileRepository jobProfileRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * @return a list of all the {@link JobProfile}s.
     */
    @GetMapping
    public List<JobProfile> list()
    {
        return jobProfileRepository.findAll();
    }

    /**
     * Get an {@link JobProfile} based on the given job_profile_id.
     *
     * @param job_profile_id The id of the {@link JobProfile} that needs to be fetched.
     * @return the {@link JobProfile}.
     */
    @GetMapping
    @RequestMapping("/{job_profile_id}")
    public JobProfile get(@PathVariable final String job_profile_id)
    {
        return jobProfileRepository.getById(Long.parseLong(job_profile_id));
    }

    /**
     * Return all the {@link JobProfile} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link JobProfile}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<JobProfile> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return jobProfileRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    /**
     * Return all the {@link JobProfileWithCompanyInfo} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link JobProfileWithCompanyInfo}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id_comp/{candidate_id}")
    public List<JobProfileWithCompanyInfo> getByCandidate_IdWithCompanyInfo(@PathVariable final String candidate_id)
    {
        final List<JobProfile> jobProfiles = jobProfileRepository.findByCandidateId(Long.parseLong(candidate_id));
        Collections.sort(jobProfiles, (z1, z2) -> {
            if (z1.getJob_profile_id() > z2.getJob_profile_id())
            {
                return 1;
            }
            if (z1.getJob_profile_id() < z2.getJob_profile_id())
            {
                return -1;
            }
            return 0;
        });
        final List<JobProfileWithCompanyInfo> companyInfoJobProfileList = new ArrayList<>();
        for (final JobProfile jp : jobProfiles)
        {
            final Long company_id = jp.getCompany_id();
            final Company company = companyRepository.getById(company_id);
            final JobProfileWithCompanyInfo jobProfileWithCompanyInfo = new JobProfileWithCompanyInfo();
            jobProfileWithCompanyInfo.setCandidate_id(jp.getCandidate_id());
            jobProfileWithCompanyInfo.setCompany_id(company_id);
            jobProfileWithCompanyInfo.setCurrent_job(jp.isCurrent_job());
            jobProfileWithCompanyInfo.setJob_duties(jp.getJob_duties());
            jobProfileWithCompanyInfo.setJob_end_date(jp.getJob_end_date());
            jobProfileWithCompanyInfo.setJob_highlights(jp.getJob_highlights());
            jobProfileWithCompanyInfo.setJob_profile_id(jp.getJob_profile_id());
            jobProfileWithCompanyInfo.setJob_start_date(jp.getJob_start_date());
            jobProfileWithCompanyInfo.setJob_title(jp.getJob_title());
            jobProfileWithCompanyInfo.setCompany_city(company.getCompany_city());
            jobProfileWithCompanyInfo.setCompany_contry(company.getCompany_contry());
            jobProfileWithCompanyInfo.setCompany_email(company.getCompany_email());
            jobProfileWithCompanyInfo.setCompany_first_address(company.getCompany_first_address());
            jobProfileWithCompanyInfo.setCompany_name(company.getCompany_name());
            jobProfileWithCompanyInfo.setCompany_phone_number(company.getCompany_phone_number());
            jobProfileWithCompanyInfo.setCompany_second_address(company.getCompany_second_address());
            jobProfileWithCompanyInfo.setCompany_state(company.getCompany_state());
            jobProfileWithCompanyInfo.setCompany_zip(company.getCompany_zip());
            companyInfoJobProfileList.add(jobProfileWithCompanyInfo);
        }
        return companyInfoJobProfileList;
    }

    /**
     * Create a new {@link JobProfile}.
     *
     * @param jobProfile the {@link JobProfile} that needs to be created.
     * @return the created {@link JobProfile}.
     */
    @PostMapping
    public JobProfile create(@RequestBody final JobProfile jobProfile)
    {
        return jobProfileRepository.saveAndFlush(jobProfile);
    }

    /**
     * Delete the {@link JobProfile}.
     *
     * @param award_id the job_profile_id of the {@link JobProfile} to be deleted.
     */
    @DeleteMapping(value = "{job_profile_id}")
    public void delete(@PathVariable final String job_profile_id)
    {
        jobProfileRepository.deleteById(Long.parseLong(job_profile_id));
    }

    /**
     * Update an existing {@link JobProfile}.
     *
     * @param job_profile_id The id of the {@link JobProfile} to be updated.
     * @param jobProfile the new {@link JobProfile} object.
     * @return the updated {@link JobProfile} object.
     */
    @PutMapping(value = "{job_profile_id}")
    public JobProfile update(@PathVariable final String job_profile_id, @RequestBody final JobProfile jobProfile)
    {
        final JobProfile existingJobProfile = jobProfileRepository.getById(Long.parseLong(job_profile_id));
        BeanUtils.copyProperties(jobProfile, existingJobProfile, "job_profile_id");
        return jobProfileRepository.saveAndFlush(existingJobProfile);
    }
}
