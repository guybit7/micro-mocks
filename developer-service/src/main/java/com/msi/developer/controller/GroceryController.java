package com.msi.developer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msi.developer.dto.GroceryItemControllerDTO;
import com.msi.developer.service.GroceryService;


@RestController
@RequestMapping("/api/grocery")
public class GroceryController {
	
	@Autowired
	GroceryService groceryService;
	
	@GetMapping
	public void save() {
		System.out.println("grocery ctrl");
		groceryService.saveGrocery();
	}
	
	@GetMapping("/{id}")
	public GroceryItemControllerDTO getById(@PathVariable String id) {
		return groceryService.getById(id);
	}
	
	
}
