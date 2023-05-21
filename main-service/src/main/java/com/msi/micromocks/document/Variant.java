package com.msi.micromocks.document;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

//@Document("variant")
public class Variant {

	@Id
	private String id;
	
	private String name;
	
	
}
