package com.study.jpa.controller;

import com.study.jpa.dto.PostsSaveRequestDto;
import com.study.jpa.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {

    /*@Autowired*/
    private PostsRepository postsRepository;

    @GetMapping("")
    public String hello() {
        return "Hello Jpa";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        System.out.println(dto.toString());
        postsRepository.save(dto.toEntity());
    }
}
