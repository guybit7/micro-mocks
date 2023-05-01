package com.msi.micromocks.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.msi.micromocks.dto.DeveloperControllerDTO;
import com.msi.micromocks.dto.MockControllerDto;
import com.msi.micromocks.entity.Mock;
import com.msi.micromocks.feignclients.DeveloperFeignClient;
import com.msi.micromocks.infra.encapsulate.BusinessException;
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
	
	DozerBeanMapper mapper = new DozerBeanMapper();

	public MocksService() {
		System.out.println("MocksService");		
	}
	
	public MockControllerDto getbyId(long id) {
		Mock mock = null;
		try {
			mock = mocksRepository.findById(id).get();			
		} catch (NoSuchElementException e) {
			throw new BusinessException("id- "+id+" not found");
		}

		System.out.println("BEFORE MAPPER");
		MockControllerDto controllerDto = mapper.map(mock, MockControllerDto.class);
//		MockControllerDto controllerDto = new MockControllerDto(mock);
//		System.out.println(developerFeignClient.getById(mock.getDeveloper_id()));
		controllerDto.setDeveloper(developerFeignClient.getById(mock.getDeveloperId()));
//		controllerDto.setDeveloper(getDeveloperById(mock.getDeveloper_id()));
		return controllerDto;
	}
	
	public DeveloperControllerDTO getDeveloperById (long id) {
		Mono<DeveloperControllerDTO> developerControllerDTO = 
				webClient.get().uri("/" + id)
		.retrieve().bodyToMono(DeveloperControllerDTO.class);
		
		return developerControllerDTO.block();
	}

	public ArrayList<Mock> getByDeveloperId(long id) {
		return mocksRepository.findAllByDeveloperId(id);
	}
	
}
