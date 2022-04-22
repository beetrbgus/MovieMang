package com.moviemang.member;

import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.repository.maria.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.annotation.Profile;

@Profile("local")
@SpringBootTest
class MemberApiServerApplicationTests {

	
	private MemberRepository memberRepository;
	
	public MemberApiServerApplicationTests(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
    @Test
    void contextLoads() {
    	Member member = Member.builder()
    			.memberEmail("testUser1@gmail.com")
    			.memberName("TestNick1")
    			.memberPassword("gieiengien2")
    			.build();
    	
    	memberRepository.save(member);
    }

}
