package com.msi.micromocks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.msi.micromocks.dto.DeveloperControllerDTO;
import com.msi.micromocks.dto.MockControllerDto;
import com.msi.micromocks.entity.Mock;
import com.msi.micromocks.feignclients.DeveloperFeignClient;
import com.msi.micromocks.repository.MocksRepository;

import reactor.core.publisher.Mono;

@Service
public class MocksService {

	@Autowired
	MocksRepository mocksRepository;
	
	@Autowired
	DeveloperFeignClient developerFeignClient;
	
	@Autowired
	WebClient webClient;
	
	public MocksService() {
		System.out.println("MocksService");		
	}
	
	public MockControllerDto getbyId(long id) {
		Mock mock = mocksRepository.findById(id).get();
		MockControllerDto controllerDto = new MockControllerDto(mock);
//		System.out.println(developerFeignClient.getById(mock.getDeveloper_id()));
		controllerDto.setDeveloper(developerFeignClient.getById(mock.getDeveloper_id()));
//		controllerDto.setDeveloper(getDeveloperById(mock.getDeveloper_id()));
		return controllerDto;
	}
	
	public DeveloperControllerDTO getDeveloperById (long id) {
		Mono<DeveloperControllerDTO> developerControllerDTO = 
				webClient.get().uri("/" + id)
		.retrieve().bodyToMono(DeveloperControllerDTO.class);
		
		return developerControllerDTO.block();
	}
	
}
