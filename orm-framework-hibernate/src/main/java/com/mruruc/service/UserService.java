package com.mruruc.service;

import com.mruruc.model.User;
import com.mruruc.repository.CRUD;
import com.mruruc.repository.CRUDImpl;

import java.util.List;
import java.util.UUID;

public class UserService {
    private CRUD<User, UUID> crud;


    public UserService(CRUD<User, UUID> crud) {
        this.crud = new CRUDImpl<>(User.class);
    }

    public List<User> getAllUser(){
        return crud.findAll();
    }

    public User getUserById(UUID id){
        return crud.findById(id).orElseThrow(()-> new RuntimeException("User Not Found!"));
    }

    public User saveUser(User user){
        // assumes some validation logic
        return crud.save(user);
    }

    public User updateUser(UUID userId,User user){
        return crud.update(userId,user);
    }

    public void deleteUser(UUID userId){
        crud.delete(userId);
    }

}
