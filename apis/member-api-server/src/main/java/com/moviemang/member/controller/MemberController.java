package com.moviemang.member.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
