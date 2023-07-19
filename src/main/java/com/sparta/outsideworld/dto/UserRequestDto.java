package com.sparta.outsideworld.dto;

import com.sparta.outsideworld.entity.UserRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
	@NotBlank(message = "필수 입력 값입니다.")
	@Pattern(regexp = "^(?=.*?[a-z0-9]).{4,10}$", message = "최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)로 구성되어야 합니다.")
	private String username;
	@NotBlank(message = "필수 입력 값입니다.")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
	private String email;
	@NotBlank(message = "필수 입력 값입니다.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,15}$", message = "최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자로 구성되어야 합니다.")
	private String password;
	@NotBlank(message = "필수 입력 값입니다.")
	private String introduction;
	private String image;	// 프론트에서 default 이미지 부탁합니다

	private UserRoleEnum role;

	// 관리자 권한 로그인
	private boolean admin = false;
	private String adminToken = "";

}
