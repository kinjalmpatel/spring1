package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Experience;
import com.example.demo.repositary.ExperienceRepository;

@Service
@Transactional

public class ExperienceService {
	
@Autowired
 ExperienceRepository experienceRepository;

	public Experience saveExperience(Experience experience) {
	    return experienceRepository.save(experience);
	}
}
