package com.fagnerdev.workshopmongodb.services;

import com.fagnerdev.workshopmongodb.domain.User;
import com.fagnerdev.workshopmongodb.repository.UserRepository;
import com.fagnerdev.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
       return userRepository.findAll();
    }

    public User findById(String id){

        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));

        }

    }

