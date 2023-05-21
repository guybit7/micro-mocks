package com.msi.micromocks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="variant")
public class Variant {

	@Id
	private Long id;
	
	@Column(name = "name")
	private String name;
	
}
