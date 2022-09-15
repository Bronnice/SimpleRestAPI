package com.example.restapi.repository;

import com.example.restapi.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    public UserEntity findBylogin(String login);
}
