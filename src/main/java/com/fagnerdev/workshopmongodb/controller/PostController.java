package com.fagnerdev.workshopmongodb.controller;


import com.fagnerdev.workshopmongodb.domain.Post;
import com.fagnerdev.workshopmongodb.domain.User;
import com.fagnerdev.workshopmongodb.dto.UserDTO;
import com.fagnerdev.workshopmongodb.services.PostService;
import com.fagnerdev.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService userService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
                   Post obj = userService.findById(id);
            return ResponseEntity.ok().body(obj);
        }



}



