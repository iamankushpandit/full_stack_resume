package com.example.resume.tools.controllers;

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

import com.example.resume.tools.models.Tools;
import com.example.resume.tools.repositories.ToolsRepository;

/**
 * Rest controller for Tools.
 *
 * @author Ankush Pandit
 */
@RestController
@RequestMapping("/api/v1/tools")
// The following is done to allow request from the react front end to be accepted.
@CrossOrigin(origins = "http://ec2-54-212-37-29.us-west-2.compute.amazonaws.com:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class ToolsController
{
    @Autowired
    private ToolsRepository toolsRepository;

    /**
     * @return a list of all the {@link Tools}s.
     */
    @GetMapping
    public List<Tools> list()
    {
        return toolsRepository.findAll();
    }

    /**
     * Get an {@link Tools} based on the given tools_id.
     *
     * @param tools_id The tools_id of the {@link Tools} that needs to be fetched.
     * @return the {@link Tools}.
     */
    @GetMapping
    @RequestMapping("/tools_id/{tools_id}")
    public Tools get(@PathVariable final String tools_id)
    {
        return toolsRepository.getById(Long.parseLong(tools_id));
    }

    /**
     * Return all the {@link Tools} for a given candidate.
     *
     * @param candidate_id the String id of the candidate.
     *
     * @return all {@link Tools}s for the given candidate_id.
     */
    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Tools> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return toolsRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    /**
     * Create a new {@link Tools}.
     *
     * @param tools the {@link Tools} that needs to be created.
     * @return the created {@link Tools}.
     */
    @PostMapping
    public Tools create(@RequestBody final Tools tools)
    {
        return toolsRepository.saveAndFlush(tools);
    }

    /**
     * Delete the {@link Tools}.
     *
     * @param tools_id the tools_id of the {@link Tools} to be deleted.
     */
    @DeleteMapping(value = "{tools_id}")
    public void delete(@PathVariable final String tools_id)
    {
        toolsRepository.deleteById(Long.parseLong(tools_id));
    }

    /**
     * Update an existing {@link Tools}.
     *
     * @param tools_id The id of the {@link Tools} to be updated.
     * @param tools the new {@link Tools} object.
     * @return the updated {@link Tools} object.
     */
    @PutMapping(value = "{tools_id}")
    public Tools update(@PathVariable final String tools_id, @RequestBody final Tools tools)
    {
        final Tools existingTools = toolsRepository.getById(Long.parseLong(tools_id));
        BeanUtils.copyProperties(tools, existingTools, "tools_id");
        return toolsRepository.saveAndFlush(existingTools);
    }
}
