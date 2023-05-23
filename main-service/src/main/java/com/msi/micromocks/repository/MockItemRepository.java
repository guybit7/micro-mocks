package com.msi.micromocks.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.msi.micromocks.entity.MockItem;
import com.msi.micromocks.entity.Variant;

public interface MockItemRepository extends JpaRepository<MockItem, Long> {
	
	MockItem findByEndpoint(String endpoint);
	
	MockItem findByEndpointAndVariant(String endpoint, Variant variant);
	
	Page<MockItem> findAll(Pageable pageable);

}
