package com.msi.micromocks.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msi.micromocks.dto.MockControllerDto;
import com.msi.micromocks.entity.Mock;
import com.msi.micromocks.service.MocksService;

@RestController
@RequestMapping("/api/main")
@RefreshScope
public class MainController {
	
	@Autowired
	MocksService mocksService;
	
	@Value("${address.test}")
	private String test;
	
	public MainController() {
		System.out.println("CTRL");		
	}
	
	@GetMapping("/test/{id}")
	public MockControllerDto getTest(@PathVariable long id) {
		return mocksService.getbyId(id);
	}
	
	@GetMapping("/getByDeveloperId/{id}")
	public ArrayList<Mock> getByDeveloperId(@PathVariable long id) {
		return mocksService.getByDeveloperId(id);
	}

	@GetMapping("/test")
	public String test() {
		return test;
	}
	
	@DeleteMapping("{id}")
	public MockControllerDto deleteById(@PathVariable long id) {
		return mocksService.deleteById(id);
	}
}
