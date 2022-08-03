package me.eun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
	
	private String memberName;
	private String memberPw;
	private String memberMail;
	private String memberAddr;
	private int adminCk;
	

	
}
