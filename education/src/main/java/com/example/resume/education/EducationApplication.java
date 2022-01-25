package com.example.resume.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot application for the Education service.
 *
 * @author Ankush Pandit
 */
@SpringBootApplication
public class EducationApplication
{
    /**
     * Main entry point for the service.
     *
     * @param args String args to be passed in as a String array.
     */
    public static void main(final String[] args)
    {
        SpringApplication.run(EducationApplication.class, args);
    }
}
