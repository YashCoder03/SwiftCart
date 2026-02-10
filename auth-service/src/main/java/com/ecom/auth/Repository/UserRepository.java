package com.ecom.auth.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.auth.entity.UserEntity;

@Repository
public interface  UserRepository extends  JpaRepository<UserEntity, UUID> {
    
    UserEntity findByEmail(String email);

}
