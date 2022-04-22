package com.moviemang.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.repository.member.MemberRepository;
import org.hibernate.validator.constraints.Length;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.repository.member.MemberRepository;

@SpringBootTest
class MemberApiServerApplicationTests {


	@Autowired
	private MemberRepository memberRepository;
	
    @Test
    void contextLoads() {
    	Member member = Member.builder()
    			.memberEmail("testUser1@gmail.com")
    			.memberName("TestNick1")
    			.memberPassword("gieiengien2")
    			.build();
    	
    	Member member = new Member();
    	member.setMemberName("TestNick1");
    	member.setMemberEmail("testUser1@gmail.com");
    	member.setMemberPassword("gieiengien2");
    	
    	memberRepository.save(member);
    }

}
