package com.example.resume.responsibilities.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity(name = "responsibilities")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
public class Responsibilities
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responsibilities_id;
    private Long candidate_id;
    @Type(type = "com.vladmihalcea.hibernate.type.array.ListArrayType", parameters = { @Parameter(name = ListArrayType.SQL_ARRAY_TYPE, value = "responsibilities")
    })
    @Column(name = "responsibilities", columnDefinition = "responsibilities[]")
    private List<String> responsibilities;

    public List<String> getResponsibilities()
    {
        return responsibilities;
    }

    public void setResponsibilities(final List<String> responsibilities)
    {
        this.responsibilities = responsibilities;
    }

    public Responsibilities()
    {
        // Added for the ease of serialization.
        super();
    }

    public Long getResponsibilities_id()
    {
        return responsibilities_id;
    }

    public void setResponsibilities_id(final Long responsibilities_id)
    {
        this.responsibilities_id = responsibilities_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

}
