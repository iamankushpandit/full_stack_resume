package com.example.resume.experience.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resume.experience.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>
{
}
