package com.moviemang.datastore.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberJoinVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "member_name")
	@NotBlank
	private String nickname;		//닉네임
	
	@Column(name = "member_email")
	@NotNull
	@Email(message = "�ùٸ� �̸����� �ƴմϴ�.")
	private String email;		//이메일
	
	@Column(name = "member_password")
	@Length(min = 8,max = 20)
	@NotBlank
	private String password;	//비밀번호
	
	@Pattern(regexp = "^[Y|N]$")
	private String mail_service_useYn;
}
