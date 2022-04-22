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
	@Email(message = "�ùٸ� �̸����� �ƴմϴ�.")
	private String memberEmail;		//ȸ�� �̸���
	
	@Length(min = 8,max = 20)
	@NotBlank
	private String memberPassword;	//ȸ�� ��й�ȣ
	
	@Pattern(regexp = "^[Y|N]$")
	private String mailServiceUseYN;
	@NotBlank
	private String memberNick;		//ȸ�� �г���
	
	private String memberType;		//ȸ�� ����
}
