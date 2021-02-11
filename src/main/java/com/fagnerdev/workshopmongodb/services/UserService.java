package com.fagnerdev.workshopmongodb.services;

import com.fagnerdev.workshopmongodb.domain.User;
import com.fagnerdev.workshopmongodb.dto.UserDTO;
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

        public User insert(User obj){
        return userRepository.insert(obj);
        }

        public void delete(String id){
         userRepository.deleteById(id);

        }

        public User update(User obj){

        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);

        }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){

        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

        }

}

