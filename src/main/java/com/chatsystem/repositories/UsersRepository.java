package com.chatsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatsystem.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    
}
