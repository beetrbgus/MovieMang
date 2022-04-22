package com.moviemang.datastore.domain.member;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Table(name = "Member")
@Data
public class MemberJoinVO2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Email(message = "올바른 이메일이 아닙니다.")
	private String memberEmail;		//회원 이메일
	
	@Length(min = 8,max = 20)
	@NotBlank
	private String memberPassword;	//회원 비밀번호
	
	@Pattern(regexp = "^[Y|N]$")
	private String mailServiceUseYN;
	@NotBlank
	private String memberNick;		//회원 닉네임
	
	private String memberType;		//회원 상태
}
