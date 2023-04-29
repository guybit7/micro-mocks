package com.msi.micromocks.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msi.micromocks.entity.Mock;

@Repository
public interface MocksRepository extends JpaRepository<Mock, Long> {
	ArrayList<Mock> findAllByDeveloperId(long developerId);
}
