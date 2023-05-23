package com.msi.micromocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msi.micromocks.entity.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long>{

}
