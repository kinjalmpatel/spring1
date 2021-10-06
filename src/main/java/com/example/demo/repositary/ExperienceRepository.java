package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Experience;
@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{

}
