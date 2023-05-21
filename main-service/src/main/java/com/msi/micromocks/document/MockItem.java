package com.msi.micromocks.document;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

//@Document("mock_item")
public class MockItem {

	@Id
	private String id;
	   
	private String endPoint;
	   
	private String variant;
	
    private LocalDateTime createdDate;
   
    private LocalDateTime lastUpdate;
	   
	private Object value;
	
	public MockItem(String id, String endPoint, LocalDateTime createdDate, LocalDateTime lastUpdate, Object value) {
		this.id = id;
		this.endPoint = endPoint;
		this.createdDate = createdDate;
		this.lastUpdate = lastUpdate;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	   
}
