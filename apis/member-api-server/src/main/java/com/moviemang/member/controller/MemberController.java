package com.moviemang.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.domain.member.MemberJoinVO;
import com.moviemang.datastore.repository.maria.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/member", produces = "application/json")
@CrossOrigin(origins = "*")
public class MemberController {

//	private MemberService memberService;

	private MemberRepository memberRepository;

	@Autowired
	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	} 
	// status ���� �����ϰ� return
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/join" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public void memberJoin(@RequestBody @Valid Member member, Errors error) {
		
		log.info("member : {}", member.getMemberEmail());
		memberRepository.save(member);
	}

}
