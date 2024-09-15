package com.chatsystem.services;

import java.security.InvalidKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatsystem.dtos.Auth.UsersSignupDTO;
import com.chatsystem.repositories.UsersRepository;
import com.chatsystem.utils.AuthUtils;
import com.chatsystem.models.Users;

@Service
public class UsersServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthUtils authUtils;


    public Users saveUserDetails(UsersSignupDTO users) throws IllegalArgumentException,InvalidKeyException{
        
        Users modelUsers = new Users();

        modelUsers.setFirstName(users.getFirstName());

        modelUsers.setLastName(users.getLastName());

        modelUsers.setEmail(users.getEmail());

        String encrypt_Password = authUtils.hashpassword(users.getPassword());
        
        modelUsers.setPassword(encrypt_Password);

        return usersRepository.save(modelUsers);
    }
}
