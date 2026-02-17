package com.ecom.auth.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="users")
@Data
public class UserEntity {

    UserEntity(){
        
    }
    
    @Column(unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; 

    @Column(unique = true,nullable = false)
    private String username;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    public UserEntity(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Column(nullable = false)
    private Instant createdAt = Instant.now();
    
}
