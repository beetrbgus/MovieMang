package com.moviemang.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moviemang.datastore.domain.member.Member;
import com.moviemang.datastore.domain.member.MemberJoinVO;
import com.moviemang.datastore.repository.member.MemberRepository;
import com.moviemang.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/member",produces = "application/json")
@CrossOrigin(origins = "*") 
public class MemberController {
	
//	private MemberService memberService;
	/*
	 * private MemberRepository memberRepository;
	 * 
	 * @Autowired public MemberController(MemberRepository memberRepository) {
	 * this.memberRepository = memberRepository; } //status ���� �����ϰ� return
	 * 
	 * @ResponseStatus(code = HttpStatus.CREATED)
	 * 
	 * @PostMapping(path = "/join") public ResponseEntity<MemberJoinVO>
	 * memberJoin(@ModelAttribute @Valid MemberJoinVO member,Errors error){
	 * 
	 * memberRepository.save(member); if(error.hasErrors()) log.info("에러남"); return
	 * null; }
	 */
}
