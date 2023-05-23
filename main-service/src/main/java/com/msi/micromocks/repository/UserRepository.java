package com.msi.micromocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msi.micromocks.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
