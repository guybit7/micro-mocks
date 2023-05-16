package com.msi.developer.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msi.developer.dto.GroceryItemControllerDTO;
import com.msi.developer.model.GroceryItem;
import com.msi.developer.repository.GroceryRepository;

@Service
public class GroceryService {

	@Autowired
	GroceryRepository groceryRepository;
	
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	public void saveGrocery() {
		GroceryItem groceryItem = new GroceryItem("1", "GUY", 5, "BITON");
		try {
			groceryRepository.save(groceryItem);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public GroceryItemControllerDTO getById(String id) {
		GroceryItem groceryItem = groceryRepository.findById(id).get();		
		GroceryItemControllerDTO controllerDTO = mapper.map(groceryItem, GroceryItemControllerDTO.class);
		return controllerDTO;
	}
}
