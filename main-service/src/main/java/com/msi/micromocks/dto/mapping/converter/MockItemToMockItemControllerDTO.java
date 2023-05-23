package com.msi.micromocks.dto.mapping.converter;

import org.dozer.CustomConverter;

public class MockItemToMockItemControllerDTO implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		System.out.println("MockItemToMockItemControllerDTO!!!");
		return null;
	}

}
