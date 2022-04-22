package com.moviemang.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberApiServerApplicationTests {


	@Autowired
	private MemberRepository memberRepository;
	
    @Test
    void contextLoads() {
    	Member member = new Member();
    	member.setMemberName("TestNick1");
    	member.setMemberEmail("testUser1@gmail.com");
    	member.setMemberPassword("gieiengien2");
    	
    	memberRepository.save(member);
    }

}
