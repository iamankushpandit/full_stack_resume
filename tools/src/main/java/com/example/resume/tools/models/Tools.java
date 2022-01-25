package com.example.resume.tools.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public Tools()
    {
        // Added for the ease of serialization.
        super();
    }

    public Long getTool_id()
    {
        return tool_id;
    }

    public void setTool_id(final Long tool_id)
    {
        this.tool_id = tool_id;
    }

    public Long getCandidate_id()
    {
        return candidate_id;
    }

    public void setCandidate_id(final Long candidate_id)
    {
        this.candidate_id = candidate_id;
    }

    public String getTool_type()
    {
        return tool_type;
    }

    public void setTool_type(final String tool_type)
    {
        this.tool_type = tool_type;
    }

    public String getTools()
    {
        return tools;
    }

    public void setTools(final String tools)
    {
        this.tools = tools;
    }
}
