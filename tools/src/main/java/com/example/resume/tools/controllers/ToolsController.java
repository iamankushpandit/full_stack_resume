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

@RestController
@RequestMapping("/api/v1/tools")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE }, allowedHeaders = "*", allowCredentials = "true")
public class ToolsController
{
    @Autowired
    private ToolsRepository toolsRepository;

    @GetMapping
    public List<Tools> list()
    {
        return toolsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/tools_id/{tools_id}")
    public Tools get(@PathVariable final String tools_id)
    {
        return toolsRepository.getById(Long.parseLong(tools_id));
    }

    @GetMapping()
    @RequestMapping("/candidate_id/{candidate_id}")
    public List<Tools> getByCandidate_Id(@PathVariable final String candidate_id)
    {
        return toolsRepository.findByCandidateId(Long.parseLong(candidate_id));
    }

    @PostMapping
    public Tools create(@RequestBody final Tools tools)
    {
        return toolsRepository.saveAndFlush(tools);
    }

    @DeleteMapping(value = "{tools_id}")
    public void delete(@PathVariable final String tools_id)
    {
        toolsRepository.deleteById(Long.parseLong(tools_id));
    }

    @PutMapping(value = "{tools_id}")
    public Tools update(@PathVariable final String tools_id, @RequestBody final Tools tools)
    {
        final Tools existingTools = toolsRepository.getById(Long.parseLong(tools_id));
        BeanUtils.copyProperties(tools, existingTools, "tools_id");
        return toolsRepository.saveAndFlush(existingTools);
    }
}
