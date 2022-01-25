package com.example.resume.experience.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resume.experience.models.Company;

/**
 * A {@link JpaRepository} for {@link Company} object.
 *
 * @author Ankush Pandit
 */
public interface CompanyRepository extends JpaRepository<Company, Long>
{
}
