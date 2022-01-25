package com.example.resume.tools.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The POJO representing an Tools for a Candidate.
 *
 * @author Ankush Pandit
 */
@Entity(name = "tools")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Tools
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tool_id;
    private Long candidate_id;
    private String tool_type;
    private String tools;

    /**
     * Constructor.
     */
    public Tools()
    {
    }

    /**
     * @return the tool_id
     */
    public Long getTool_id()
    {
        return tool_id;
    }

    /**
     * @param tool_id the tool_id to set
     */
    public void setTool_id(final Long tool_id)
    {
        this.tool_id = tool_id;
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
     * @return the tool_type
     */
    public String getTool_type()
    {
        return tool_type;
    }

    /**
     * @param tool_type the tool_type to set
     */
    public void setTool_type(final String tool_type)
    {
        this.tool_type = tool_type;
    }

    /**
     * @return the tools
     */
    public String getTools()
    {
        return tools;
    }

    /**
     * @param tools the tools to set
     */
    public void setTools(final String tools)
    {
        this.tools = tools;
    }
}
