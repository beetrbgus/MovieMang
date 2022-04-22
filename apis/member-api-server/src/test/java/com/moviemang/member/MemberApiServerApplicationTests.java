package com.moviemang.member;

import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.repository.maria.MemberRepository;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Profile;

@Profile("local")
@Slf4j
@SpringBootTest
class MemberApiServerApplicationTests {
	
	@Autowired
	private MemberRepository memberRepository;
	
    @Test
    void savePlease() {
		/*
		Member member = Member.builder() .memberEmail("testUser1@gmail.com")
		.memberName("TestNick1") .memberPassword("gieiengien2") .build();
	    log.info("뭐가 나오냐 : {}", member.toString()); 
	    memberRepository.save(member);
		 */
    }

}
