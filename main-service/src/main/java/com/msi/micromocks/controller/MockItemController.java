package com.msi.micromocks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msi.micromocks.dto.MockItemControllerDTO;
import com.msi.micromocks.dto.MockItemInternalRequestControllerDTO;
import com.msi.micromocks.service.MockItemService;

@RestController
@RequestMapping("/api")
@RefreshScope
public class MockItemController {
	
	@Autowired
	private MockItemService mockItemService;
	
	@GetMapping("/mock-item/{id}")
	public MockItemControllerDTO getById(@PathVariable long id) {
		System.out.println(id);
		return mockItemService.getById(id);
	}
	
	@GetMapping("/mock-item/ep/{ep}")
	public MockItemControllerDTO getByEndpoint(@PathVariable String ep) {
		return mockItemService.getByEp(ep);
	}
	
	@PostMapping("/mock-item/value")
	public MockItemControllerDTO doIt(@RequestBody MockItemInternalRequestControllerDTO mockItemRequestControllerDTO) {
		return mockItemService.getMockItem(mockItemRequestControllerDTO);
	}
	
	@PostMapping("/mock-item")
	public MockItemControllerDTO save(@RequestBody MockItemControllerDTO mockItemControllerDTO) {
		System.out.println(mockItemControllerDTO);
		return mockItemService.save(mockItemControllerDTO);
	}
	
	@GetMapping("/mock-items")
	public List<MockItemControllerDTO> getById() {
		return mockItemService.getAll();
	}

}
