package com.msi.micromocks.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.msi.micromocks.dto.MockItemControllerDTO;
import com.msi.micromocks.dto.MockItemInternalRequestControllerDTO;
import com.msi.micromocks.dto.VariantControllerDTO;
import com.msi.micromocks.entity.MockItem;
import com.msi.micromocks.entity.User;
import com.msi.micromocks.entity.Variant;
import com.msi.micromocks.repository.MockItemRepository;
import com.msi.micromocks.repository.UserRepository;
import com.msi.micromocks.repository.VariantRepository;
import org.springframework.data.domain.Sort;

@Service
public class MockItemService {
	
	@Autowired
	MockItemRepository itemRepository;
	
	@Autowired
	VariantRepository variantRepository;
	
	@Autowired
	UserRepository userRepository; 

	@Autowired
	DozerBeanMapper mapper;

	public MockItemControllerDTO getById(long id) {
		System.out.println("getById");
		MockItemControllerDTO mockItemControllerDTO = null;
		try {			
			MockItem m = itemRepository.findById(id).get();
			mockItemControllerDTO = mapper.map(m, MockItemControllerDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mockItemControllerDTO;
	}

	public MockItemControllerDTO getByEp(String ep) {
		MockItemControllerDTO mockItemControllerDTO = null;
		try {			
			MockItem m = itemRepository.findByEndpoint(ep);
			mockItemControllerDTO = mapper.map(m, MockItemControllerDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mockItemControllerDTO;
	}

	public MockItemControllerDTO getMockItem(MockItemInternalRequestControllerDTO mockItemRequestControllerDTO) {
		MockItemControllerDTO mockItemControllerDTO = null;
		try {			
			Variant variant = variantRepository.findById(2L).get();
			MockItem m = itemRepository.findByEndpointAndVariant(mockItemRequestControllerDTO.getEndPoint(), variant);
			mockItemControllerDTO = mapper.map(m, MockItemControllerDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mockItemControllerDTO;
	}

	public MockItemControllerDTO save(MockItemControllerDTO mockItemControllerDTO) {
		try {
			User user = userRepository.findById(1L).get();
			Variant v = variantRepository.findById(mockItemControllerDTO.getVariant().getId()).get();
			
			
			MockItem mockItem = new MockItem();
			
			mockItem.setEndpoint(mockItemControllerDTO.getEndpoint());
			mockItem.setId(mockItemControllerDTO.getId());
			mockItem.setRequestMethodEnum(mockItemControllerDTO.getRequestMethodEnum());
			mockItem.setValue(mockItemControllerDTO.getValue());

			mockItem.setUser_id(user.getId());
			mockItem.setVariant(v);
			
			itemRepository.save(mockItem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<MockItemControllerDTO> getAll() {
        Pageable pageable = PageRequest.of(2, 1, Sort.by("id"));

		Page<MockItem> mockItems = itemRepository.findAll(pageable);
		List<MockItemControllerDTO> mockItemControllerDTOs = new ArrayList<>();
		for(MockItem mockItem: mockItems) {
			MockItemControllerDTO controllerDTO = new MockItemControllerDTO();
			controllerDTO.setEndpoint(mockItem.getEndpoint());
			controllerDTO.setValue(mockItem.getValue());
			controllerDTO.setId(mockItem.getId());
			controllerDTO.setRequestMethodEnum(mockItem.getRequestMethodEnum());
			VariantControllerDTO variantControllerDTO = new VariantControllerDTO();
			variantControllerDTO.setId(mockItem.getVariant().getId());
			variantControllerDTO.setName(mockItem.getVariant().getName());
			controllerDTO.setVariant(variantControllerDTO);
			mockItemControllerDTOs.add(controllerDTO);
		}
		return mockItemControllerDTOs; 
	}


}
