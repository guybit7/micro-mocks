package com.msi.micromocks.dto;

import com.msi.micromocks.entity.Mock;
import com.msi.micromocks.entity.Variant;

public class MockControllerDto {

	private Long id;
	
	private String endpoint;

	private String value;

	private DeveloperControllerDTO developer;

	private Variant variant;
	
	public MockControllerDto() {
		
	}
	
	public MockControllerDto(Mock mock) {
		this.id = mock.getId();
		this.endpoint = mock.getEndpoint();
		this.value = mock.getValue();
		this.variant = mock.getVariant();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DeveloperControllerDTO getDeveloper() {
		return developer;
	}

	public void setDeveloper(DeveloperControllerDTO developer) {
		this.developer = developer;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	
}
