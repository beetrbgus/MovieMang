package com.moviemang.member;

import com.moviemang.datastore.domain.maria.User;
import com.moviemang.datastore.repository.maria.UserRepository;
import com.moviemang.member.domain.UserInfo;
import com.moviemang.member.service.TmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Profile("local")
@SpringBootTest
class MemberApiServerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TmpService tmpService;

    @Test
    void contextLoads() {
    }

    @Test
    void insertUser(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userRepository.save(User.builder()
                        .email("test2@naver.com")
                        .password(bCryptPasswordEncoder.encode("pass2"))
                .build());
    }

    @Test
    void getUserInfo(){
        UserInfo.Response response = tmpService.getUserInfo(new UserInfo.Request(){{
            setUserId(1);
        }});

        System.out.println("## response : "+response);
    }

}
