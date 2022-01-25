package com.example.resume.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.resume.tools.*")
public class ToolsApplication
{

    public static void main(final String[] args)
    {
        SpringApplication.run(ToolsApplication.class, args);
    }

}
