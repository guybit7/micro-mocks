package com.msi.developer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msi.developer.dto.DeveloperControllerDTO;
import com.msi.developer.entity.Developer;
import com.msi.developer.repository.DeveloperRepository;

@Service
public class DeveloperService {

	@Autowired
	DeveloperRepository developerRepository;
	
	public DeveloperControllerDTO getById(long id) {
		Developer dev = developerRepository.findById(id).get();
		DeveloperControllerDTO developerControllerDTO = new DeveloperControllerDTO(dev);
		return developerControllerDTO;
	}
}
