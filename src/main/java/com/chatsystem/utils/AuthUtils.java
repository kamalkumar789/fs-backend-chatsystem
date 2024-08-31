package com.chatsystem.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {
    

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String hashpassword(String plainPassword){
        return passwordEncoder.encode(plainPassword);
    }
}
