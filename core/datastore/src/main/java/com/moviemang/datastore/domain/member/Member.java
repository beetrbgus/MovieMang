package com.moviemang.datastore.domain.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	@Email(message = "이메일을 올바르게 입력하세요.")
	private String memberEmail; // 이메일

	@NotBlank
	private String memberName; // 닉네임

	@Length(min = 8, max = 20)
	@NotBlank
	private String memberPassword; // 비밀번호

	private String memberType;

	// MariaDB에 기본값으로 넣어야 함
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String regDate; // 회원 등록일

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String modDate; // 회원 수정일

	@Builder
	public Member(Long memberId, String memberEmail, String memberName, String memberPassword, String memberType,
			String regDate, String modDate) {
		this.memberId = memberId;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
	}

}