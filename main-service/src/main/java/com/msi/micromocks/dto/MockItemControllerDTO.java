package com.msi.micromocks.dto;

import com.msi.micromocks.enums.RequestMethodEnum;

public class MockItemControllerDTO {

	private Long id;
	
	private String endpoint;

	private String value;

	private UserControllerDTO user;
	
	private VariantControllerDTO variant;
	
	private RequestMethodEnum requestMethodEnum;

	public MockItemControllerDTO() {
	
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

	public UserControllerDTO getUser() {
		return user;
	}

	public void setUser(UserControllerDTO user) {
		this.user = user;
	}

	public VariantControllerDTO getVariant() {
		return variant;
	}

	public void setVariant(VariantControllerDTO variant) {
		this.variant = variant;
	}

	public RequestMethodEnum getRequestMethodEnum() {
		return requestMethodEnum;
	}

	public void setRequestMethodEnum(RequestMethodEnum requestMethodEnum) {
		this.requestMethodEnum = requestMethodEnum;
	}
	
	
	
}
