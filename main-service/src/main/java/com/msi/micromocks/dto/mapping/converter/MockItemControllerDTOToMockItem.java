package com.msi.micromocks.dto.mapping.converter;

import org.dozer.CustomConverter;
import org.springframework.stereotype.Component;

@Component
public class MockItemControllerDTOToMockItem implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		System.out.println("MockItemControllerDTOToMockItem!!!");
		return null;
	}

}
