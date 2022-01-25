package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing an Open Source Contribution for a Candidate.
 *
 * @author Ankush Pandit
 */
@Entity(name = "open_source_contribution")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OpenSourceContribution
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long open_source_contribution_id;
    private Long candidate_id;
    private String issue;
    private String product;
    private String evidence_url;

    /**
     * Constructor.
     */
    public OpenSourceContribution()
    {
    }

    /**
     * @return the open_source_contribution_id
     */
    public Long getOpen_source_contribution_id()
    {
        return open_source_contribution_id;
    }

    /**
     * @param open_source_contribution_id the open_source_contribution_id to set
     */
    public void setOpen_source_contribution_id(final Long open_source_contribution_id)
    {
        this.open_source_contribution_id = open_source_contribution_id;
    }

    /**
     * @return the candidate_id
     */
    public Long getCandidate_id()
    {
        return candidate_id;
    }

    /**
     * @param candidate_id the candidate_id to set
     */
    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    /**
     * @return the issue
     */
    public String getIssue()
    {
        return issue;
    }

    /**
     * @param issue the issue to set
     */
    public void setIssue(final String issue)
    {
        this.issue = issue;
    }

    /**
     * @return the product
     */
    public String getProduct()
    {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(final String product)
    {
        this.product = product;
    }

    /**
     * @return the evidence_url
     */
    public String getEvidence_url()
    {
        return evidence_url;
    }

    /**
     * @param evidence_url the evidence_url to set
     */
    public void setEvidence_url(final String evidence_url)
    {
        this.evidence_url = evidence_url;
    }
}
