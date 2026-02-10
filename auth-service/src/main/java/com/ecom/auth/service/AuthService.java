package com.ecom.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.auth.Repository.UserRepository;
import com.ecom.auth.Util.JwtUtil;
import com.ecom.auth.dto.LoginRequest;
import com.ecom.auth.dto.RegisterRequest;
import com.ecom.auth.entity.UserEntity;


@Service
public class AuthService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtil jwtUtil;
    public void registerUser(RegisterRequest registerRequest){

        String hashPassword = passwordEncoder.encode(registerRequest.getPassword());

        UserEntity userEntity = new UserEntity(registerRequest.getUsername(),registerRequest.getEmail(),hashPassword,registerRequest.getRole());

        userRepository.save(userEntity);
        
    }

    public String loginUser(LoginRequest loginRequest) {

        UserEntity userEntity = userRepository.findByEmail(loginRequest.getEmail());

        boolean result = passwordEncoder.matches(loginRequest.getPassword(),userEntity.getPassword());

        
        
        if(result) {
            String token = jwtUtil.generateToken(loginRequest.getEmail(), userEntity.getRole());
            return token;
        }
        else{
            return "Password Incorrect";
        }

    }
}
