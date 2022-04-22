package com.moviemang.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.domain.member.MemberJoinVO;
import com.moviemang.datastore.repository.member.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	} 
	 
	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}
	
}
