package com.moviemang.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/member/{id}")
    public void getUserById(@PathVariable String id) {
        // id 유효성 체크

        // id로 Member 조회


        // 응답
    }

}
