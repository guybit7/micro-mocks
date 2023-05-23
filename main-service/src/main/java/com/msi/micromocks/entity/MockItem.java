package com.msi.micromocks.entity;

import com.msi.micromocks.enums.RequestMethodEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mock_item")
public class MockItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "endpoint")
	private String endpoint;

	@Lob
	@Column(name = "value", columnDefinition = "LONGTEXT")
	private String value;

	@Column(name = "user_id")
	private long user_id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "request_method_enum")
	private RequestMethodEnum requestMethodEnum; 
		
	@JoinColumn(name = "variant_id")
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Variant variant;
	
	public MockItem() {
		
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

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public RequestMethodEnum getRequestMethodEnum() {
		return requestMethodEnum;
	}

	public void setRequestMethodEnum(RequestMethodEnum requestMethodEnum) {
		this.requestMethodEnum = requestMethodEnum;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
