package com.example.restapi.services;

import com.example.restapi.exceptions.UserAlreadyExistEsception;
import com.example.restapi.exceptions.UserNotFoundException;
import com.example.restapi.entities.UserEntity;
import com.example.restapi.models.User;
import com.example.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistEsception {
        if(userRepo.findBylogin(user.getLogin()) != null)
        {
            throw new UserAlreadyExistEsception("пользователь с таким логином уже существует");
        }
        return userRepo.save(user);
    }

    public User getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
