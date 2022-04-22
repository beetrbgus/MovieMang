package com.moviemang.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    void test(Principal principal){
        System.out.println(principal.getName());
    }

}
