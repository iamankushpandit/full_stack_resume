package com.example.resume.experience.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public OpenSourceContribution()
    {
        super();
    }

    public Long getOpen_source_contribution_id()
    {
        return open_source_contribution_id;
    }

    public void setOpen_source_contribution_id(final Long open_source_contribution_id)
    {
        this.open_source_contribution_id = open_source_contribution_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getIssue()
    {
        return issue;
    }

    public void setIssue(final String issue)
    {
        this.issue = issue;
    }

    public String getProduct()
    {
        return product;
    }

    public void setProduct(final String product)
    {
        this.product = product;
    }

    public String getEvidence_url()
    {
        return evidence_url;
    }

    public void setEvidence_url(final String evidence_url)
    {
        this.evidence_url = evidence_url;
    }

}
