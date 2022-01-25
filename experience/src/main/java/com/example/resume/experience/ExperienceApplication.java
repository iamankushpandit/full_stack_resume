package com.example.resume.experience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application for the Experience service.
 *
 * @author Ankush Pandit
 */
@SpringBootApplication
public class ExperienceApplication
{
    /**
     * Main entry point for the service.
     *
     * @param args String args to be passed in as a String array.
     */
    public static void main(final String[] args)
    {
        SpringApplication.run(ExperienceApplication.class, args);
    }
}
