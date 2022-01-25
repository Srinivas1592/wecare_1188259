package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
